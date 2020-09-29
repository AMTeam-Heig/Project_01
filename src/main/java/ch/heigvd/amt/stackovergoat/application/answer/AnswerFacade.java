package ch.heigvd.amt.stackovergoat.application.answer;

import ch.heigvd.amt.stackovergoat.domain.answer.IAnswerRepository;
import ch.heigvd.amt.stackovergoat.domain.answer.Answer;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AnswerFacade {
    private IAnswerRepository answerRepository;

    public AnswerFacade(IAnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void proposeAnswer(ProposeAnswerCommand command) {
        Answer submittedAnswer = Answer.builder()
                .author(command.getAuthor())
                .text(command.getText())
                .build();
        answerRepository.save(submittedAnswer);
    }

    public AnswersDTO getAnswers(AnswersQuery query) {
        Collection<Answer> allAnswers = answerRepository.find(query);

        List<AnswersDTO.AnswerDTO> allAnswersDTO = allAnswers.stream().map(answer -> AnswersDTO.AnswerDTO.builder()
                .text(answer.getText())
                .build()).collect(Collectors.toList());

        return AnswersDTO.builder()
                .answers(allAnswersDTO)
                .build();
    }
}
