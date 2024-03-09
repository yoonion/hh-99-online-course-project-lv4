package com.sparta.course.service.user;

import com.sparta.course.dto.user.SignUpRequestDto;
import com.sparta.course.dto.user.SignUpResponseDto;
import com.sparta.course.entity.user.User;
import com.sparta.course.entity.user.UserGenderEnum;
import com.sparta.course.entity.user.UserRoleEnum;
import com.sparta.course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpResponseDto signUp(SignUpRequestDto requestDto) {
        String inputGender = requestDto.getGender();
        String inputAuthority = requestDto.getAuthority();

        // 성별값 체크
        UserGenderEnum gender;
        if (inputGender.equalsIgnoreCase("man")) {
            gender = UserGenderEnum.MAN;
        } else if (inputGender.equalsIgnoreCase("women")) {
            gender = UserGenderEnum.WOMEN;
        } else {
            throw new IllegalArgumentException("성별은 man / women 만 입력 가능합니다.");
        }

        // 권한 값 체크
        UserRoleEnum role;
        if (inputAuthority.equalsIgnoreCase("admin")) {
            role = UserRoleEnum.ADMIN;
        } else if (inputAuthority.equalsIgnoreCase("user")) {
            role = UserRoleEnum.USER;
        } else {
            throw new IllegalArgumentException("권한은 admin OR user 만 입력 가능합니다.");
        }

        // 회원 중복 체크
        Optional<User> findUser = userRepository.findByEmail(requestDto.getEmail());
        if (findUser.isPresent()) {
            throw new IllegalArgumentException("중복된 이메일 입니다.");
        }

        String encodedPassword = passwordEncoder.encode(requestDto.getPassword());
        User user = new User(encodedPassword, gender, role, requestDto);

        userRepository.save(user);
        return new SignUpResponseDto(user);
    }
}
