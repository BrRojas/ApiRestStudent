
package com.example.student_management.Repositories;

import com.example.student_management.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long>{
    
}
