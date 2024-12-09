package com.dmarcosl.performance.controller;

import com.dmarcosl.performance.dto.Dto;
import com.dmarcosl.performance.mapper.DtoMapper;
import com.dmarcosl.performance.service.UseCaseInterface;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
public class Controller {

  private final UseCaseInterface useCase;
  private final DtoMapper dtoMapper;

  @GetMapping("/health")
  public Mono<ResponseEntity<String>> health() {
    return Mono.just(ResponseEntity.ok("OK"));
  }

  @PostMapping("/post-item")
  public Mono<ResponseEntity<Dto>> postItem(@RequestBody Dto dto) {
    return useCase
        .postItem(dtoMapper.fromDto(dto))
        .map(domain -> ResponseEntity.ok(dtoMapper.toDto(domain)));
  }

  @GetMapping("/get-item/{itemId}")
  public Mono<ResponseEntity<Dto>> getItem(@PathVariable("itemId") Long itemId) {
    return useCase
        .getItem(itemId)
        .map(domain -> ResponseEntity.ok(dtoMapper.toDto(domain)))
        .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @GetMapping("/get-item-list")
  public Flux<Dto> getItemList() {
    return useCase.getItems().map(dtoMapper::toDto);
  }

  @GetMapping("/get-item-cache/{itemId}")
  @Cacheable("modelById")
  public Mono<ResponseEntity<Dto>> getItemCache(@PathVariable("itemId") Long itemId) {
    return getItem(itemId);
  }

  @GetMapping("/get-item-cache-list")
  @Cacheable("modelsList")
  public Flux<Dto> getItemCacheList() {
    return getItemList();
  }
}
