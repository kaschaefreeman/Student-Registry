package com.github.kaschaefreeman.student_registry.data;

import com.github.kaschaefreeman.student_registry.domains.student.Student;
import java.util.ArrayList;import java.util.List;import java.util.Random;
/** Factory method to generate random vehicles */
public class StudentFactory {

  private static final String[] firstNames = {
    "Amy",
    "Cody",
    "John",
    "Anthony",
    "Amanda",
    "Casey",
    "Ciara",
    "Lucas",
    "Abby",
    "Robert",
    "Johnathan",
    "Andrew",
    "Susan",
    "Samuel",
    "Jennifer",
    "Ana",
    "Carey",
    "Miriam",
    "Mariah",
    "Mason",
    "Mark",
    "Jose",
    "Eduardo",
    "Leo",
    "Sean"
  };
  private static final String[] lastNames = {
    "Espinoza",
    "Vasquez",
    "Manguerra",
    "Anderson",
    "Smith",
    "Johnson",
    "Pak",
    "Lee",
    "McArthur",
    "McCraken",
    "Flores",
    "West",
    "Kardashian",
    "Carey",
    "Johnston",
    "Freeman",
    "Miller",
    "Nguyen",
    "Vaught"
  };

  /**
   * Gets random first name from the first name list
   *
   * @return a random first name
   */
  public static String getFirstName() {
    Random random = new Random();
    return firstNames[random.nextInt(firstNames.length)];
  }

  /**
   * Gets a random last name from the last name list
   *
   * @return a random last name
   */
  public static String getLastName() {
    Random random = new Random();
    return lastNames[random.nextInt(lastNames.length)];
  }

  /**
   * Generates a random date between 2019-01-01 and 2020-12-31 to be allocated as a birthday
   * @return a random date
   */
  public static String getDOB() {
//    Random random = new Random();
//    int minDay = (int) LocalDate.of(2019, 1, 1).toEpochDay();
//    int maxDay = (int) LocalDate.of(2020, 12, 31).toEpochDay();
//    long randomDay = minDay + random.nextInt(maxDay - minDay);
//
    return "2020-01-01";
  }

  /**
   * Creates a random student using orchestrator methods to get first name,last name, and date of birth
   * @return a student
   */
  public static Student createStudent() {
    return new Student(getFirstName(), getLastName(), "2020-01-01");
  }
  /**
   * Generates a list of random students
   * @param numberOfStudents amount of students to create
   * @return a list of random students
   */
  public static List<Student> generateStudents(Integer numberOfStudents){
    List<Student> students = new ArrayList<>();

    for (int i = 0; i < numberOfStudents; i++){
      students.add(createStudent());
    }
    return students;
  }


}
