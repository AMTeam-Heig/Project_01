package stackovergoat.application;

import ch.heigvd.amt.stackovergoat.application.answer.AnswerFacade;
import ch.heigvd.amt.stackovergoat.application.answer.AnswersDTO;
import ch.heigvd.amt.stackovergoat.application.answer.AnswersQuery;
import ch.heigvd.amt.stackovergoat.application.answer.ProposeAnswerCommand;
import ch.heigvd.amt.stackovergoat.application.question.ProposeQuestionCommand;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsDTO;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsQuery;
import ch.heigvd.amt.stackovergoat.application.user.ProposeUserCommand;
import ch.heigvd.amt.stackovergoat.application.user.UserFacade;
import ch.heigvd.amt.stackovergoat.application.user.UsersDTO;
import ch.heigvd.amt.stackovergoat.application.user.UsersQuery;
import ch.heigvd.amt.stackovergoat.domain.answer.AnswerId;
import ch.heigvd.amt.stackovergoat.domain.answer.IAnswerRepository;
import ch.heigvd.amt.stackovergoat.domain.question.IQuestionRepository;
import ch.heigvd.amt.stackovergoat.domain.user.IUserRepository;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.InMemoryAnswerRepository;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.InMemoryQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class AnswerTest {
    private final int TEST_NBR = 1000;

    private final String QUESTION_TEXT = "Is this really a question ?";
    private final String QUESTION_AUTHOR = "Question author";

    private final String ANSWER_TEXT = "Yes, I think it is.";
    private final String ANSWER_AUTHOR = "Answer author";

    private static IQuestionRepository questionRepository;
    private static QuestionFacade questionFacade;

    private static IAnswerRepository answerRepository;
    private static AnswerFacade answerFacade;

    private final ProposeQuestionCommand proposeQuestionCommand = ProposeQuestionCommand.builder()
            .author(QUESTION_AUTHOR)
            .text(QUESTION_TEXT)
            .build();

    private final ProposeAnswerCommand proposeAnswerCommand = ProposeAnswerCommand.builder()
            .author(ANSWER_AUTHOR)
            .text(ANSWER_TEXT)
            .build();

    @BeforeEach
    public void initialization() {
        questionRepository = new InMemoryQuestionRepository();
        questionFacade = new QuestionFacade(questionRepository);

        answerRepository = new InMemoryAnswerRepository();
        answerFacade = new AnswerFacade(answerRepository);
    }

    @Test
    public void proposingAnAnswerShouldAddItToFacade() {
        assertDoesNotThrow(() -> answerFacade.proposeAnswer(proposeAnswerCommand));
        AnswersQuery answersQuery = AnswersQuery.builder()
                .isAnswer(true)
                .build();
        AnswersDTO answersDTO = answerFacade.getAnswers(answersQuery);
        assertFalse(answerFacade.getAllAnswers().getAnswers().isEmpty());
        assertFalse(answersDTO.getAnswers().isEmpty());
    }

    @Test
    public void userFacadeShouldStoreCorrectAnswer() {
        answerFacade.proposeAnswer(proposeAnswerCommand);
        assertEquals(ANSWER_AUTHOR, answerFacade.getAllAnswers().getAnswers().get(0).getAuthor());
        assertEquals(ANSWER_TEXT, answerFacade.getAllAnswers().getAnswers().get(0).getText());
    }

    @Test
    public void answerIdShouldBeUnique() {
        LinkedList<AnswerId> ids = new LinkedList<>();
        for (int i = 0; i < TEST_NBR; ++i) {
            ids.add(new AnswerId());
        }
        for (int i = 0; i < TEST_NBR; ++i) {
            assertFalse(ids.contains(new AnswerId()));
        }
    }

    @Test
    public void answerIdShouldBeCreatedCorrectly() {
        UUID uuid = UUID.randomUUID();
        String stringUuid = UUID.randomUUID().toString();

        AnswerId answerId = new AnswerId(uuid);
        AnswerId stringAnswerId = new AnswerId(stringUuid);

        assertEquals(uuid.toString(), answerId.asString());
        assertEquals(stringUuid, stringAnswerId.asString());
    }

    @Test
    public void getAnswersShouldReturnANonEmptyCollection() {
        assertDoesNotThrow(() -> answerFacade.proposeAnswer(proposeAnswerCommand));
    }

    @Test
    public void findAllAndFindWithNullQueryShouldBeTheSame() {
        assertEquals(answerFacade.getAnswers(null), answerFacade.getAllAnswers());
    }
}
