package com.phgroup.library.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Strings.isNullOrEmpty;
import static com.phgroup.library.reader.ReaderConverter.convertReaderDtoToModel;
import static com.phgroup.library.reader.ReaderConverter.convertReaderToDto;
import static java.util.stream.Collectors.toList;

@Service
public class ReaderService {

  private final ReaderRepository readerRepository;

  @Autowired
  public ReaderService(ReaderRepository readerRepository) {
    checkNotNull(readerRepository, "Expected not-null readerRepository");
    this.readerRepository = readerRepository;
  }

  public List<ReaderDto> findAllReaders() {
    return readerRepository.findAll().stream()
        .map(ReaderConverter::convertReaderToDto)
        .collect(toList());
  }

  public Optional<ReaderDto> findReaderById(long readerId) {
    return readerRepository.findById(readerId).map(ReaderConverter::convertReaderToDto);
  }

  public Optional<ReaderDto> findReaderBySurname(String surname) {
    checkArgument(!isNullOrEmpty(surname), "Expected non-empty surname");

    Optional<Reader> client = readerRepository.findBySurname(surname);
    return client.map(ReaderConverter::convertReaderToDto);
  }

  public ReaderDto addOrUpdateReader(ReaderDto readerDto) {
    checkNotNull(readerDto, "Expected not-null readerDto");

    Reader reader = convertReaderDtoToModel(readerDto);
    Reader savedReader = readerRepository.save(reader);

    return convertReaderToDto(savedReader);
  }

  public void deleteReaderById(long readerId) {
    if (readerRepository.existsById(readerId)) {
      readerRepository.deleteById(readerId);
    }
  }
}
