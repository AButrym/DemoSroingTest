package com.example.demo.repository;

import com.example.demo.model.ExampleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExampleModelRepository extends JpaRepository<ExampleModel, Long> {
    ExampleModel findByField(String field);
}