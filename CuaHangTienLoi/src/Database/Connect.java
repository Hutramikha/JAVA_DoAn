package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static Connection getConnection() {
        Connection c = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // Các thông số 
            String url = "jdbc:mysql://localhost:3306/store";
            String username = "root";
            String password = "";
            // Tạo kết nối
            c = DriverManager.getConnection(url, username, password);
            System.out.println("OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printInfo(Connection c) {
        try {
            if (c != null) {
                java.sql.DatabaseMetaData mtdt = c.getMetaData();
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection c = Connect.getConnection();

        Connect.printInfo(c);
        Connect.closeConnection(c);
    }
}
