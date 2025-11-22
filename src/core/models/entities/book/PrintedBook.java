/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.book;

import core.models.Publisher;
import core.models.person.Author;
import java.util.ArrayList;

public class PrintedBook extends Book {

    private int pages;
    private int copies;

    public PrintedBook(String title, ArrayList<Author> authors, String isbn, String genre,
                       String format, double value, Publisher publisher, int pages, int copies) {
        super(title, authors, isbn, genre, format, value, publisher);
        this.pages = pages;
        this.copies = copies;
    }

    @Override
    public PrintedBook clone() {
        return (PrintedBook) super.clone();
    }

    public int getPages() { return pages; }
    public int getCopies() { return copies; }
}
