package com.sda.javagda40.els_maven_db_project.model;

import com.sun.javafx.beans.IDProperty;
import lombok.*;

import javax.persistence.*;

@Data // includes Getter, Setter, ToString, EqualsAndHashCode, RequestedArgsConstructor
@Entity
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

    public AppUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
