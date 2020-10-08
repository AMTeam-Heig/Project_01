package ch.heigvd.amt.stackovergoat.application.question;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Builder
@Getter
@EqualsAndHashCode
public class QuestionsQuery {

    @Builder.Default
    private boolean isQuestion = true;

    @Builder.Default
    private String idQuestion = "";

    @Builder.Default
    private String author = "";

    @Builder.Default
    private String text = "";
<<<<<<< HEAD
}
=======
}
>>>>>>> b8d32940b912f253e6eafaff5d95db55944b0eab
