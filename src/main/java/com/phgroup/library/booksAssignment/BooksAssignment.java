package com.phgroup.library.booksAssignment;

import com.phgroup.library.book.Book;
import com.phgroup.library.libraryManagement.Employee;
import com.phgroup.library.reader.Reader;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "books_assignment")
class BooksAssignment {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "book_id")
  @NotEmpty
  private Book book;

  @ManyToOne
  @JoinColumn(name = "reader_id")
  @NotEmpty
  private Reader reader;

  @ManyToOne
  @JoinColumn(name = "employee_id")
  @NotEmpty
  private Employee employee;

  @Column(name = "rent_date")
  @NotEmpty
  private LocalDate rentDate;

  @Column(name = "return_date")
  private LocalDate returnDate;
}
