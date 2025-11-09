/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstallmentDAO;

import InstallmentDTO.InstallmentDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author mahes
 */
public interface InstallmentDAO {
    
    // Insert a new installment record
    public void addInstallment(InstallmentDTO installment) throws SQLException;

    // Retrieve a single installment by ID
    public InstallmentDTO getInstallmentById(int installmentId) throws SQLException;

    // Retrieve all installments
    public List<InstallmentDTO> getAllInstallments() throws SQLException;

    // Update an existing installment
    public void updateInstallment(InstallmentDTO installment) throws SQLException;

    // Delete an installment by ID
    public void deleteInstallment(int installmentId) throws SQLException;
    
}
