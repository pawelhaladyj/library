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
@Table(name = "employee")
public class Employee {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  @NotEmpty
  private String name;

  @Column(name = "surname")
  @NotEmpty
  private String surname;

  @Enumerated(EnumType.STRING)
  @Column(name = "employee_role")
  @NotEmpty
  private EmployeeRole employeeRole;
}
