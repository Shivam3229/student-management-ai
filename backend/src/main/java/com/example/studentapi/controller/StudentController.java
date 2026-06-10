package com.example.studentapi.controller;

import com.example.studentapi.dto.ResultResponse;
import com.example.studentapi.entity.Marks;
import com.example.studentapi.entity.Student;
import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.repository.MarksRepository;
import com.example.studentapi.repository.StudentRepository;
import com.example.studentapi.service.GradeService;
import org.springframework.web.bind.annotation.*;
import com.example.studentapi.dto.StudentRankingResponse;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;
    private final MarksRepository marksRepository;
    private final GradeService gradeService;

    public StudentController(
            StudentRepository repository,
            MarksRepository marksRepository,
            GradeService gradeService) {

        this.repository = repository;
        this.marksRepository = marksRepository;
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {

        Student existingStudent = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        existingStudent.setName(student.getName());
        existingStudent.setRollNumber(student.getRollNumber());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setSemester(student.getSemester());

        return repository.save(existingStudent);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
        return "Student deleted successfully";
    }

    @GetMapping("/{id}/result")
    public ResultResponse getResult(@PathVariable Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found"));

        List<Marks> marks =
                marksRepository.findByStudentId(id);

        double obtained =
                marks.stream()
                        .mapToDouble(Marks::getMarksObtained)
                        .sum();

        double max =
                marks.stream()
                        .mapToDouble(Marks::getMaxMarks)
                        .sum();

        double percentage =
                (obtained / max) * 100;

        String grade =
                gradeService.calculateGrade(percentage);

        return new ResultResponse(
                student.getName(),
                marks,
                percentage,
                grade
        );
    }
    @GetMapping("/rankings")
    public List<StudentRankingResponse> rankings() {

        return repository.findAll()
                .stream()
                .map(student -> {

                    List<Marks> marks =
                            marksRepository.findByStudentId(
                                    student.getId());

                    double obtained =
                            marks.stream()
                                    .mapToDouble(
                                            Marks::getMarksObtained)
                                    .sum();

                    double max =
                            marks.stream()
                                    .mapToDouble(
                                            Marks::getMaxMarks)
                                    .sum();

                    double percentage =
                            max == 0
                                    ? 0
                                    : (obtained / max) * 100;

                    return new StudentRankingResponse(
                            student.getName(),
                            percentage
                    );
                })
                .sorted(
                        (a, b) ->
                                Double.compare(
                                        b.getPercentage(),
                                        a.getPercentage()))
                .toList();
    }
}