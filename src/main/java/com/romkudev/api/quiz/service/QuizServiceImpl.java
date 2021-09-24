package com.romkudev.api.quiz.service;

import com.romkudev.api.quiz.domain.Attempt;
import com.romkudev.api.quiz.domain.Quiz;
import com.romkudev.api.quiz.domain.User;
import com.romkudev.api.quiz.repository.AttemptRepository;
import com.romkudev.api.quiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService {

    private final GeneratorService generatorService;
    private final UserRepository userRepository;
    private final AttemptRepository attemptRepository;

    @Override
    public Mono<Quiz> createQuiz() {
        return Mono.just(new Quiz(
                generatorService.randomFactor(),
                generatorService.randomFactor()
        ));
    }

    @Override
    public boolean checkAttempt(Attempt attempt) {
        // User Exist ?
        Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

        // Prevent Manipulation
        Assert.isTrue(!attempt.isCorrect(), "Unable to send in graded state");

        // Score
        boolean isCorrect = attempt.getResultAttempt() ==
                attempt.getQuiz().getFactorA() * attempt.getQuiz().getFactorB();

        // Create Copy
        Attempt checkAttempt = new Attempt(attempt.getUser(), attempt.getQuiz(), attempt.getResultAttempt(), isCorrect);

        // Store
        attemptRepository.save(checkAttempt);

        return isCorrect;
    }

    @Override
    public Flux<Attempt> getStatsForUser(String alias) {
        return attemptRepository.findTop5ByUserAliasOrderByIdDesc(alias);
    }

    @Override
    public Mono<Attempt> getResultById(long id) {
        return null;
    }
}
