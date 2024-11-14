package ma.fsts.info.Services;

import ma.fsts.info.DAO.UsersDAO;

public class UsersService {

    private static UsersDAO usrsDAO = new UsersDAO();
    
        public static int getUsers(String usrname, String passwd){
            return usrsDAO.getUser(usrname, passwd);
    }


}
