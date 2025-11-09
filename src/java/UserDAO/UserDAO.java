/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserDAO;

/**
 *
 * @author mahes
 */
public interface UserDAO {
    public boolean userAdd();
    public boolean getUserById(int id);
    public boolean getUser(String username,String Password);
}
