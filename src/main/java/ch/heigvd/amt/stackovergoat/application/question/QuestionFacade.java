package ch.heigvd.amt.stackovergoat.application.question;

import ch.heigvd.amt.stackovergoat.application.comment.CommentsQuery;
import ch.heigvd.amt.stackovergoat.domain.comment.ICommentRepository;
import ch.heigvd.amt.stackovergoat.domain.question.IQuestionRepository;
import ch.heigvd.amt.stackovergoat.domain.question.Question;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.exception.IntegrityConstraintViolationException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionFacade {
    private IQuestionRepository questionRepository;
    private ICommentRepository commentRepository;

    public QuestionFacade(IQuestionRepository questionRepository, ICommentRepository commentRepository) {
        this.questionRepository = questionRepository;
        this.commentRepository = commentRepository;
    }

    public void proposeQuestion(ProposeQuestionCommand command) {
        if(command != null) {
            Question submittedQuestion = Question.builder()
                    .author(command.getAuthor())
                    .text(command.getText())
                    .build();
            try {
                questionRepository.save(submittedQuestion);
            } catch (IntegrityConstraintViolationException e) {
                e.printStackTrace();
            }
        }
    }

    public QuestionsDTO getQuestions(QuestionsQuery query) {
        Collection<Question> allQuestions = questionRepository.find(query);

        List<QuestionsDTO.QuestionDTO> allQuestionsDTO = allQuestions.stream()
                .map(question -> QuestionsDTO.QuestionDTO.builder()
                        .id(question.getId().asString())
                        .author(question.getAuthor())
                        .text(question.getText())
                        .comments(commentRepository.find(
                                CommentsQuery.builder()
                                        .subjectId(question.getId().asString())
                                        .build()).stream().collect(Collectors.toList()))
                .build()).collect(Collectors.toList());

        return QuestionsDTO.builder()
                .questions(allQuestionsDTO)
                .build();
    }

    public QuestionsDTO getAllQuestions() {
        Collection<Question> allQuestions = questionRepository.findAll();

        List<QuestionsDTO.QuestionDTO> allQuestionsDTO = allQuestions.stream()
                .map(question -> QuestionsDTO.QuestionDTO.builder()
                        .id(question.getId().asString())
                        .text(question.getText())
                        .author(question.getAuthor())
                        .build())
                .collect(Collectors.toList());

        return QuestionsDTO.builder()
                .questions(allQuestionsDTO)
                .build();
    }
}
