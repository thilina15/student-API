package com.example.studentapi;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    StudentRepository repository = new InMemoryStudentRepository();

    // rest ENDPOINTS
    // create s student
    @PostMapping("/student")
    public void createStudent(@RequestBody Student student) {
        // logic to save the student in the database

        repository.save(student);
    }

    // get a student
    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable String id) {

        return repository.get(id);
    }

    // remove a student
    @DeleteMapping("/student/{id}")
    public void removeStudent(@PathVariable String id) {
        repository.remove(id);
    }

    // update a student
    @PutMapping("/student/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable String id) {
        repository.update(id, student);
    }
}
