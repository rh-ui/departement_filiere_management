package ma.fsts.info.DAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import java.sql.Connection;
// import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DataSource dataSource;

    public DatabaseConnection(){}

    static {
        try {
            InitialContext ctx = new InitialContext();
            // Using JNDI lookup for DataSource
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/gestionAcademiqueDS");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // // Instance unique de DatabaseConnection (Singleton)
    // private static volatile DatabaseConnection databaseConnection;
    // private Connection conn;

    // // Constructeur privé pour empêcher l'instanciation multiple
    // private DatabaseConnection() {
    //     try {
    //         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_academique", "root", "");
    //     } catch (SQLException e) {
    //         System.err.println("Failed to establish connection: " + e.getMessage());
    //         e.printStackTrace();
    //     }
    // }

    // // Méthode pour obtenir l'instance unique avec synchronisation thread-safe
    // public static DatabaseConnection getInstance() {
    //     if (databaseConnection == null) {
    //         synchronized (DatabaseConnection.class) {
    //             if (databaseConnection == null) {
    //                 databaseConnection = new DatabaseConnection();
    //             }
    //         }
    //     }
    //     return databaseConnection;
    // }

    // // Retourne la connexion active
    // public Connection getConnection() {
    //     return conn;
    // }

    // // Méthode pour fermer la connexion de manière sécurisée
    // public void closeConnection() {
    //     if (conn != null) {
    //         try {
    //             conn.close();
    //         } catch (SQLException e) {
    //             System.err.println("Failed to close connection: " + e.getMessage());
    //         }
    //     }
    // }
}
