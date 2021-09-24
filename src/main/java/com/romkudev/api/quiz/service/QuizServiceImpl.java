package com.romkudev.api.quiz.service;

import com.romkudev.api.quiz.domain.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final GeneratorService generatorService;

    @Override
    public Mono<Quiz> createQuiz() {
        return Mono.just(new Quiz(
                generatorService.randomFactor(),
                generatorService.randomFactor()
        ));
    }
}
