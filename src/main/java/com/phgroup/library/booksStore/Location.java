package com.phgroup.library.booksStore;

import com.phgroup.library.libraryManagement.Department;
import com.phgroup.library.libraryManagement.Library;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "location")
class Location {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "library_id")
  @NotEmpty
  private Library library;

  @ManyToOne
  @JoinColumn(name = "department_id")
  @NotEmpty
  private Department department;

  @Column(name = "row")
  private String row;

  @Column(name = "book_case")
  private String bookCase;

  @Column(name = "shelf")
  private String shelf;
}
