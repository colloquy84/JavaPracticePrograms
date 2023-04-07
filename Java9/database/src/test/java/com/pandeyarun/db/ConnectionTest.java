package com.pandeyarun.db;
/*
 * Created by pandeyar on 07/12/2017
 */

import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class ConnectionTest {

    @Test
    public void connection() throws SQLException {
        assertNotNull(ConnDB.instance().getDBConnection());
    }
}