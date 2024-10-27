package com.example.springhw31.service;

import com.example.springhw31.dto.UserDto;
import com.example.springhw31.entity.User;
import com.example.springhw31.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Controller에 반환할 때도 DTO 객체를 반환합니다.
 */
@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  // 회원 가입
  public UserDto join(UserDto userDto) {
    User user = new User();

    user.setUsername(userDto.getUsername());
    user.setPassword(userDto.getPassword());
    user.setNickname(userDto.getNickname());
    userRepository.save(user);

    return userDto;
  }

  // 로그인
  public String login(UserDto userDto) {
    User user = userRepository.findByUsername(userDto.getUsername());
    if (user != null) {
      if (user.getPassword().equals(userDto.getPassword())) {
        return user.getNickname() + "님, 환영합니다!!";
      }
    }
    return "아이디 및 비밀번호가 일치하지 않습니다.";
  }
}
