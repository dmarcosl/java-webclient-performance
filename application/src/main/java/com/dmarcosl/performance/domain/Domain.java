package com.dmarcosl.performance.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Domain {

  private Long itemId;
  private String name;
  private String description;
  private Double price;
  private Integer quantity;
  private Integer stock;
  private String category;
  private String url;
  private String imageUrl;
  private Boolean isActive;
}
