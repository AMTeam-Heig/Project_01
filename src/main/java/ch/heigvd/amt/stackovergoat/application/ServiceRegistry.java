package ch.heigvd.amt.stackovergoat.application;

import ch.heigvd.amt.stackovergoat.application.answer.AnswerFacade;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;
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
    }

    public QuestionFacade getQuestionFacade() {
        return questionFacade;
    }

    public AnswerFacade getAnswerFacade() {
        return answerFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }
}
