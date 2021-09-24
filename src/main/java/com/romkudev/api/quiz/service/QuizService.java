package com.romkudev.api.quiz.service;

import com.romkudev.api.quiz.domain.Attempt;
import com.romkudev.api.quiz.domain.Quiz;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuizService {
    Mono<Quiz> createQuiz();

    boolean checkAttempt(Attempt attempt);

    Flux<Attempt> getStatsForUser(String alias);

    Mono<Attempt> getResultById(long id);
}
