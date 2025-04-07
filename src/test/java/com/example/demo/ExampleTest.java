package com.example.demo;

import com.example.demo.model.ExampleModel;
import com.example.demo.repository.ExampleModelRepository;
import com.example.demo.service.ExampleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ExampleTest {
    @TestConfiguration
    static class
    ExampleServiceImplTestContextConfiguration {
        @Bean
        public ExampleService exampleService
                (ExampleModelRepository exampleRepository) {
            return new
                    ExampleService(exampleRepository);
        }
    }

    @MockitoBean
    private ExampleModelRepository exampleRepository;

    @Autowired
    ExampleService exampleService;

    @BeforeEach
    void setUp() {
        ExampleModel model = new ExampleModel("Field1");
        when(exampleRepository.findByField("Field"))
                .thenReturn(model);
    }

    @Test
    void exampleTestWithMock() {
        String searchField = "Field1";
        String actual = exampleService
                .getModelByField("Field").getField();
        assertEquals(searchField, actual);
    }
}
