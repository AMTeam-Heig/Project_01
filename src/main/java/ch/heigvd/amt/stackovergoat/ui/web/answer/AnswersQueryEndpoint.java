package ch.heigvd.amt.stackovergoat.ui.web.answer;

import ch.heigvd.amt.stackovergoat.application.ServiceRegistry;
import ch.heigvd.amt.stackovergoat.application.answer.AnswerFacade;
import ch.heigvd.amt.stackovergoat.application.answer.AnswersDTO;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AnswersPageHandler", urlPatterns = "/home")
public class AnswersQueryEndpoint extends HttpServlet {

    private ServiceRegistry serviceRegistry;
    private AnswerFacade answerFacade;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceRegistry = ServiceRegistry.getServiceRegistry();
        answerFacade = serviceRegistry.getAnswerFacade();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnswersDTO answersDTO = answerFacade.getAllAnswers();
        req.setAttribute("answers", answersDTO);
        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
    }
}
