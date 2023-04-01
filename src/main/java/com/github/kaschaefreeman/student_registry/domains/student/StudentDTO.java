package com.github.kaschaefreeman.student_registry.domains.student;

import java.time.LocalDate;
import java.time.Period;

/**
 * An object to represent a Data Transfer Object for a student
 */
public class StudentDTO {
  private Long id;
  private String first_name;
  private String last_name;

  private String dob;
  private Integer age;

  public StudentDTO() {}

  public StudentDTO(
          Long id, String first_name, String last_name, String dob) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.dob = dob;
    this.age = Period.between(LocalDate.parse(this.dob), LocalDate.now()).getYears();
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  public Integer getAge() {
    return age;
  }

}
