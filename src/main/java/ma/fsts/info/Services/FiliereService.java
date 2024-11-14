package ma.fsts.info.Services;

import java.util.List;

import ma.fsts.info.DAO.FiliereDAO;
import ma.fsts.info.Models.Filiere;

public class FiliereService {

    private FiliereDAO filDAO = new FiliereDAO();

    public List<Filiere> getAll(){
        return filDAO.getAllFiliere();
    }


    public Filiere getById(int id){
        return filDAO.getFiliereById(id);
    }

    public void add(Filiere fil){
        filDAO.addFiliere(fil);
    }

    public void delete(Filiere fil){
        filDAO.deleteFiliere(fil);
    }


    public void modifyF(Filiere filiere) {
        filDAO.modifyFiliere(filiere);
    }
}
