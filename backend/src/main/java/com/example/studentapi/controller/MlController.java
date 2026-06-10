package com.example.studentapi.controller;

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
    public String predict(
            @RequestBody StudentMarks marks) {

        return mlService.predict(marks);
    }
}