package com.example.student_management.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Student {

    // Atributos de un alumno
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;
    
    @Email(message = "Debe ser un correo electrónico válido")
    @NotBlank(message = "El correo electrónico no puede estar vacío") 
    private String email;
    
    @Min(value = 18, message = "La edad mínima es 18 años")
    private int age;
    
    @NotBlank(message = "El curso no puede estar vacío")
    private String curse;

    // Constructor por defecto (requerido por JPA)
    public Student() {
    }

    // Constructor parametrizado
    public Student(String name, String email, int age, String curse) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.curse = curse;
    }

    // Métodos getter y setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCurse() {
        return curse;
    }

    public void setCurse(String curse) {
        this.curse = curse;
    }
}
