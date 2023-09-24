package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/" })
public class ControllerServet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        AccountRepository accountRepository = new AccountRepository();
        if (action.equals("listAccount")) {
            List<Account> accountList = accountRepository.getAllAcc(); // thế phương thức và nguồn dữ liệu thực tế
            request.setAttribute("accountList", accountList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/account/listAccount.jsp"); // thế đường
                                                                                                            // dẫn JSP
                                                                                                            // thực tế
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        AccountRepository accountRepository = new AccountRepository();

        if (action.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            Account account = new Account();
            account = accountRepository.login(username, password);
            if (account != null) {
                HttpSession session = request.getSession();
                session.setAttribute("session_name", account.getFull_name());
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/dashboard.jsp");
                requestDispatcher.include(request, response);
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Login sucess!');");
                out.println("</script>");
            } else {
                PrintWriter out = response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Login failse! Please login again!');");
                out.println("location = 'index.jsp';");
                out.println("</script>");
            }

        }
    }

}
