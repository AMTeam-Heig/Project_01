package stackovergoat.application;

import ch.heigvd.amt.stackovergoat.application.answer.AnswerFacade;
import ch.heigvd.amt.stackovergoat.application.answer.AnswersDTO;
import ch.heigvd.amt.stackovergoat.application.answer.AnswersQuery;
import ch.heigvd.amt.stackovergoat.application.answer.ProposeAnswerCommand;
import ch.heigvd.amt.stackovergoat.application.question.ProposeQuestionCommand;
import ch.heigvd.amt.stackovergoat.application.question.QuestionFacade;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsDTO;
import ch.heigvd.amt.stackovergoat.application.question.QuestionsQuery;
import ch.heigvd.amt.stackovergoat.domain.answer.IAnswerRepository;
import ch.heigvd.amt.stackovergoat.domain.question.IQuestionRepository;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.InMemoryAnswerRepository;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.InMemoryQuestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnswerTest {
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
}
