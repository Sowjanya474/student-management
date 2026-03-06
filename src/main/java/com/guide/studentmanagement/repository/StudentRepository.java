package com.guide.studentmanagement.repository;

import com.guide.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Spring automatically generates the SQL for this! ✨
    List<Student> findByNameContainingIgnoreCase(String name);
}