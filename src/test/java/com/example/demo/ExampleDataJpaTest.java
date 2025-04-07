package com.example.demo;

import com.example.demo.model.ExampleModel;
import com.example.demo.repository.ExampleModelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DataJpaTest
class ExampleDataJpaTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ExampleModelRepository exampleRepository;

    @Test
    void exampleTest() {
        String field = "Field";
        ExampleModel model = new ExampleModel(field);
        ExampleModel insertedExample = exampleRepository.save(model);

        entityManager.flush();
        entityManager.clear();

        ExampleModel actual = entityManager.find(ExampleModel.class, insertedExample.getId());
        ExampleModel modelActual =  exampleRepository.findByField(field);

        assertEquals(field, modelActual.getField());
        assertEquals(insertedExample, modelActual);
        assertEquals(insertedExample, actual);
    }
}
