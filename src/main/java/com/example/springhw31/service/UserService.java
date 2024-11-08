package com.example.springhw31.service;

import com.example.springhw31.dto.UserDto;
import com.example.springhw31.entity.User;
import com.example.springhw31.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Controller에 반환할 때도 DTO 객체를 반환합니다.
 */

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  //회원가입 로직
  //아이디, 비밀번호, 닉네임은 null 불가(@Column 사용)
  //아이디 또는 닉네님이 중복된 경우 회원가입불가
  public UserDto signup(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(userDto.getPassword());
    user.setNickname(userDto.getNickname());
    userRepository.save(user);
    return userDto;
  }

  //로그인 로직
  //로그인 성공 시 “{회원 닉네임} 님, 환영합니다!!” 라는 문자열 출력
  //로그인 실패 시 “아이디 및 비밀번호가 일치하지 않습니다.” 문자열 출력
  public String signin(UserDto userDto) {
    User user = userRepository.findByUsername(userDto.getUsername())
            .orElseThrow(() -> new NoSuchElementException("해당 유저가 없습니다."));

    if(user.getPassword().equals(userDto.getPassword())){
      return user.getNickname() + "님 환영합니다.!!";
    }else{
      return "비밀번호가 일치하지 않습니다.";
    }
  }
}
