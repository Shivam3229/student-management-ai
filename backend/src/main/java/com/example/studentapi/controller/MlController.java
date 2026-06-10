package com.example.studentapi.controller;

import org.springframework.http.ResponseEntity;
import com.example.studentapi.dto.StudentMarks;
import com.example.studentapi.service.MlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ml")
public class MlController {

    @Autowired
    private MlService mlService;

    @PostMapping("/predict")
    public ResponseEntity<String> predict(
            @RequestBody StudentMarks marks) {

        return ResponseEntity.ok(
                mlService.predict(marks));
    }
}