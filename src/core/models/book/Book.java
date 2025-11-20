/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.book;

import core.models.Publisher;
import core.models.person.Author;
import java.util.ArrayList;

public abstract class Book implements Cloneable {

    protected String title;
    protected ArrayList<Author> authors;
    protected final String isbn;
    protected String genre;
    protected String format;
    protected double value;
    protected Publisher publisher;

    public Book(String title, ArrayList<Author> authors, String isbn, String genre,
                String format, double value, Publisher publisher) {
        this.title = title;
        this.authors = new ArrayList<>(authors);  // defensive copy
        this.isbn = isbn;
        this.genre = genre;
        this.format = format;
        this.value = value;
        this.publisher = publisher;

        // Relación bidireccional
        for (Author a : authors) {
            a.addBook(this);
        }
        publisher.addBook(this);
    }

    @Override
    public Book clone() {
        try {
            Book cloned = (Book) super.clone();
            cloned.authors = new ArrayList<>(this.authors);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    // GETTERS (sin setters → inmutabilidad)
    public String getTitle() { return title; }
    public ArrayList<Author> getAuthors() { return new ArrayList<>(authors); }
    public String getIsbn() { return isbn; }
    public String getGenre() { return genre; }
    public String getFormat() { return format; }
    public double getValue() { return value; }
    public Publisher getPublisher() { return publisher; }

    @Override
    public String toString() {
        return title + " - " + isbn + " (" + format + ")";
    }
}
