package com.romkudev.api.quiz.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GeneratorServiceImplTest {

    @Mock
    GeneratorService generatorService;

    @BeforeEach
    void setUp() {
        generatorService = new GeneratorServiceImpl();
    }

    @DisplayName("Check Valid Generator Service")
    @Test
    void randomFactor() {
        List<Integer> randoms = IntStream.range(0, 1000)
                .map(i -> generatorService.randomFactor())
                .boxed()
                .collect(Collectors.toList());

        assertThat(randoms).containsOnlyElementsOf(IntStream.range(11,100)
                .boxed()
                .collect(Collectors.toList()));
    }
}