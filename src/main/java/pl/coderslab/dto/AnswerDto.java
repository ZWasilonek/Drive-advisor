package pl.coderslab.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AnswerDto {

    @Id
    private Long id;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    private Boolean isCorrect;

    private Long fileId;

}
