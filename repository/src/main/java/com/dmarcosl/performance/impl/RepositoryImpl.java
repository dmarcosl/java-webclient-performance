package com.dmarcosl.performance.impl;

import com.dmarcosl.performance.domain.Domain;
import com.dmarcosl.performance.mapper.ModelMapper;
import com.dmarcosl.performance.repository.ModelRepository;
import com.dmarcosl.performance.repository.RepositoryInterface;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class RepositoryImpl implements RepositoryInterface {

  private final ModelRepository modelRepository;
  private final ModelMapper modelMapper;

  @Override
  public Mono<Domain> save(Domain domain) {
    return modelRepository.save(modelMapper.toModel(domain)).map(modelMapper::fromModel);
  }

  @Override
  public Mono<Domain> findById(Long itemId) {
    return modelRepository.findById(itemId).map(modelMapper::fromModel);
  }

  @Override
  public Flux<Domain> findAll() {
    return modelRepository.findAll(PageRequest.of(0, 10000)).map(modelMapper::fromModel);
  }
}
