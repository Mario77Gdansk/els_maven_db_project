package com.sda.javagda40.els_maven_db_project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data // includes Getter, Setter, ToString, EqualsAndHashCode, RequestedArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subject { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;

    @OneToMany(mappedBy = "subject", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Category> categories;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }
}
