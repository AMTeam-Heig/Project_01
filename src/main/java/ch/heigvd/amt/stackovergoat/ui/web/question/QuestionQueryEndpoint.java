package ch.heigvd.amt.stackovergoat.ui.web.question;

import ch.heigvd.amt.stackovergoat.application.ServiceRegistry;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsDTO;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsQuery;
import ch.heigvd.amt.stackovergoat.domain.question.QuestionId;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuestionPageHandler", urlPatterns = "/question")
public class QuestionQueryEndpoint extends HttpServlet {

    @Inject
    private ServiceRegistry serviceRegistry;
    private QuestionFacade questionFacade;

    @Override
    public void init() throws ServletException {
        super.init();
        //serviceRegistry = ServiceRegistry.getServiceRegistry();
        questionFacade = serviceRegistry.getQuestionFacade();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionsQuery questionsQuery = QuestionsQuery.builder()
                .idQuestion((req.getSession().getAttribute("questionId").toString()))
                .build();
        QuestionsDTO questionsDTO = questionFacade.getQuestions(questionsQuery);
        req.setAttribute("questions", questionsDTO);
        req.getRequestDispatcher("/WEB-INF/views/question.jsp").forward(req, resp);
    }
}
