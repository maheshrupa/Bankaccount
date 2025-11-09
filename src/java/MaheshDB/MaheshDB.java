/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaheshDB;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author mahes
 */
public interface MaheshDB {
    public Connection getConnection();
    public boolean insertData(PreparedStatement pstmt);
    public boolean deleteQuery(int AccountNumber);
    public boolean updateQuery(boolean isUpdated);
    
}
