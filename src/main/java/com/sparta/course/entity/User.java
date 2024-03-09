package com.sparta.course.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;

    @Enumerated(EnumType.STRING)
    private UserGenderEnum gender;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;
}
