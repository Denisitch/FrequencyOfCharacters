package com.denisitch.frequencyofcharacters.service;

import java.util.Map;

public interface FrequencyService {

    Map<String, Long> getFrequencyOfCharacter(String input);
}
