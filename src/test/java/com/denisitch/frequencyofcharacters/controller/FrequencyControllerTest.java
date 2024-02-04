package com.denisitch.frequencyofcharacters.controller;

import com.denisitch.frequencyofcharacters.service.FrequencyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FrequencyController.class)
class FrequencyControllerTest {

    @MockBean
    private FrequencyService frequencyService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void showFrequencyOfCharactersOk() throws Exception {
        String testInput = "bab";
        Map<String, Long> testMap = new HashMap<>();
        testMap.put("b", 2L);
        testMap.put("a", 1L);
        when(frequencyService.getFrequencyOfCharacter(testInput)).thenReturn(testMap);
        mockMvc.perform(get("/api/frequency/{input}", testInput))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.b").value(2L))
                .andExpect(jsonPath("$.a").value(1L));
    }

    @Test
    void showFrequencyOfCharactersBigSize() throws Exception {
        String testInput = "qwertyqwertyqwertyqwertyqwerty!";
        mockMvc.perform(get("/api/frequency/{input}", testInput))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void showFrequencyOfCharactersBLank() throws Exception {
        String testInput = "";
        mockMvc.perform(get("/api/frequency/{input}", testInput))
                .andExpect(status().is4xxClientError());
    }
}