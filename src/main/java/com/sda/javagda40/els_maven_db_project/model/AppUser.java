package com.sda.javagda40.els_maven_db_project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data // includes Getter, Setter, ToString, EqualsAndHashCode, RequestedArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppUser { //POJO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private UserLoginData userLoginData;

    @OneToMany (mappedBy = "user", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set <LearningProcess> learningProcess;

    public AppUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
