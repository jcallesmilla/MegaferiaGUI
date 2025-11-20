/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.person;

import core.models.book.Audiobook;
import java.util.ArrayList;

public class Narrator extends Person {

    private ArrayList<Audiobook> books;

    public Narrator(long id, String firstname, String lastname) {
        super(id, firstname, lastname);
        this.books = new ArrayList<>();
    }

    @Override
    public Narrator clone() {
        Narrator cloned = (Narrator) super.clone();
        cloned.books = new ArrayList<>(this.books);
        return cloned;
    }

    public int getBookQuantity() {
        return this.books.size();
    }
    
    public void addBook(Audiobook book) {
        this.books.add(book);
    }

    public ArrayList<Audiobook> getBooks() {
        return new ArrayList<>(books);
    }
}
