package com.github.kaschaefreeman.student_registry.data;

import com.github.kaschaefreeman.student_registry.domains.student.Student;
import com.github.kaschaefreeman.student_registry.domains.student.StudentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Objects;

@Component
public class SeedData implements CommandLineRunner {
  private final Logger logger = LogManager.getLogger(SeedData.class);

  @Autowired private StudentRepository studentRepository;

  @Autowired private Environment env;

  public static final int DEFAULT_NUMBER_OF_STUDENTS = 20;

  /**
   * This code gets called when the api started to check if we should load data into the database
   *
   * @param strings string arguments
   */

@Override
  public void run(String... strings) {
    boolean loadData;

    try {
      // retrieves the value of custom property in application.yml
      loadData = Boolean.parseBoolean(env.getProperty("students.load"));
    } catch (NumberFormatException ex) {
      logger.error("config variable loadData could not be parsed, falling back to default");
      loadData = true;
    }

    if (loadData) {
      seedDatabase();
    }
  }

  /** Seeds database into the repositories with randomly generated data */
  private void seedDatabase() {
    int numberOfStudents;

    try {
      // retrieves the value of custom property in application.yml
      numberOfStudents =
          Integer.parseInt(Objects.requireNonNull(env.getProperty("students.number")));
    } catch (NumberFormatException ex) {
      logger.error("config variable numberOfProducts could not be parsed, falling back to default");
      // If it's not a string, set it to be a default value
      numberOfStudents = DEFAULT_NUMBER_OF_STUDENTS;
    }

    // Generate students
    List<Student> studentList = StudentFactory.generateStudents(numberOfStudents);

    // Persist students to database
    logger.info("Loading " + numberOfStudents + " products...");

    studentRepository.saveAll(studentList);

    logger.info("Data load is complete. You can now make request");
  }
}
