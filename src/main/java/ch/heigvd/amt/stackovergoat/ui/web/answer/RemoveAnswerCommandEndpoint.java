package ch.heigvd.amt.stackovergoat.ui.web.answer;

import ch.heigvd.amt.stackovergoat.application.ServiceRegistry;
import ch.heigvd.amt.stackovergoat.application.answer.AnswerFacade;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.authenticate.CurrentUserDTO;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveAnswerCommandEndpoint", urlPatterns = "/removeAnswer.do")
public class RemoveAnswerCommandEndpoint extends HttpServlet {

    @Inject
    @Named("ServiceRegistry")
    private ServiceRegistry serviceRegistry;// = ServiceRegistry.getServiceRegistry();
    private AnswerFacade answerFacade ;// = serviceRegistry.getIdentityManagementFacade();

    @Override
    public void init() throws ServletException {
        super.init();
        answerFacade = serviceRegistry.getAnswerFacade();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrentUserDTO user = (CurrentUserDTO)req.getSession().getAttribute("currentUser");
        try {
            answerFacade.removeAnswer(req.getParameter("answerId"));
        } catch (Exception e) {
            req.getSession().setAttribute("error", "Something went wrong with the ansert removal (id = " + req.getParameter("answerId") + ")");
        }
        resp.sendRedirect("/question?id=" + req.getParameter("questionId"));
    }
}
