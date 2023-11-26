package com.ejada.webapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long isbn;

  private String title;

  // ========= Taking care of java mapping using java.utils.Set interface ============
  @ManyToMany
  @JoinTable(
    name = "books_authors",
    joinColumns = @JoinColumn(name = "book_id"), // the name of the column in the joining table that will reference my pk in the Book table
    inverseJoinColumns = @JoinColumn(name = "author_id") // in the other table
  )
  private Set<Author> authors;

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  // ========= Taking care of JPA mapping using java.utils.Set interface ============
  // ==> use the @ManyToMany annotation

  public Long getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setIsbn(Long isbn) {
    this.isbn = isbn;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
