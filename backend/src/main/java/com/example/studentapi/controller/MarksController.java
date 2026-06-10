package com.example.studentapi.controller;

import com.example.studentapi.entity.Marks;
import com.example.studentapi.repository.MarksRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    private final MarksRepository repository;

    public MarksController(MarksRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Marks addMarks(@RequestBody Marks marks) {
        return repository.save(marks);
    }

    @GetMapping
    public List<Marks> getAllMarks() {
        return repository.findAll();
    }

    @GetMapping("/student/{studentId}")
    public List<Marks> getStudentMarks(
            @PathVariable Long studentId) {

        return repository.findByStudentId(studentId);
    }
}