package ch.heigvd.amt.stackovergoat.ui.web.statistics;

import ch.heigvd.amt.stackovergoat.application.ServiceRegistry;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsDTO;
import ch.heigvd.amt.stackovergoat.application.statistics.StatsDTO;
import ch.heigvd.amt.stackovergoat.application.statistics.StatsFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

<<<<<<< HEAD:src/main/java/ch/heigvd/amt/stackovergoat/ui/web/statistics/statisticsPageEndPoint.java
@WebServlet(name = "statisticsPageEndPoint" ,urlPatterns =  "/statistics")
public class statisticsPageEndPoint extends HttpServlet {
=======
@WebServlet(name = "AnswersPageHandler", urlPatterns = "/answers")
public class AnswersQueryEndpoint extends HttpServlet {
>>>>>>> e85033728e44af9f30523f96841e81badde69921:src/main/java/ch/heigvd/amt/stackovergoat/ui/web/answer/AnswersQueryEndpoint.java

    private ServiceRegistry serviceRegistry;
    private StatsFacade statsFacade;

    @Override
    public void init() throws ServletException {
        super.init();
        serviceRegistry = ServiceRegistry.getServiceRegistry();
        statsFacade = serviceRegistry.getStatsFacade();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatsDTO  stats= statsFacade.getStats();
        req.setAttribute("stats", stats);
        req.getRequestDispatcher("/WEB-INF/views/statistics.jsp").forward(req, resp);
    }
}
