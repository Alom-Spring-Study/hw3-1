package com.example.springhw31.controller;

import com.example.springhw31.dto.UserDto;
import com.example.springhw31.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 회원가입 메서드처럼 UserDto를 파라미터로 받아주세요
 */

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/signup")
  public UserDto signup(@ModelAttribute UserDto userDto) {
    return userService.signup(userDto);
  }

  @GetMapping("/signin")
  public String signin(@ModelAttribute UserDto userDto) {
    return userService.signin(userDto);
  }
}
