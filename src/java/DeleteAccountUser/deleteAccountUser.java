/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeleteAccountUser;

import AccountDAO.BankAccountDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mahes
 */
@WebServlet(name = "deleteAccountUser", urlPatterns = {"/deleteAccountUser"})
public class deleteAccountUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accountNumberString = request.getParameter("accountNumber");
        int accountNumber = Integer.parseInt(accountNumberString);

        BankAccountDAOImpl bankAccountDAOImpl=new BankAccountDAOImpl();
        Boolean isDeleted=bankAccountDAOImpl.deleteAccountHolder(accountNumber);
        if(isDeleted){
            response.sendRedirect("deleteSuccess.jsp");

        }else{
            response.sendRedirect("error.jsp");
        }
    }

}
