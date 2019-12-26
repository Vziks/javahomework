package info.vziks.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JBDCLesson {

    public static void createTable() {

        String postgresConnection = "jdbc:postgresql://localhost:5432/lessons";
        String postgresLogin = "vziks";
        String sql =
                "CREATE TABLE IF NOT EXISTS book(" +
                        "id bigserial PRIMARY KEY, " +
                        "title VARCHAR (50) NOT NULL, " +
                        "pages INTEGER NOT NULL);";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(postgresConnection, postgresLogin, null)
        ) {
            try (Statement statement = connection.createStatement()) {
                boolean status = statement.execute(sql);

                System.out.println(status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        JBDCLesson.createTable();
    }
}
