package com.dailycode.test.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotEmpty(message = "firstName can't be null")
  private String firstName;
  @NotEmpty(message = "lastName can't be null")
  private String lastName;
  @NotEmpty(message = "department can't be null")
  private String department;
  @NotEmpty(message = "email can't be null")
  @NaturalId(mutable = true)
  private String email;

}
