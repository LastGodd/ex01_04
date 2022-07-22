package org.zerock.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
    private static final String URL = "jdbc:oracle:thin:@3.36.138.247:1522:xe";
    private static final String ID = "huny22";
    private static final String PW = "huny22";

    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {
        try (Connection con = DriverManager.getConnection(URL, ID, PW)) {
            log.info(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}