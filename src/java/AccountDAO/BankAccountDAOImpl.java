/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountDAO;

import AccountDTO.BankAccountDTO;
import MaheshDBconnection.DMSMaheshConnection;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mahes
 */
public class BankAccountDAOImpl implements BankAccountDAO {
@Override
public boolean insertBankAccountDetails(BankAccountDTO bankAccountDTO) {
    if (bankAccountDTO != null) {
        try (Connection connection = new DMSMaheshConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "INSERT INTO BankAccountApplication (fullName, email, phone, dob, password, createdDate) VALUES (?, ?, ?, ?, ?, CURDATE())")) {

            pstmt.setString(1, bankAccountDTO.getFullName());
            pstmt.setString(2, bankAccountDTO.getEmail());
            pstmt.setString(3, bankAccountDTO.getPhone());
            pstmt.setDate(4, java.sql.Date.valueOf(bankAccountDTO.getDob()));
            pstmt.setString(5, bankAccountDTO.getPassword());
            boolean isInserted = pstmt.executeUpdate() > 0;
            return isInserted; // Return the result directly
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if an exception occurred
        }
    }
    return false; // Return false if bankAccountDTO is null
}

    @Override
    public List<BankAccountDTO> getAllAccountHolders() {
                List<BankAccountDTO> bankAccountHolders = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        try {
            // Obtain database connection
            DMSMaheshConnection dmsMahesh = new DMSMaheshConnection();
            // Prepare SQL query
            StringBuffer sql = new StringBuffer("SELECT accountNumber, fullName, email, dob, createdDate FROM BankAccountApplication");
            resultSet = dmsMahesh.getData(sql);

            // Process ResultSet and populate list of users
            while (resultSet.next()) {
                BankAccountDTO bankAccountHolder = new BankAccountDTO();
                bankAccountHolder.setAccountNumber(resultSet.getInt("accountNumber"));
                bankAccountHolder.setFullName(resultSet.getString("fullName"));
                bankAccountHolder.setEmail(resultSet.getString("email"));
                // Convert Date to LocalDate
                Date dob = resultSet.getDate("dob");
                LocalDate localDate = dob.toLocalDate();
                bankAccountHolder.setDob(localDate);

                // Similarly, convert the createdDate if it's a Date object
                Date createdDate = resultSet.getDate("createdDate");
                LocalDate createdLocalDate = createdDate.toLocalDate();
                bankAccountHolder.setCreatedDate(createdLocalDate);
                bankAccountHolders.add(bankAccountHolder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle database errors
        } finally {
            // Close resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                // Do not close preparedStatement and connection here
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Handle resource closing errors
            }
        }
        return bankAccountHolders;
    }

    @Override
    public boolean deleteAccountHolder(int accountNumber) {   
        
        DMSMaheshConnection dmsMahesh = new DMSMaheshConnection();
        boolean isDeleted=dmsMahesh.deleteQuery(accountNumber);
    return isDeleted;
    }
   
    
@Override
public BankAccountDTO updateAccountHolder(int accountNumber) {
    BankAccountDTO bankAccountDTO = null;
    String query = "SELECT accountNumber, fullName, email, dob,phone FROM BankAccountApplication WHERE accountNumber = ?";
    
    try (Connection connection = new DMSMaheshConnection().getConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
        
        pstmt.setInt(1, accountNumber);
        try (ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
                bankAccountDTO = new BankAccountDTO();
                bankAccountDTO.setAccountNumber(resultSet.getInt("accountNumber"));
                bankAccountDTO.setDob(resultSet.getDate("dob").toLocalDate());
                bankAccountDTO.setEmail(resultSet.getString("email"));
                bankAccountDTO.setFullName(resultSet.getString("fullName"));
                bankAccountDTO.setPhone(resultSet.getString("phone"));
            } else {
                Logger.getLogger(BankAccountDAOImpl.class.getName()).log(Level.WARNING, "No account found for account number: {0}", accountNumber);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(BankAccountDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
    }

    return bankAccountDTO;
}
@Override
public boolean updatedAccountHolderDetails(BankAccountDTO bankAccountDTO) {
    if (bankAccountDTO != null) {
        try (Connection connection = new DMSMaheshConnection().getConnection();
             PreparedStatement pstmt = connection.prepareStatement(
                     "UPDATE BankAccountApplication SET fullname=?, email=?, phone=?, dob=? WHERE accountNumber=?")) {
            pstmt.setString(1, bankAccountDTO.getFullName());
            pstmt.setString(2, bankAccountDTO.getEmail());
            pstmt.setString(3, bankAccountDTO.getPhone());
            pstmt.setDate(4, java.sql.Date.valueOf(bankAccountDTO.getDob()));
            pstmt.setInt(5, bankAccountDTO.getAccountNumber());
            //pstmt.setInt(5, bankAccountDTO.getAccountId()); // Assuming there is an accountId to identify the row
            
            boolean isUpdated = pstmt.executeUpdate() > 0;
            return isUpdated;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    return false;
}
    }


    

