package com.dmarcosl.performance.repository;

import com.dmarcosl.performance.domain.Domain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RepositoryInterface {

  Mono<Domain> save(Domain domain);

  Mono<Domain> findById(Long itemId);

  Flux<Domain> findAll();
}
