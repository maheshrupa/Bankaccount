package EditAccountHolder;

import AccountDAO.BankAccountDAOImpl;
import AccountDTO.BankAccountDTO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "editAccountHolder", urlPatterns = {"/editAccountHolder"})
public class editAccountHolder extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        BankAccountDAOImpl bankAccountDAOImpl = new BankAccountDAOImpl();
        String accountNumberString = request.getParameter("accountNumber");
        int accountNumber = 0;

        try {
            accountNumber = Integer.parseInt(accountNumberString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        bankAccountDTO = bankAccountDAOImpl.updateAccountHolder(accountNumber);
        request.setAttribute("bankAccountHolder", bankAccountDTO);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editAccountHolder.jsp");
        dispatcher.forward(request, response);
    }
}
