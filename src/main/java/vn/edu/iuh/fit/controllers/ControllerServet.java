package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.edu.iuh.fit.models.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.service.AccountServices;
import vn.edu.iuh.fit.service.GrantAccessServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ControllerServlet", urlPatterns = { "/" })
public class ControllerServet extends HttpServlet {

    // @Override
    // protected void doGet(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // String action = request.getParameter("action");
    // AccountRepository accountRepository = new AccountRepository();
    // if (action.equals("listAccount")) {
    // List<Account> accountList = accountRepository.getAllAcc(); // thế phương thức
    // và nguồn dữ liệu thực tế
    // request.setAttribute("accountList", accountList);
    // RequestDispatcher requestDispatcher =
    // request.getRequestDispatcher("/account/listAccount.jsp"); // thế đường
    // // dẫn JSP
    // // thực tế
    // requestDispatcher.forward(request, response);
    // }
    // }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse
    // response)
    // throws ServletException, IOException {
    // String action = request.getParameter("action");
    // AccountRepository accountRepository = new AccountRepository();

    // if (action.equals("login")) {
    // String username = request.getParameter("username");
    // String password = request.getParameter("password");
    // Account account = new Account();
    // account = accountRepository.login(username, password);
    // if (account != null) {
    // HttpSession session = request.getSession();
    // session.setAttribute("session_name", account.getFull_name());
    // RequestDispatcher requestDispatcher =
    // request.getRequestDispatcher("/dashboard.jsp");
    // requestDispatcher.include(request, response);
    // PrintWriter out = response.getWriter();
    // out.println("<script type=\"text/javascript\">");
    // out.println("alert('Login sucess!');");
    // out.println("</script>");
    // } else {
    // PrintWriter out = response.getWriter();
    // out.println("<script type=\"text/javascript\">");
    // out.println("alert('Login failse! Please login again!');");
    // out.println("location = 'index.jsp';");
    // out.println("</script>");
    // }

    // }
    // }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accountId = req.getParameter("accountId");
        String pwd = req.getParameter("pwd");
        Account account = AccountServices.searchAccount(accountId);
        if (account != null) {
            if (!account.getPassword().equals(pwd)) {
                Cookie cookie = new Cookie("state_login", "user_pwd_fail");
                resp.addCookie(cookie);
                resp.sendRedirect("login.html");
            } else {
                Cookie cookie = new Cookie("state_login", "oke");
                resp.addCookie(cookie);
                if (GrantAccessServices.searchGrantAccessByAccountId(accountId).getRole().getRole_id()
                        .equals("admin")) {
                    HttpSession session = req.getSession();
                    Date date = new Date();

                    session.setAttribute("accountId", accountId);
                    session.setAttribute("timeIn", new Timestamp(date.getTime()));

                    req.setAttribute("account", account);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard_admin.jsp");
                    requestDispatcher.forward(req, resp);
                } else {
                    req.setAttribute("account", account);
                    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/dashboard_user.jsp");
                    requestDispatcher.forward(req, resp);
                }

            }
        } else {
            Cookie cookie = new Cookie("state_login", "user_null");
            resp.addCookie(cookie);
            resp.sendRedirect("login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = req.getParameter("action");
        System.out.println(str);
    }
}
