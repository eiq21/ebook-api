package com.ecommerce.ebookapi.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
public class Book {
  public Book(){
    this.createAt = LocalDateTime.now();
  }
  @Id
  private String id;
  @Indexed(unique = true)
  private String title;
  private Float price;
  private LocalDateTime createAt;
  private LocalDateTime updateAt;
}
