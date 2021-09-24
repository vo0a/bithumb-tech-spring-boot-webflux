package com.romkudev.api.quiz.service;

import com.romkudev.api.quiz.domain.Quiz;
import reactor.core.publisher.Mono;

public interface QuizService {
    Mono<Quiz> createQuiz();
}
