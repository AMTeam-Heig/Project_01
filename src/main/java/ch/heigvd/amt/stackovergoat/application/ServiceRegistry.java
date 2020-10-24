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

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named("ServiceRegistry")
public class ServiceRegistry {
    private static ServiceRegistry singleton;

    // Question
    private static IQuestionRepository questionRepository;
    private static QuestionFacade questionFacade;

    // Answer
    private static IAnswerRepository answerRepository;
    private static AnswerFacade answerFacade;

    // Comment
    private static ICommentRepository commentRepository;
    private static CommentFacade commentFacade;

    // User
    @Inject
    @Named("JdbcUserRepository")
    private IUserRepository userRepository;

    private static UserFacade userFacade;
    //stats
    private static StatsFacade statsFacade;
    // Identity management
    private static IdentityManagementFacade identityManagementFacade;

    /*public static ServiceRegistry getServiceRegistry() {
        if (singleton == null) {
            singleton = new ServiceRegistry();
        }
        return singleton;
    }*/

    /*private ServiceRegistry() {
        singleton = this;

        questionRepository = new InMemoryQuestionRepository();
        questionFacade = new QuestionFacade(questionRepository);

        answerRepository = new InMemoryAnswerRepository();
        answerFacade = new AnswerFacade(answerRepository);


        //userRepository = new JdbcUserRepository();
        commentRepository = new InMemoryCommentRepository();
        commentFacade = new CommentFacade(commentRepository);

        userRepository = new InMemoryUserRepository();
        userFacade = new UserFacade(userRepository);

        identityManagementFacade = new IdentityManagementFacade(userRepository);
        initValues();
    }*/

    private void initValues() {
        userFacade.proposeUser(ProposeUserCommand.builder()
                .username("qwer")
                .email("qwer@qwe.com")
                .firstname("Ano")
                .lastname("Nymous")
                .clearTextPassword("1234")
                .build());

        userFacade.proposeUser(ProposeUserCommand.builder()
                .username("wasa")
                .email("wa@sa.lol")
                .firstname("Wa")
                .lastname("Sa")
                .clearTextPassword("digi")
                .build());

        userFacade.proposeUser(ProposeUserCommand.builder()
                .username("Clarisse")
                .email("clacla@fleu.lol")
                .firstname("Clarisse")
                .lastname("Fleurimont")
                .clearTextPassword("1234")
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
                .build());

        answerFacade.proposeAnswer(ProposeAnswerCommand.builder()
                .questionId(questionFacade.getAllQuestions().getQuestions().get(0).getId())
                .text("GOAT is love <3")
                .author("Elodie")
                .build());

        answerFacade.proposeAnswer(ProposeAnswerCommand.builder()
                .questionId(questionFacade.getAllQuestions().getQuestions().get(1).getId())
                .text("Nope")
                .author("Clarusso")
                .build());

        answerFacade.proposeAnswer(ProposeAnswerCommand.builder()
                .questionId(questionFacade.getAllQuestions().getQuestions().get(2).getId())
                .text("Aw heellllll nooooo!")
                .author("Walidou")
                .build());
    }

    @PostConstruct
    public void initFacade(){
        userFacade = new UserFacade(userRepository);
    }

    public QuestionFacade getQuestionFacade() {
        questionRepository = new InMemoryQuestionRepository();
        questionFacade = new QuestionFacade(questionRepository);
        return questionFacade;
    }
    public StatsFacade getStatsFacade() {
        return statsFacade;
    }
    public AnswerFacade getAnswerFacade() {
        return answerFacade;
    }

    public UserFacade getUserFacade() {
        //userFacade = new UserFacade(userRepository);
        return userFacade;
    }

    public IdentityManagementFacade getIdentityManagementFacade() {
        identityManagementFacade = new IdentityManagementFacade(userRepository);
        return identityManagementFacade;
    }
}
