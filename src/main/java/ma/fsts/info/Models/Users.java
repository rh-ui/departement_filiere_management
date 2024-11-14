package ma.fsts.info.Models;

public class Users {

    private int id;
    private String usrname, passwd, role;

    public Users(int id, String usrname, String passwd, String role){
        this.id = id;
        this.passwd = passwd;
        this.role = role;
        this.usrname = usrname;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return usrname;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getRole() {
        return role;
    }

}
