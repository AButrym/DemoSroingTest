package com.example.demo.controller;

import com.example.demo.model.ExampleModel;
import com.example.demo.service.ExampleService;
import jakarta.servlet.ServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExampleController {
    private ExampleService exampleService;

    public ExampleController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/models")
    public List<ExampleModel> getModels() {
        return exampleService.getAllModels();
    }
}
