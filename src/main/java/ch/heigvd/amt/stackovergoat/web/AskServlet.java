package ch.heigvd.amt.stackovergoat.web;

import ch.heigvd.amt.stackovergoat.services.QuestionManager;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "AskServlet")
public class AskServlet extends javax.servlet.http.HttpServlet {
    QuestionManager questionManager = new QuestionManager();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        request.setAttribute("questions", questionManager.getQuestions());
        request.getRequestDispatcher("/WEB-INF/pages/home.jsp").forward(request, response);
    }
}
