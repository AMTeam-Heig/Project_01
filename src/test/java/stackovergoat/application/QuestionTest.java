package stackovergoat.application;

import ch.heigvd.amt.stackovergoat.application.question.ProposeQuestionCommand;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsDTO;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsQuery;
import ch.heigvd.amt.stackovergoat.application.user.ProposeUserCommand;
import ch.heigvd.amt.stackovergoat.application.user.UsersDTO;
import ch.heigvd.amt.stackovergoat.application.user.UsersQuery;
import ch.heigvd.amt.stackovergoat.domain.question.IQuestionRepository;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.InMemoryQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuestionTest {
    private final String TEXT = "Is this really a question ?";
    private final String AUTHOR = "Author";

    private static IQuestionRepository questionRepository;
    private static QuestionFacade questionFacade;

    private final ProposeQuestionCommand proposeQuestionCommand = ProposeQuestionCommand.builder()
            .author(AUTHOR)
            .text(TEXT)
            .build();

    @BeforeEach
    public void initialization() {
        questionRepository = new InMemoryQuestionRepository();
        questionFacade = new QuestionFacade(questionRepository);
    }

    @Test
    public void proposingAQuestionShouldAddItToFacade() {
        assertDoesNotThrow(() -> questionFacade.proposeQuestion(proposeQuestionCommand));
        QuestionsQuery questionsQuery = QuestionsQuery.builder()
                .isQuestion(true)
                .build();
        QuestionsDTO questionsDTO = questionFacade.getQuestions(questionsQuery);
        assertFalse(questionFacade.getAllQuestions().getQuestions().isEmpty());
        assertFalse(questionsDTO.getQuestions().isEmpty());
    }

    @Test
    public void userFacadeShouldStoreCorrectQuestion() {
        questionFacade.proposeQuestion(proposeQuestionCommand);
        assertEquals(AUTHOR, questionFacade.getAllQuestions().getQuestions().get(0).getAuthor());
        assertEquals(TEXT, questionFacade.getAllQuestions().getQuestions().get(0).getText());
    }

    @Test
    public void findAllAndFindWithNullQueryShouldBeTheSame() {
        assertEquals(questionFacade.getQuestions(null), questionFacade.getAllQuestions());
    }
}
