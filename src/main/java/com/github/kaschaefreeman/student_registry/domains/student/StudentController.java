package com.github.kaschaefreeman.student_registry.domains.student;

import com.github.kaschaefreeman.student_registry.constants.Paths;
import com.github.kaschaefreeman.student_registry.constants.StringConstants;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = Paths.STUDENT_PATH)
public class StudentController {
  Logger logger = LogManager.getLogger(StudentController.class);

  @Autowired private StudentService studentService;

  /**
   * Get method to retrieve all vehicles
   *
   * @return A list of vehicleDTOs
   */
  @GetMapping
  public ResponseEntity<List<StudentDTO>> getStudents(Student student) {
    logger.info(StringConstants.LOG_GET_STUDENTS);

    ObjectMapper mapper = new ObjectMapper();

    List<Student> students = studentService.getStudents(student);

    List<StudentDTO> studentDTOS =
        mapper.convertValue(students, new TypeReference<List<StudentDTO>>() {});

    return new ResponseEntity<>(studentDTOS, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<StudentDTO> saveStudent(@RequestBody StudentDTO student) {
    logger.info(StringConstants.LOG_SAVE_STUDENTS);

    ObjectMapper mapper = new ObjectMapper();

    Student savedStudent = mapper.convertValue(student, Student.class);

    Student newStudent = studentService.saveStudent(savedStudent);

    StudentDTO createdStudent = mapper.convertValue(newStudent, StudentDTO.class);

    return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
  }
}
