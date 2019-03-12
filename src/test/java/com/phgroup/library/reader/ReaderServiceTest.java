package com.phgroup.library.reader;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ReaderServiceTest {

  static Reader[] testReader =
      new Reader[] {
        new Reader(1L, "name1", "surname1", 35, newArrayList("r1@abc.com", "123123123")),
        new Reader(1L, "name2", "surname2", 36, newArrayList("r2@abc.com", "555777999")),
        new Reader(1L, "name3", "surname3", 37, newArrayList("222333444")),
        new Reader(1L, "name4", "surname4", 38, newArrayList("r4@abc.com"))
      };

  static ReaderDto[] testReaderDto =
      new ReaderDto[] {
        new ReaderDto(1L, "name1", "surname1", 35, newArrayList("r1@abc.com", "123123123")),
        new ReaderDto(1L, "name2", "surname2", 36, newArrayList("r2@abc.com", "555777999")),
        new ReaderDto(1L, "name3", "surname3", 37, newArrayList("222333444")),
        new ReaderDto(1L, "name4", "surname4", 38, newArrayList("r4@abc.com"))
      };

  @Rule public ExpectedException expectedException = ExpectedException.none();
  private ReaderService readerService;
  @MockBean private ReaderRepository readerRepository;

  @Before
  public void setUp() throws Exception {
    readerService = new ReaderService(readerRepository);
  }

  @Test
  public void shouldFindAllReaders() {
    // given
    Reader givenReader1 = testReader[0];
    ReaderDto expectedReaderDto1 = testReaderDto[0];
    Reader givenReader2 = testReader[1];
    ReaderDto expectedReaderDto2 = testReaderDto[1];

    List<Reader> expectedReaders = newArrayList(givenReader1, givenReader2);
    when(readerRepository.findAll()).thenReturn(expectedReaders);

    // when
    List<ReaderDto> actualClientDtos = readerService.findAllReaders();

    // then
    assertThat(actualClientDtos, hasSize(2));
    assertThat(actualClientDtos, hasItems(expectedReaderDto1, expectedReaderDto2));
  }

  @Test
  public void shouldFindReaderById() {}

  @Test
  public void shouldFindReaderBySurname() {}

  @Test
  public void shouldAddReader() {}

  @Test
  public void shouldUpdateReader() {}

  @Test
  public void shouldDeleteReaderByIdWhenReaderIdExistsAndReaderHasNoAssignedBooks() {}

  @Test
  public void shoulThrowExceptionWhenDeleteNoExistsReaderId() {}

  @Test
  public void shouldThrowExceptionWhenReaderIdExistsAndReaderHasAssignedBooks() {}
}
