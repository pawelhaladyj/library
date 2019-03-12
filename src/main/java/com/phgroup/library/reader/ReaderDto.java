package com.phgroup.library.reader;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
class ReaderDto {
  private Long id;

  @NotEmpty private String name;

  @NotEmpty private String surname;

  private int age;

  private List<String> contacts;
}
