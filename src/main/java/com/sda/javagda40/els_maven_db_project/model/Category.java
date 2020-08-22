package com.sda.javagda40.els_maven_db_project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data // includes Getter, Setter, ToString, EqualsAndHashCode, RequestedArgsConstructor
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Category { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Subject subject;

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    @EqualsAndHashCode.Exclude
    private Set<Questions> questions;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}
