package com.phgroup.library.book;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "book")
public class Book {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title")
  @NotEmpty
  private String title;

  @Column(name = "author")
  @NotEmpty
  private String author;

  @Column(name = "isbn")
  private String isbn;

  @Column(name = "publisher")
  private String publisher;
}
