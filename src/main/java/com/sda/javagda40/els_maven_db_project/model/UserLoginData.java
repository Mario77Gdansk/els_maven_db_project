package com.sda.javagda40.els_maven_db_project.model;


import lombok.*;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userLogin;
    private String userPassword;

    @OneToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private AppUser appUser;


    public UserLoginData(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }
}
