package com.example.studentapi.dto;

import com.example.studentapi.entity.Marks;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultResponse {

    private String studentName;

    private List<Marks> subjects;

    private double percentage;

    private String grade;
}