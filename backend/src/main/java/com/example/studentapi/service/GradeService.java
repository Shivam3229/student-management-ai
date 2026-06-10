package com.example.studentapi.service;

import org.springframework.stereotype.Service;

@Service
public class GradeService {

    public String calculateGrade(double percentage) {

        if (percentage >= 90)
            return "A";

        if (percentage >= 75)
            return "B";

        if (percentage >= 60)
            return "C";

        if (percentage >= 40)
            return "D";

        return "F";
    }
}