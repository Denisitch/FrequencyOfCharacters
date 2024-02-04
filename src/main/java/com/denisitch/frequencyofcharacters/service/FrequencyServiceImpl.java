package com.denisitch.frequencyofcharacters.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class FrequencyServiceImpl implements FrequencyService{
    @Override
    public Map<String, Long> getFrequencyOfCharacter(String input) {

        return Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(LinkedHashMap::new, (m, c) -> m.put(c.getKey(), c.getValue()), LinkedHashMap::putAll);
    }
}
