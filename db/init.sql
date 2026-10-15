-- 로컬 개발용 DB 와 앱 전용 계정 만들기 (root 로 한 번만 실행)
-- 사용법: mysql -u root -p 로 접속한 뒤 source db/init.sql

CREATE DATABASE retro_minihome
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_0900_ai_ci;

-- 비밀번호는 MySQL 이 무작위로 만들어 화면에 한 번만 보여준다. 그 값을 db.properties 에 적는다
CREATE USER 'minihome_app'@'localhost' IDENTIFIED BY RANDOM PASSWORD;

-- 앱은 데이터 읽기·쓰기만 한다. 테이블 생성·변경·삭제는 root 로 스크립트를 실행해서 한다
GRANT SELECT, INSERT, UPDATE, DELETE ON retro_minihome.* TO 'minihome_app'@'localhost';
