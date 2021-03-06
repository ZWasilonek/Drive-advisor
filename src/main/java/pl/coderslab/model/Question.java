package pl.coderslab.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.model.generic.GenericEntityID;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "questions")
@Getter
@Setter
public class Question extends GenericEntityID {

    @NotNull
    @NotBlank
    private String title;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_answers", joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_id"))
    private Set<Answer> answers;

    public Question() {
        answers = new HashSet<>();
    }

}