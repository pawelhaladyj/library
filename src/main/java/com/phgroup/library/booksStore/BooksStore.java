package com.phgroup.library.booksStore;

import com.phgroup.library.book.Book;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "books_store")
public class BooksStore {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "book_id")
  @NotEmpty
  private Book book;

  @Column(name = "library_number")
  @NotEmpty
  private String libraryNumber;

  @Column(name = "amount")
  private int amount;

  @ManyToOne
  @JoinColumn(name = "location_id")
  Location location;
}
