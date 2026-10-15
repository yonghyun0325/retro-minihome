package kr.co.retrominihome.common.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.co.retrominihome.common.db.DataSourceProvider;

/** 서버가 켜질 때 커넥션 풀을 만들고, 꺼질 때 정리한다 */
@WebListener
public class DataSourceListener implements ServletContextListener {

    private static final Logger log = LoggerFactory.getLogger(DataSourceListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DataSourceProvider.init();
        checkConnection();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DataSourceProvider.close();
    }

    /** 풀에서 커넥션을 하나 빌려 간단한 쿼리를 실행해 보고 돌려준다 */
    private void checkConnection() {
        String sql = "SELECT VERSION(), DATABASE(), CURRENT_USER()";
        try (Connection conn = DataSourceProvider.getDataSource().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                log.info("DB 연결 확인: MySQL {}, DB={}, 계정={}", rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("DB 연결 확인에 실패했습니다", e);
        }
    }
}
