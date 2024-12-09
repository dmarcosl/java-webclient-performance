package com.dmarcosl.performance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("model")
public class Model {

  @Id
  @Column("item_id")
  private Long itemId;

  @Column("name")
  private String name;

  @Column("description")
  private String description;

  @Column("price")
  private Double price;

  @Column("quantity")
  private Integer quantity;

  @Column("stock")
  private Integer stock;

  @Column("category")
  private String category;

  @Column("url")
  private String url;

  @Column("image_url")
  private String imageUrl;

  @Column("is_active")
  private Boolean isActive;
}
