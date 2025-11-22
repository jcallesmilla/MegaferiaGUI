/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.book;

import core.models.Publisher;
import core.models.person.Author;
import core.models.person.Narrator;
import java.util.ArrayList;

public class Audiobook extends Book {

    private int duration;
    private Narrator narrator;

    public Audiobook(String title, ArrayList<Author> authors, String isbn, String genre,
                     String format, double value, Publisher publisher, int duration, Narrator narrator) {
        super(title, authors, isbn, genre, format, value, publisher);
        this.duration = duration;
        this.narrator = narrator;
        narrator.addBook(this);
    }

    @Override
    public Audiobook clone() {
        return (Audiobook) super.clone();
    }

    public int getDuration() { return duration; }
    public Narrator getNarrator() { return narrator; }
}
