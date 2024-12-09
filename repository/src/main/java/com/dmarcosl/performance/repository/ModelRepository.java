package com.dmarcosl.performance.repository;

import com.dmarcosl.performance.model.Model;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface ModelRepository extends R2dbcRepository<Model, Long> {}
