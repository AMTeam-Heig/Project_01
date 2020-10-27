package ch.heigvd.amt.stackovergoat.ui.web.comment;

import ch.heigvd.amt.stackovergoat.application.ServiceRegistry;
import ch.heigvd.amt.stackovergoat.application.comment.CommentFacade;
import ch.heigvd.amt.stackovergoat.application.comment.ProposeCommentCommand;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.authenticate.CurrentUserDTO;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProposeQuestionCommentCommandEndpoint", urlPatterns = "/submitQuestionComment.do")
public class ProposeQuestionCommentCommandEndpoint extends HttpServlet {


    @Inject
    @Named("ServiceRegistry")
    private ServiceRegistry serviceRegistry;// = ServiceRegistry.getServiceRegistry();
    private CommentFacade commentFacade;// = serviceRegistry.getIdentityManagementFacade();

    @Override
    public void init() throws ServletException {
        super.init();
        commentFacade = serviceRegistry.getCommentFacade();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CurrentUserDTO user = (CurrentUserDTO)req.getSession().getAttribute("currentUser");
        ProposeCommentCommand command = null;

        if (user != null && req.getParameter("comment") != null && !req.getParameter("comment").equals("")) {
            command = ProposeCommentCommand.builder()
                    .subjectId(req.getParameter("questionId"))
                    .comment(req.getParameter("comment"))
                    .author(user.getUsername())
                    .isForAnswer(false)
                    .build();
        }

        commentFacade.proposeComment(command);
        resp.sendRedirect("/question?id=" + req.getParameter("questionId"));
    }
}
