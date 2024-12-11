package com.dmarcosl.performance.repository;

import com.dmarcosl.performance.model.Model;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface ModelRepository extends R2dbcRepository<Model, Long> {

  @Query("SELECT * FROM model limit 10000")
  Flux<Model> findAll(Pageable pageable);
}
