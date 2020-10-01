package ch.heigvd.amt.stackovergoat.presentation;

import ch.heigvd.amt.stackovergoat.business.UserManager;
import ch.heigvd.amt.stackovergoat.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends javax.servlet.http.HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String error = "En phase d'implémentation " + username + " " + password;
        UserManager manager = new UserManager();
        User user = manager.getUser(username);

        if(user != null && user.getPassword().equals(password)) {
            req.setAttribute("user", user);
        } else {
            req.setAttribute("error", error);
        }

        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }

}
