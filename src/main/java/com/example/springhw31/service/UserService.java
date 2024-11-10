package com.example.springhw31.service;

import com.example.springhw31.dto.UserDto;
import com.example.springhw31.entity.User;
import com.example.springhw31.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Controller에 반환할 때도 DTO 객체를 반환합니다.
 */
@RequiredArgsConstructor
@Service
public class UserService {
  private final UserRepository userRepository;
  //회원가입
  public UserDto join(UserDto userDto) {
    //중복된 경우 회원가입불가
    if (userRepository.existsByUsername(userDto.getUsername())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 존재하는 아이디입니다.");
    } else if (userRepository.existsByNickname(userDto.getNickname())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이미 존재하는 닉네임입니다.");
    }

    User user = new User();
    user.setPassword(userDto.getPassword());
    user.setNickname(userDto.getNickname());
    user.setPassword(userDto.getPassword());
    userRepository.save(user);



    return userDto;

  }
  //로그인

  public String login(UserDto userDto){
    if (userRepository.existsByUsername(userDto.getUsername())&&
            userRepository.existsByNickname(userDto.getNickname())) {
      return userDto.getNickname()+" 님, 환영합니다!!";
    } else {

      return "아이디 및 비밀번호가 일치하지 않습니다";

    }









  }

}
