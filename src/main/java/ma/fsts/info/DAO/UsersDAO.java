package ma.fsts.info.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ma.fsts.info.Models.Users;

public class UsersDAO {

    private Connection conn = null;

    public UsersDAO() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addUser(Users usr) {

        String insertQuery = "INSERT INTO users(username, password, role) VALUES (?, ?, ?);";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(insertQuery);
            ps.setString(1, usr.getUsername());
            ps.setString(2, usr.getPasswd());
            ps.setString(3, usr.getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getUser(String usrname, String passwd) {

        String selectQuery = "SELECT id FROM users WHERE username = ? AND password = ?;";
        PreparedStatement ps = null;
        ResultSet res = null;
        int userId = -1;

        try {
            ps = conn.prepareStatement(selectQuery);
            ps.setString(1, usrname);
            ps.setString(2, passwd);
            res = ps.executeQuery();
            if (res.next()) {
                userId = res.getInt("id"); // Utiliser le nom de la colonne "id" directement
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return userId;
    }
}
