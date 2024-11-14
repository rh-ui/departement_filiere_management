package ma.fsts.info.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ma.fsts.info.Models.Departement;

public class DepartementDAO {

    Connection conn = null;

    public DepartementDAO() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDepartement(Departement dep) {

        String insertQuery = "INSERT INTO departement(nom) VALUES(?)";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(insertQuery);
            ps.setString(1, dep.getNom());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDepartement(Departement dep) {
        PreparedStatement ps = null;

        String deleteQuery = "DELETE FROM departement WHERE idDep = ?;";

        try {
            ps = conn.prepareStatement(deleteQuery);
            ps.setInt(1, dep.getIdDep());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyDepartement(Departement dep) {
        PreparedStatement ps = null;

        String modifyQuery = "UPDATE departement SET nom = ?  WHERE idDep = ?;";

        try {
            ps = conn.prepareStatement(modifyQuery);
            ps.setString(1, dep.getNom());
            ps.setInt(2, dep.getIdDep());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Departement getDepartementById(int id) {
        PreparedStatement ps = null;
        ResultSet res = null;
        Departement dep = null;

        String selectQuery = "SELECT * FROM departement WHERE idDep = ?;";

        try {
            ps = conn.prepareStatement(selectQuery);
            ps.setInt(1, id);
            res = ps.executeQuery();
            if (res.next()) {
                dep = new Departement(res.getInt(1), res.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dep;
    }

    public List<Departement> getAllDepartement() {

        PreparedStatement ps = null;
        ResultSet res = null;
        List<Departement> dep = new ArrayList<>();

        String selectQuery = "SELECT * FROM departement;";

        try {
            ps = conn.prepareStatement(selectQuery);
            res = ps.executeQuery();
            while (res.next()) {
                dep.add(new Departement(res.getInt(1), res.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dep;
    }
}
