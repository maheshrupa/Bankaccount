/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userAccess;

import InstallmentDAO.InstallmentDAOImp;
import InstallmentDTO.InstallmentDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mahes
 */
@WebServlet(name = "UserLogOut", urlPatterns = {"/UserLogOut"})
public class UserLogOut extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    
                String action = request.getParameter("action");
                if ("logout".equals(action)) {
                HttpSession session=request.getSession();
                        session.removeAttribute("username");
                        response.sendRedirect("login.jsp");
                } else if ("premium".equals(action)) {
                // Redirect to premium screen
                //InstallmentDAOImp installments=new InstallmentDAOImp();
                        List<InstallmentDTO> installments = new ArrayList<>();
                        InstallmentDAOImp Installment =new InstallmentDAOImp();
                    try {
                        installments=Installment.getAllInstallments();
                        request.setAttribute("installments", installments);
                        request.getRequestDispatcher("PremiumScreen.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        Logger.getLogger(UserLogOut.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
}
    

}
