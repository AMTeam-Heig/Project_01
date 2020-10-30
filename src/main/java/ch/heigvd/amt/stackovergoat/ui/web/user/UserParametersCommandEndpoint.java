package ch.heigvd.amt.stackovergoat.ui.web.user;

import ch.heigvd.amt.stackovergoat.application.ServiceRegistry;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.IdentityManagementFacade;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.profile.UpdateFailedException;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.profile.UpdatePasswordCommand;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserParametersCommandEndpoint", urlPatterns = "/parameters")
public class UserParametersCommandEndpoint extends HttpServlet {

    @Inject
    @Named("ServiceRegistry")
    private ServiceRegistry serviceRegistry;// = ServiceRegistry.getServiceRegistry();

    private IdentityManagementFacade identityManagementFacade;

    @Override
    public void init() throws ServletException {
        super.init();
        identityManagementFacade = serviceRegistry.getIdentityManagementFacade();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UpdatePasswordCommand updatePasswordCommand = UpdatePasswordCommand.builder()
                    .username(request.getSession().getAttribute("currentUsername").toString())
                    .newClearTextPassword(request.getParameter("newClearTextPassword"))
                    .build();
            identityManagementFacade.changePassword(updatePasswordCommand);

            response.sendRedirect("./profile");
        } catch (UpdateFailedException e) {
            request.getSession().setAttribute("errors", List.of(e.getMessage()));
            response.sendRedirect("./profile");
        }

        request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);

    }


}
