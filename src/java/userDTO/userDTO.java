/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mahes
 */
public class userDTO {
    private int userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String userType;
    private boolean isActive;
    
    public void setUserFromResultSet(ResultSet resultSet) throws SQLException {
        this.userId = resultSet.getInt("userid");
        this.username = resultSet.getString("username");
        this.password = resultSet.getString("password");
        this.firstName = resultSet.getString("firstName");
        this.lastName = resultSet.getString("lastName");
        this.userType = resultSet.getString("userType");
        this.isActive = resultSet.getBoolean("isActive");
    }
    public userDTO(){
        
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userid) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
}
