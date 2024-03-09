package com.sparta.course.dto.user;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sparta.course.entity.user.User;
import com.sparta.course.entity.user.UserGenderEnum;
import com.sparta.course.entity.user.UserRoleEnum;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class SignUpResponseDto {
    private final String email;
    private final String phoneNumber;
    private final String address;
    private final UserGenderEnum gender;
    private final UserRoleEnum role;

    public SignUpResponseDto(User user) {
        this.email = user.getEmail();
        this.phoneNumber = user.getPhoneNumber();
        this.address = user.getAddress();
        this.gender = user.getGender();
        this.role = user.getRole();
    }
}
