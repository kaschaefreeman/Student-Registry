package com.github.kaschaefreeman.student_registry.domains.student;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * This class is that represents a student entity
 */

@Entity
@Table
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String first_name;
  private String last_name;
  private String dob;
  private Integer age ;

  public Student() {}

  public Student(
      Long id, String first_name, String last_name, String dob) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.dob = dob;
    this.age = Period.between(LocalDate.parse(this.dob), LocalDate.now()).getYears();
  }

  public Student(String first_name, String last_name, String dob) {
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

  public Integer setAge() {
    return this.age = Period.between(LocalDate.parse(this.dob), LocalDate.now()).getYears();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(id, student.id)
        && Objects.equals(first_name, student.first_name)
        && Objects.equals(last_name, student.last_name)
        && Objects.equals(dob, student.dob)
        && Objects.equals(age, student.age);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, first_name, last_name, dob, age);
  }

  @Override
  public String toString() {
    return "Student{"
        + "id="
        + id
        + ", first_name='"
        + first_name
        + '\''
        + ", last_name='"
        + last_name
        + '\''
        + ", dob="
        + dob
        + ", age="
        + age
        + '}';
  }
}
