package com.sda.javagda40.els_maven_db_project.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LearningProcessList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public LearningProcessList(int mark, Date nextRepetition) {
        this.mark = mark;
        this.nextRepetition = nextRepetition;
    }

    private int mark; //ocena za to konkretne pytanie
    private Date nextRepetition; //obliczona data następnej powtórki tego pytania

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Questions questions;



}
