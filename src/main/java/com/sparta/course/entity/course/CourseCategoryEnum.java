package com.sparta.course.entity.course;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum CourseCategoryEnum {
    SPRING("spring"),
    NODE("node"),
    REACT("react");

    private final String categoryName;

    CourseCategoryEnum(String category) {
        this.categoryName = category;
    }

    // 문자열에 맞는 카테고리 찾아오기
    public static CourseCategoryEnum matchStringWithCategory(String text) {
        return Arrays.stream(CourseCategoryEnum.values())
                .filter(category -> category.categoryName.equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(text + " 카테고리가 존재하지 않습니다. 다시 입력 해주세요."));
    }
}
