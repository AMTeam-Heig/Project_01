package ch.heigvd.amt.stackovergoat.application.answer;

import ch.heigvd.amt.stackovergoat.domain.answer.IAnswerRepository;
import ch.heigvd.amt.stackovergoat.domain.answer.Answer;
import ch.heigvd.amt.stackovergoat.domain.question.QuestionId;
import ch.heigvd.amt.stackovergoat.infrastructure.persistence.memory.IntegrityConstraintViolationException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerFacade {
    private IAnswerRepository answerRepository;

    public AnswerFacade(IAnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void proposeAnswer(ProposeAnswerCommand command) {
        if(command != null) {
            Answer submittedAnswer = Answer.builder()
                    .questionId(new QuestionId(command.getQuestionId()))
                    .author(command.getAuthor())
                    .text(command.getText())
                    .build();
            try {
                answerRepository.save(submittedAnswer);
            } catch (IntegrityConstraintViolationException e) {
                e.printStackTrace();
            }
        }
    }

    public AnswersDTO getAnswers(AnswersQuery query) {
        Collection<Answer> allAnswers = answerRepository.find(query);

        List<AnswersDTO.AnswerDTO> allAnswersDTO = allAnswers.stream()
                .map(answer -> AnswersDTO.AnswerDTO.builder()
                        .idQuestion(answer.getQuestionId().asString())
                        .text(answer.getText())
                        .build()).collect(Collectors.toList());

        return AnswersDTO.builder()
                .answers(allAnswersDTO)
                .build();
    }

    public AnswersDTO getAllAnswers() {
        Collection<Answer> allAnswers = answerRepository.findAll();

        List<AnswersDTO.AnswerDTO> allAnswersDTO = allAnswers.stream()
                .map(answer -> AnswersDTO.AnswerDTO.builder()
                        .text(answer.getText())
                        .author(answer.getAuthor())
                        .build())
                .collect(Collectors.toList());

        return AnswersDTO.builder()
                .answers(allAnswersDTO)
                .build();
    }
}
