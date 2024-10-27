package com.example.springhw31.controller;

import com.example.springhw31.dto.UserDto;
import com.example.springhw31.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  // 회원 가입
  @PostMapping("/join")
  public UserDto join(@ModelAttribute UserDto userDto) {
    return userService.join(userDto);
  }

  // 로그인
  @PostMapping("/login")
  public String login(@ModelAttribute UserDto userDto) {
    return userService.login(userDto);
  }
}
