package com.example.springhw31.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * TODO: 완성된 코드 아닙니다~
 */
@Getter
@Setter
@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

@Column(unique = true,nullable = false)
  private String username;
@Column(nullable = false)
  private String password;
  @Column(unique = true,nullable = false)
  private String nickname;
}
