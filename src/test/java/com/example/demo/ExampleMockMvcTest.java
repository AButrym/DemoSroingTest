package com.example.demo;

import com.example.demo.controller.ExampleController;
import com.example.demo.model.ExampleModel;
import com.example.demo.service.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ExampleController.class)
class ExampleMockMvcTest {
    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private ExampleService exampleService;

    @TestConfiguration
    class AdditionalConfig {

    }

    @Test
    void exampleTest() throws Exception {
        String field = "field1";
        ExampleModel model = new ExampleModel(field);
        List<ExampleModel> models = List.of(model);

        given(exampleService.getAllModels()).willReturn(models);

        mvc.perform(get("/models")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].field", equalTo(field)));
        String text = "Hello world!";

        assertThat(text)
                .startsWith("Hello")
                .endsWith("!");

        assertThat(text, startsWith("Hello"));
        assertThat(text, endsWith("!"));
    }
}
