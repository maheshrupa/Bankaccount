/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateAccountHolder;

import AccountDAO.BankAccountDAOImpl;
import AccountDTO.BankAccountDTO;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mahes
 */
@WebServlet(name = "updateAccountHolder", urlPatterns = {"/updateAccountHolder"})
public class updateAccountHolder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String fullname = request.getParameter("fullName");
                String dobString = request.getParameter("dob");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String accountNumber=request.getParameter("accountId");
                int AccountNumber=Integer.parseInt(accountNumber);
                BankAccountDTO bankAccountDTO=new BankAccountDTO();
                LocalDate createDate=LocalDate.now();
                bankAccountDTO.setCreatedDate(createDate);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dob = LocalDate.parse(dobString, formatter);
                bankAccountDTO.setDob(dob);
                bankAccountDTO.setCreatedDate(LocalDate.MAX);
                bankAccountDTO.setFullName(fullname);
                bankAccountDTO.setEmail(email);
                bankAccountDTO.setPhone(phone);
                bankAccountDTO.setAccountNumber(AccountNumber);
                BankAccountDAOImpl bankAccountDAOImpl=new BankAccountDAOImpl();
                boolean isUpdated =bankAccountDAOImpl.updatedAccountHolderDetails(bankAccountDTO);
                if(isUpdated){
                 response.sendRedirect("updateSuccess.jsp");

                }else{
                response.sendRedirect("error.jsp");

                    
                }
                
        
    }

}
