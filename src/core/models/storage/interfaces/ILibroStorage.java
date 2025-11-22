/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.storage.interfaces;

import core.models.book.Book;
import core.models.person.Author;
import java.util.List;

/**
 *
 * @author boths
 */
public interface ILibroStorage {
   void add(Book book);
    Book findByIsbn(String isbn);
    boolean exists(String isbn);
    List<Book> getAll();
    List<Book> findByAuthor(Author author);
    List<Book> findByFormat(String format);
    List<Author> getAuthorsOrderedByPublishers(); 
}
