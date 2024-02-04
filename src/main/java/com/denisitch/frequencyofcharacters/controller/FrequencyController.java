package com.denisitch.frequencyofcharacters.controller;

import com.denisitch.frequencyofcharacters.service.FrequencyService;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
@Validated
public class FrequencyController {

    private final FrequencyService frequencyService;

    @Autowired
    public FrequencyController(FrequencyService frequencyService) {
        this.frequencyService = frequencyService;
    }

    @GetMapping("/frequency/{input}")
    public Map<String, Long> showFrequencyOfCharacters(
            @PathVariable("input")
            @NotBlank
            @Size(max = 30)
            String input) {
        return frequencyService.getFrequencyOfCharacter(input);
    }
}
