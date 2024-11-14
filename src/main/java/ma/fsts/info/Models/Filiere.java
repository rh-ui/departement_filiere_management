package ma.fsts.info.Models;

public class Filiere {

    private int code;
    private String nom;
    private int idDep;

    public Filiere(int code, String nom, int idDep){
        this.code = code;
        this.nom = nom;
        this.idDep = idDep;
    }

    public int getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public int getIdDep() {
        return idDep;
    }

    
}
