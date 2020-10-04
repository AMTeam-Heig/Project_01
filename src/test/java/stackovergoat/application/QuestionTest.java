package stackovergoat.application;

import ch.heigvd.amt.stackovergoat.application.question.ProposeQuestionCommand;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;
import ch.heigvd.amt.stackovergoat.application.user.ProposeUserCommand;
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
        assertFalse(questionFacade.getAllQuestions().getQuestions().isEmpty());
    }

    @Test
    public void userFacadeShouldStoreCorrectUser() {
        questionFacade.proposeQuestion(proposeQuestionCommand);
        assertEquals(AUTHOR, questionFacade.getAllQuestions().getQuestions().get(0).getAuthor());
        assertEquals(TEXT, questionFacade.getAllQuestions().getQuestions().get(0).getText());

    }
}
