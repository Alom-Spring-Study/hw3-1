package com.example.springhw31.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO: 완성된 코드 아닙니다~
 */
@Entity
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false, unique = true)
  private String nickname;
}
