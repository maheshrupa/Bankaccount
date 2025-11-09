/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccountHolderCreate;

import AccountDAO.BankAccountDAOImpl;
import AccountDTO.BankAccountDTO;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mahes
 */
@WebServlet(name = "accountHolderCreatePage", urlPatterns = {"/accountHolderCreatePage"})
public class AccountHolderCreatePage extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String fullname = request.getParameter("fullName");
    String dobString = request.getParameter("dob");
    String email = request.getParameter("email");
    String phone = request.getParameter("phone");
    String password = request.getParameter("password");
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
    bankAccountDTO.setPassword(password);
    BankAccountDAOImpl bankAccountDAOImpl=new BankAccountDAOImpl();
    boolean isUpdated = bankAccountDAOImpl.insertBankAccountDetails(bankAccountDTO);
    if(isUpdated){
        response.sendRedirect("success.jsp");

    }else{
        response.sendRedirect("error.jsp");
    }
    }
}
