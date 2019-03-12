package com.phgroup.library.booksAssignment;

import com.phgroup.library.book.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BooksAssignmentRepository {

  @PersistenceContext private EntityManager entityManager;

  List<Book> findAllBooksByReaderId(long readerId) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Book> query = criteriaBuilder.createQuery(Book.class);
    Root<BooksAssignment> booksAssignmentRoot = query.from(BooksAssignment.class);

    query.where(
        criteriaBuilder.equal(booksAssignmentRoot.get("reader").get("reader_id"), readerId));
    TypedQuery<Book> bookTypedQuery = entityManager.createQuery(query);

    return bookTypedQuery.getResultList();
  }
}
