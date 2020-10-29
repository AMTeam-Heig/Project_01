package ch.heigvd.amt.stackovergoat.integration;

import ch.heigvd.amt.stackovergoat.application.ServiceRegistry;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.IdentityManagementFacade;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.authenticate.AuthenticateCommand;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.authenticate.AuthenticationFailedException;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.authenticate.CurrentUserDTO;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.login.RegisterCommand;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.login.RegistrationFailedException;
import ch.heigvd.amt.stackovergoat.application.user.UsersDTO;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class UserDAOIT {

    private final static String WARNAME = "arquillian-managed.war";

    @Inject
    ServiceRegistry serviceRegistry;

    @Deployment(testable = true)
    public static WebArchive createDeployment(){
        WebArchive archive = ShrinkWrap.create(WebArchive.class, WARNAME)
                .addPackages(true, "ch.heigvd.amt");
        return archive;
    }

    @Test
    public void creatingAUserAndFindingIt() throws RegistrationFailedException, AuthenticationFailedException {
        IdentityManagementFacade identityManagementFacade = serviceRegistry.getIdentityManagementFacade();
        RegisterCommand registerCommand = RegisterCommand.builder()
                .username("test")
                .firstname("test")
                .lastname("test")
                .email("test")
                .clearTextPassword("test")
                .build();
        identityManagementFacade.register(registerCommand);

        AuthenticateCommand authenticateCommand = AuthenticateCommand.builder()
                .username("test")
                .clearTextPassword("test")
                .build();

        CurrentUserDTO usr = identityManagementFacade.authenticate(authenticateCommand);
    }

}
