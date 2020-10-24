package ch.heigvd.amt.stackovergoat.ui.web.question;

import ch.heigvd.amt.stackovergoat.application.ServiceRegistry;
import ch.heigvd.amt.stackovergoat.application.answer.AnswerFacade;
import ch.heigvd.amt.stackovergoat.application.answer.AnswersDTO;
import ch.heigvd.amt.stackovergoat.application.answer.AnswersQuery;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsDTO;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsQuery;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuestionPageHandler", urlPatterns = "/question")
public class QuestionQueryEndpoint extends HttpServlet {

    private ServiceRegistry serviceRegistry;
    private QuestionFacade questionFacade;
    private AnswerFacade answerFacade;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceRegistry = ServiceRegistry.getServiceRegistry();
        questionFacade = serviceRegistry.getQuestionFacade();
        answerFacade = serviceRegistry.getAnswerFacade();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuestionsQuery questionsQuery = QuestionsQuery.builder()
                .idQuestion(req.getParameter("id"))
                .build();
        QuestionsDTO questionsDTO = questionFacade.getQuestions(questionsQuery);
        QuestionsDTO.QuestionDTO questionDTO = null;

        AnswersDTO answersDTO = null;

        if (questionsDTO.getQuestions().size() != 1) {
            resp.sendRedirect("/home");
        } else {
            questionDTO = questionsDTO.getQuestions().get(0);
            answersDTO = answerFacade.getAnswers(AnswersQuery.builder().idQuestion(questionDTO.getId()).build());
        }

        req.setAttribute("question", questionDTO);
        req.setAttribute("answers", answersDTO);
        req.getRequestDispatcher("/WEB-INF/views/question.jsp").forward(req, resp);
    }
}
