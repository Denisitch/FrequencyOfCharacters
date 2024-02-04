package com.denisitch.frequencyofcharacters;

import com.denisitch.frequencyofcharacters.controller.FrequencyController;
import com.denisitch.frequencyofcharacters.service.FrequencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class FrequencyOfCharactersApplicationTests {

    @Autowired
    private FrequencyController frequencyController;

    @Autowired
    private FrequencyService frequencyService;

    @Test
    void contextLoads() {
        assertThat(frequencyController).isNotNull();
        assertThat(frequencyService).isNotNull();
    }

}
