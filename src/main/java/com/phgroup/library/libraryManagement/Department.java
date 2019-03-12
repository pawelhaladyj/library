package com.phgroup.library.libraryManagement;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "department")
public class Department {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "code_name", length = 9)
  @NotEmpty
  private String codeName;

  @Column(name = "name")
  @NotEmpty
  private String name;
}
