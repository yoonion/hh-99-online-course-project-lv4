package com.sparta.course.entity.user;

import com.sparta.course.dto.user.SignUpRequestDto;
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

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Enumerated(EnumType.STRING)
    private UserGenderEnum gender;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    public User(String encodedPassword, UserGenderEnum gender, UserRoleEnum role, SignUpRequestDto requestDto) {
        this.email = requestDto.getEmail();
        this.password = encodedPassword;
        this.phoneNumber = requestDto.getPhoneNumber();
        this.address = requestDto.getAddress();
        this.gender = gender;
        this.role = role;
    }
}
