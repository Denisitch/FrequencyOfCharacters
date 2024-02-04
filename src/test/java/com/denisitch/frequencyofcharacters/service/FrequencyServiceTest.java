package com.denisitch.frequencyofcharacters.service;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FrequencyServiceTest {

    @ParameterizedTest
    @MethodSource
    void getFrequencyOfCharacterTest(String input, Map.Entry<String, Long>[] expectedFrequencyOfCharacter) {
        FrequencyService frequencyService = new FrequencyServiceImpl();

        Map<String, Long> actualFrequencyOfCharacter = frequencyService.getFrequencyOfCharacter(input);

        assertArrayEquals(expectedFrequencyOfCharacter,
                actualFrequencyOfCharacter.entrySet().toArray());
    }

    private static Stream<Arguments> getFrequencyOfCharacterTest() {
        return Stream.of(
                Arguments.of("bab", Arrays.array(
                        entry("b", 2L),
                        entry("a", 1L)
                )),
                Arguments.of(" eeab  ba  abbec ", Arrays.array(
                        entry(" ", 6L),
                        entry("b", 4L),
                        entry("a", 3L),
                        entry("e", 3L),
                        entry("c", 1L)
                ))
        );
    }

}