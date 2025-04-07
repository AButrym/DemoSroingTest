package com.example.demo;

import com.example.demo.model.ExampleModel;
import com.example.demo.repository.ExampleModelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class IntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ExampleModelRepository repository;

    @Test
    void exampleTest() throws Exception {
        ExampleModel model1 = new ExampleModel("field");

        repository.saveAndFlush(model1);

        mockMvc.perform(get("/models")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].field", equalTo("field")));;
    }
}
