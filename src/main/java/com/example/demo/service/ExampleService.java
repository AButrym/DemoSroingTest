package com.example.demo.service;

import com.example.demo.exceptions.MyCustomException;
import com.example.demo.model.ExampleModel;
import com.example.demo.repository.ExampleModelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Random;

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
        if (new Random().nextBoolean()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                    "Unauthorized message");
        }
        if (new Random().nextBoolean()) {
            throw new ArithmeticException("My division by zero");
        }
        return repository.findAll();
    }
}
