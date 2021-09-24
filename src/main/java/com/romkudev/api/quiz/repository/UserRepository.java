package com.romkudev.api.quiz.repository;

import com.romkudev.api.quiz.domain.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface UserRepository extends ReactiveMongoRepository<User, Long> {

    Optional<User> findByAlias(String alias);

    Flux<User> findAll(); // 복수

    Mono<User> findByUserid(); // 단일
}
