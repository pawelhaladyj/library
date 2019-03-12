package com.phgroup.library.reader;

import static com.google.common.base.Preconditions.checkNotNull;

public class ReaderConverter {

  private ReaderConverter() {
    throw new UnsupportedOperationException();
  }

  public static ReaderDto convertReaderToDto(Reader reader) {
    checkNotNull(reader, "Expected not-null reader");

    ReaderDto readerDto = new ReaderDto();
    readerDto.setId(reader.getId());
    readerDto.setName(reader.getName());
    readerDto.setSurname(reader.getSurname());
    readerDto.setAge(reader.getAge());
    readerDto.setContacts(reader.getContacts());

    return readerDto;
  }

  public static Reader convertReaderDtoToModel(ReaderDto readerDto) {
    checkNotNull(readerDto, "Expected not-null readerDto");

    Reader reader = new Reader();
    reader.setId(readerDto.getId());
    reader.setName(readerDto.getName());
    reader.setSurname(readerDto.getSurname());
    reader.setAge(readerDto.getAge());
    reader.setContacts(readerDto.getContacts());

    return reader;
  }
}
