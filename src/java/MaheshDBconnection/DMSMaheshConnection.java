/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaheshDBconnection;

import MaheshDB.MaheshDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mahes
 */
public class DMSMaheshConnection implements  MaheshDB {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management_system?useSSL=false", "root", "Mahesh@96");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public ResultSet getData(StringBuffer sqlquery){
        ResultSet resultSet = null;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
 
    try {
        connection = getConnection();
        preparedStatement = connection.prepareStatement(sqlquery.toString());
        resultSet = preparedStatement.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle database errors
    }

    // Note: Do not close the ResultSet, PreparedStatement, or Connection here
    // Close them in the calling method after processing the ResultSet
    return resultSet;}
    
@Override
public boolean insertData(PreparedStatement pstmt) {
    Connection connection = null;
    boolean success = false;

    try {
        connection = getConnection();
        int rs = pstmt.executeUpdate();
        if (rs > 0) {
            success = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources in reverse order of creation
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    return success;
}@Override
public boolean deleteQuery(int accountNumber) {
    PreparedStatement preparedStatement = null;
    String sql = "DELETE FROM BankAccountApplication WHERE accountNumber = ?";
    
    Connection connection = null;
    boolean success = false;
    try {
        connection = getConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, accountNumber); // Set the parameter value
        int rsForDelete = preparedStatement.executeUpdate();
        
        if (rsForDelete > 0) {
            success = true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close resources in reverse order of creation
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    return success;
}

    @Override
    public boolean updateQuery(boolean isUpdated) {
        
        return true;
    }

}
