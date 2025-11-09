/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InstallmentDAO;

/**
 *
 * @author mahes
 */
import InstallmentDTO.InstallmentDTO;
import MaheshDBconnection.DMSMaheshConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstallmentDAOImp implements InstallmentDAO {

    @Override
    public void addInstallment(InstallmentDTO installment) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public InstallmentDTO getInstallmentById(int installmentId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InstallmentDTO> getAllInstallments() throws SQLException {
        List<InstallmentDTO> installments = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        StringBuffer sql = new StringBuffer("SELECT * FROM Installment");

        DMSMaheshConnection dmsMahesh = new DMSMaheshConnection();

        resultSet = dmsMahesh.getData(sql);
            while (resultSet.next()) {
                InstallmentDTO installment = new InstallmentDTO();
                installment.setInstallmentId(resultSet.getInt("installment_id"));
                installment.setUserId(resultSet.getInt("user_id"));
                installment.setGrossPremium(resultSet.getDouble("gross_premium"));
                installment.setCommissionPercentage(resultSet.getDouble("commission_percentage"));
                installment.setCommissionAmount(resultSet.getDouble("commission_amount"));
                installment.setNetPremium(resultSet.getDouble("net_premium"));
                installment.setFinalAmount(resultSet.getDouble("final_amount"));
                installment.setTax(resultSet.getDouble("tax")); // Retrieving tax value
                installments.add(installment);
            }
        return installments;
    }

    @Override
    public void updateInstallment(InstallmentDTO installment) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteInstallment(int installmentId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}

