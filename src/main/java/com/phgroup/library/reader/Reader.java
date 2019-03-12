package com.phgroup.library.reader;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "reader")
public class Reader {
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

  @Column(name = "age")
  private int age;

  @ElementCollection
  @CollectionTable(name = "contacts")
  private List<String> contacts;
}
