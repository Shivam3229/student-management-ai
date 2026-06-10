package com.example.studentapi.service;

import com.example.studentapi.dto.StudentMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MlService {

    @Autowired
    private RestTemplate restTemplate;

    public String predict(StudentMarks marks) {

        String url = "http://localhost:5000/predict";

        return restTemplate.postForObject(
                url,
                marks,
                String.class
        );
    }
}