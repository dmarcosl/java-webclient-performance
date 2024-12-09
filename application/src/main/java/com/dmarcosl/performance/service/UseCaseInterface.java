package com.dmarcosl.performance.service;

import com.dmarcosl.performance.domain.Domain;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UseCaseInterface {

  Mono<Domain> postItem(Domain domain);

  Mono<Domain> getItem(Long itemId);

  Flux<Domain> getItems();
}
