package com.github.kaschaefreeman.student_registry.domains.student;

import com.github.kaschaefreeman.student_registry.constants.StringConstants;
import com.github.kaschaefreeman.student_registry.exceptions.BadRequest;
import com.github.kaschaefreeman.student_registry.exceptions.ServerUnavailable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * A class to implement all methods from the student service interface
 */
@Service
public class StudentServiceImpl implements StudentService {

  private final Logger logger = LogManager.getLogger(StudentServiceImpl.class);

  private final StudentRepository studentRepository;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  /**
   * Gets all students from the student repository
   * @param student base student to search for
   * @return a list of students
   */
  @Override
  public List<Student> getStudents(Student student) {
    try {
      return studentRepository.findAll(Example.of(student));
    } catch (DataAccessException e) {
      String error = e.getMessage();
      logger.error(error);
      throw new ServerUnavailable(error);
    }
  }

  /**
   * Saves student to repository
   * @param student student to save
   * @return saved student from repository
   */
  @Override
  public Student saveStudent(Student student) {
    if(student.getFirst_name() == null) throw new BadRequest(StringConstants.STUDENT_NAME_NULL_400);
    try{
      student.setAge();
      return studentRepository.save(student);
    } catch (DataAccessException e){
      String error = e.getMessage();
      logger.error(error);
      throw new ServerUnavailable(error);
    }
  }
}
