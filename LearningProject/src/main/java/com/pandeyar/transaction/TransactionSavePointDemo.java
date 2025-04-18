package com.pandeyar.transaction;

import java.sql.*;

public class TransactionSavePointDemo {

    public static void main(String[] args) {
        TransactionSavePointDemo transactionDemo = new TransactionSavePointDemo();
        transactionDemo.demoTransactionSavePoint();
    }

    public void demoTransactionSavePoint() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        boolean result = false;

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con = DriverManager.getConnection("jdbc:odbc:sampleDB", "", "");

            con.setAutoCommit(false);


            ps = con
                    .prepareStatement("INSERT INTO DEPARTMENT (DEPTID, DEPTNAME) VALUES(1,'FINANCE')");
            result = ps.execute();

            ps = con
                    .prepareStatement("INSERT INTO DEPARTMENT (DEPTID, DEPTNAME) VALUES(2,'ABC')");
            result = ps.execute();

            Savepoint savepoint = con.setSavepoint();

            ps = con
                    .prepareStatement("INSERT INTO DEPARTMENT (DEPTID, DEPTNAME) VALUES(3,'DEf')");
            result = ps.execute();

            ps = con
                    .prepareStatement("INSERT INTO DEPARTMENT (DEPTID, DEPTNAME) VALUES(4,'XYZ')");
            result = ps.execute();

            con.rollback(savepoint);
            con.commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();

                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
