/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDAO;

import MaheshDBconnection.DMSMaheshConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import userDTO.userDTO;

/**
 *
 * @author mahes
 */
public class UserDAOImp implements UserDAO{

    @Override
    public boolean userAdd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean getUserById(int id) {
        DMSMaheshConnection dmsMaheshConnection=new DMSMaheshConnection();
        StringBuffer sqlQuery=new StringBuffer("select * from usr where userid =");
        sqlQuery=sqlQuery.append(id);
        //ResultSet resultSet=null;
        userDTO user=new userDTO();
        try (ResultSet resultSet = dmsMaheshConnection.getData(sqlQuery)) {
            if (resultSet.next()) {
                user.setUserFromResultSet(resultSet);
                return user.isIsActive();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean getUser(String username, String Password) {
        DMSMaheshConnection dmsMaheshConnection=new DMSMaheshConnection();
        StringBuffer sqlQuery=new StringBuffer("select * from usr where username= '");
        sqlQuery.append(username);
        sqlQuery.append("' and password ='");
        sqlQuery.append(Password);
        sqlQuery.append("'");        
        userDTO user=new userDTO();
        try (ResultSet resultSet = dmsMaheshConnection.getData(sqlQuery)) {
            if (resultSet.next()) {
                user.setUserFromResultSet(resultSet);
                return user.isIsActive();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
