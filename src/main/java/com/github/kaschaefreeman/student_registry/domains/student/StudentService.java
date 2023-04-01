package com.github.kaschaefreeman.student_registry.domains.student;

import java.util.List;

/**
 * Interface class provides abstraction layer for vehicle service
 */
public interface StudentService {
  List<Student> getStudents(Student student);

  Student saveStudent(Student student);
}
