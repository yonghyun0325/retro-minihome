package kr.co.retrominihome.common.db;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

/**
 * 앱 전체가 함께 쓰는 커넥션 풀을 하나만 만들고 관리한다.
 * 서버가 켜질 때 init(), 꺼질 때 close() 를 DataSourceListener 가 호출한다.
 */
public final class DataSourceProvider {

    private static final String CONFIG_FILE = "db.properties";

    private static HikariDataSource dataSource;

    private DataSourceProvider() {
        // 객체를 만들지 않고 static 메서드로만 쓴다
    }

    public static synchronized void init() {
        if (dataSource != null) {
            return;
        }
        Properties props = loadConfig();

        HikariConfig config = new HikariConfig();
        config.setPoolName("retro-minihome-pool");
        config.setDriverClassName(required(props, "db.driver"));
        config.setJdbcUrl(required(props, "db.url"));
        config.setUsername(required(props, "db.username"));
        config.setPassword(required(props, "db.password"));
        config.setMaximumPoolSize(Integer.parseInt(props.getProperty("db.pool.maximumPoolSize", "10").trim()));

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        if (dataSource == null) {
            throw new IllegalStateException("커넥션 풀이 아직 만들어지지 않았습니다");
        }
        return dataSource;
    }

    public static synchronized void close() {
        if (dataSource != null) {
            dataSource.close();
            dataSource = null;
        }
    }

    /** classpath 에 있는 db.properties 를 UTF-8 로 읽는다 */
    private static Properties loadConfig() {
        try (InputStream in = DataSourceProvider.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (in == null) {
                throw new IllegalStateException(CONFIG_FILE + " 이 없습니다. db.properties.example 을 복사해서 만드세요");
            }
            Properties props = new Properties();
            props.load(new InputStreamReader(in, StandardCharsets.UTF_8));
            return props;
        } catch (IOException e) {
            throw new IllegalStateException(CONFIG_FILE + " 을 읽지 못했습니다", e);
        }
    }

    /** 꼭 있어야 하는 값이 비어 있으면 어떤 키가 빠졌는지 알려주고 멈춘다 */
    private static String required(Properties props, String key) {
        String value = props.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException(CONFIG_FILE + " 에 " + key + " 값이 없습니다");
        }
        return value.trim();
    }
}
