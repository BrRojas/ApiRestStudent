package com.example.student_management.controllers;

import com.example.student_management.Repositories.StudentRepository;
import com.example.student_management.domain.Student;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;



//decoramos el controlador con el restcontroller

@RestController
//unificamos la ruta con el requestmapping
@RequestMapping("/alumnos")
public class StudentController {
    //Lista de recursos
    @Autowired
    private StudentRepository studentRepository;
     
// Mostrar alumnos
@GetMapping   
public List<Student> getStudents(){
    return studentRepository.findAll();
}
    
// mostrae alumno por su id
@GetMapping("/{id}")
public Student getStudent(@PathVariable Long id){
    return studentRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("No se encontro el alumno con el ID" + id));    
}

//agregar un alumno
@PostMapping
public Student postStudent(@Valid @RequestBody Student student){
   
    return studentRepository.save(student);
    
}

//modificar total  
@PutMapping("/{id}")
public Student putStudent(@PathVariable Long id, @RequestBody Student detallesStudent){
    Student student = studentRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("No se encontro el alumno con el ID" + id));
    
    student.setName(detallesStudent.getName());
    student.setEmail(detallesStudent.getEmail());
    student.setAge(detallesStudent.getAge());
    student.setCurse(detallesStudent.getCurse());
    return studentRepository.save(student);
    }




//eliminar un alumno mediante su ID
@DeleteMapping("/{id}")
public Student deleteStudent(@PathVariable Long id){
    Student student = studentRepository.findById(id)
    .orElseThrow(() -> new RuntimeException("No se encontró el alumno con el ID " + id));
    studentRepository.delete(student);
    return student;
}


}





























 
