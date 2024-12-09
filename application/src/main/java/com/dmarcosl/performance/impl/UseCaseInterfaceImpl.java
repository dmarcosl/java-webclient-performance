package com.dmarcosl.performance.impl;

import com.dmarcosl.performance.domain.Domain;
import com.dmarcosl.performance.repository.RepositoryInterface;
import com.dmarcosl.performance.service.UseCaseInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UseCaseInterfaceImpl implements UseCaseInterface {

  private final RepositoryInterface repository;

  @Override
  public Mono<Domain> postItem(Domain domain) {
    return repository.save(domain);
  }

  @Override
  public Mono<Domain> getItem(Long itemId) {
    return repository.findById(itemId);
  }

  @Override
  public Flux<Domain> getItems() {
    return repository.findAll();
  }
}
