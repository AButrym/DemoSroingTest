package com.example.demo.service;

import com.example.demo.model.ExampleModel;
import com.example.demo.repository.ExampleModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampleService {
    ExampleModelRepository repository;

    public ExampleService(ExampleModelRepository repository) {
        this.repository = repository;
    }

    public ExampleModel getModelByField(String field) {
        return repository.findByField(field);
    }
    public List<ExampleModel> getAllModels() {
        return repository.findAll();
    }
}
