package ch.heigvd.amt.stackovergoat.ui.web.answer;

import ch.heigvd.amt.stackovergoat.application.ServiceRegistry;
import ch.heigvd.amt.stackovergoat.application.answer.AnswerFacade;
import ch.heigvd.amt.stackovergoat.application.answer.ProposeAnswerCommand;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.authenticate.CurrentUserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SubmitAnswerCommandHandler", urlPatterns = "/submitAnswer.do")
public class ProposeAnswerCommandEndpoint extends HttpServlet {
    private ServiceRegistry serviceRegistry = ServiceRegistry.getServiceRegistry();
    private AnswerFacade answerFacade = serviceRegistry.getAnswerFacade();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrentUserDTO user = (CurrentUserDTO)req.getSession().getAttribute("currentUser");
        ProposeAnswerCommand command = null;
        if (user != null && req.getParameter("text") != null && !req.getParameter("text").equals("")) {
            command = ProposeAnswerCommand.builder()
                    .text(req.getParameter("text"))
                    .author(user.getUsername())
                    .build();
        }

        answerFacade.proposeAnswer(command);
        resp.sendRedirect("./home");
    }
}
