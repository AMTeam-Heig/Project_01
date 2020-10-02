package ch.heigvd.amt.stackovergoat.application;

import ch.heigvd.amt.stackovergoat.application.answer.AnswerFacade;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.IdentityManagementFacade;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.login.RegisterCommand;
import ch.heigvd.amt.stackovergoat.application.identitymgmt.login.RegistrationFailedException;
import ch.heigvd.amt.stackovergoat.application.question.ProposeQuestionCommand;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;
import ch.heigvd.amt.stackovergoat.application.user.ProposeUserCommand;
import ch.heigvd.amt.stackovergoat.application.user.UserFacade;
import ch.heigvd.amt.stackovergoat.domain.answer.IAnswerRepository;
import ch.heigvd.amt.stackovergoat.domain.question.IQuestionRepository;
import ch.heigvd.amt.stackovergoat.domain.user.IUserRepository;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.InMemoryAnswerRepository;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.InMemoryQuestionRepository;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.InMemoryUserRepository;

public class ServiceRegistry {
    private static ServiceRegistry singleton;

    // Question
    private static IQuestionRepository questionRepository;
    private static QuestionFacade questionFacade;

    // Answer
    private static IAnswerRepository answerRepository;
    private static AnswerFacade answerFacade;

    // User
    private static IUserRepository userRepository;
    private static UserFacade userFacade;

    // Identity management
    private static IdentityManagementFacade identityManagementFacade;

    public static ServiceRegistry getServiceRegistry() {
        if (singleton == null) {
            singleton = new ServiceRegistry();
        }
        return singleton;
    }

    private ServiceRegistry() {
        singleton = this;

        questionRepository = new InMemoryQuestionRepository();
        questionFacade = new QuestionFacade(questionRepository);

        answerRepository = new InMemoryAnswerRepository();
        answerFacade = new AnswerFacade(answerRepository);

        userRepository = new InMemoryUserRepository();
        userFacade = new UserFacade(userRepository);

        identityManagementFacade = new IdentityManagementFacade(userRepository);
        initValues();
    }

    private void initValues() {
        userFacade.proposeUser(ProposeUserCommand.builder()
                .username("qwer")
                .email("qwer@qwe.com")
                .firstname("Ano")
                .lastname("Nymous")
                .clearTextPassword("1234")
                .build());
/*
        userFacade.proposeUser(ProposeUserCommand.builder()
                .username("wasa")
                .email("wa@sa.lol")
                .firstname("Wa")
                .lastname("Sa")
                .clearTextPassword("digi")
                .build());

        userFacade.proposeUser(ProposeUserCommand.builder()
                .username("q")
                .email("q")
                .firstname("q")
                .lastname("q")
                .clearTextPassword("q")
                .build());

        questionFacade.proposeQuestion(ProposeQuestionCommand.builder()
                .text("Is this real life ??")
                .author("Mimimi")
                .build());

        questionFacade.proposeQuestion(ProposeQuestionCommand.builder()
                .text("What ?")
                .author("Elodie")
                .build());

        questionFacade.proposeQuestion(ProposeQuestionCommand.builder()
                .text("What is GOAT?")
                .author("Walid")
                .build());*/
    }

    public QuestionFacade getQuestionFacade() {
        return questionFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public IdentityManagementFacade getIdentityManagementFacade() {
        return identityManagementFacade;
    }
}
