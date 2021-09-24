package com.romkudev.api.quiz.repository;

import com.romkudev.api.quiz.domain.Attempt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface AttemptRepository extends ReactiveMongoRepository<Attempt, Long> {

    Flux<Attempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);
}
