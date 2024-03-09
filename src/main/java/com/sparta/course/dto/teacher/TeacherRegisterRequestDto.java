package com.sparta.course.dto.teacher;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class TeacherRegisterRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private int career;

    @NotBlank
    private String company;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String introduction;
}
