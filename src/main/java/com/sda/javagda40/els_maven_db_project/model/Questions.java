package com.sda.javagda40.els_maven_db_project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data // includes Getter, Setter, ToString, EqualsAndHashCode, RequestedArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Questions { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String answer;


    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Category category;

    @OneToMany(mappedBy = "questions", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<LearningProcess> learningProcess;


    public Questions(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
