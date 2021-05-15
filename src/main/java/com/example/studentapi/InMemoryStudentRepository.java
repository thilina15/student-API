package com.example.studentapi;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStudentRepository implements StudentRepository {

    Map<String, Student> database = new HashMap<>();

    // save student
    @Override
    public void save(Student student) {
        // todo: save this student in the database
        database.put(student.id, student);
        System.out.println("new student added");
    }

    // get a student
    @Override
    public Student get(String id) {
        return database.get(id);
    }

    // delete a student
    @Override
    public void remove(String id) {
        database.remove(id);
        System.out.println("student removed");
    }

    // update a student
    @Override
    public void update(String id, Student student) {
        database.merge(id, student, (oldValue, newValue) -> newValue);
        System.out.println("student updated");
    }
}
