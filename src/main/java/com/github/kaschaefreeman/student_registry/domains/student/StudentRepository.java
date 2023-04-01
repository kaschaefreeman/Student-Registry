package com.github.kaschaefreeman.student_registry.domains.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface to access and query the database
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {}
