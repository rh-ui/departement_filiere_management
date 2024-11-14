package ma.fsts.info.Services;

import java.util.List;

import ma.fsts.info.DAO.DepartementDAO;
import ma.fsts.info.Models.Departement;

public class DepartementService {

    private DepartementDAO depDAO = new DepartementDAO();

    public List<Departement> getAll() {
        return depDAO.getAllDepartement();
    }

    public Departement getById(int idDep){
        return depDAO.getDepartementById(idDep);
    }

    public void addDep(Departement dep) {
        depDAO.addDepartement(dep);
    }

    public void delete(Departement dep) {
        depDAO.deleteDepartement(dep);
    }

    public void updateDep(Departement department) {
        depDAO.modifyDepartement(department);
    }


}
