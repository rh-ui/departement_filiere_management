package ma.fsts.info.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// import ma.fsts.info.Models.Departement;
import ma.fsts.info.Models.Filiere;

public class FiliereDAO {

    private Connection conn = null;
    public FiliereDAO() {
        try {
            conn = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void addFiliere(Filiere fil) {

        String insertQuery = "INSERT INTO filiere(nom, idDep) VALUES(?, ?);";
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement(insertQuery);
            ps.setString(1, fil.getNom());
            ps.setInt(2, fil.getIdDep());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFiliere(Filiere fil) {

        PreparedStatement ps = null;

        String deleteQuery = "DELETE FROM filiere WHERE idFiliere = ?;";

        try {
            ps = conn.prepareStatement(deleteQuery);
            ps.setInt(1, fil.getCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyFiliere(Filiere fil) {
        PreparedStatement ps = null;

        String modifyQuery = "UPDATE filiere SET nom = ?  WHERE idFiliere = ?;";

        try {
            ps = conn.prepareStatement(modifyQuery);
            ps.setString(1, fil.getNom());
            ps.setInt(2, fil.getCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Filiere getFiliereById(int id) {

        PreparedStatement ps = null;
        ResultSet res = null;
        Filiere fil = null;

        String selectQuery = "SELECT * FROM filiere WHERE idFiliere = ?;";

        try {
            ps = conn.prepareStatement(selectQuery);
            ps.setInt(1, id);
            res = ps.executeQuery();
            if (res.next()) {
                fil = new Filiere(res.getInt(1), res.getString(2), res.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fil;
    }

    public List<Filiere> getAllFiliere() {

        PreparedStatement ps = null;
        ResultSet res = null;
        List<Filiere> fil = new ArrayList<>();

        String selectQuery = "SELECT * FROM filiere;";

        try {
            ps = conn.prepareStatement(selectQuery);
            res = ps.executeQuery();
            while (res.next()) {
                fil.add(new Filiere(res.getInt(1), res.getString(2), res.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fil;
    }
    
    public List<Filiere> getAllFiliereByDepId(int idDep) {

        PreparedStatement ps = null;
        ResultSet res = null;
        List<Filiere> fil = new ArrayList<>();

        String selectQuery = "SELECT * FROM filiere WHERE idDep = ?;";

        try {
            ps = conn.prepareStatement(selectQuery);
            ps.setInt(1, idDep);
            res = ps.executeQuery();
            while (res.next()) {
                fil.add(new Filiere(res.getInt(1), res.getString(2), res.getInt(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fil;
    }

}
