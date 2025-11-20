/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.storage;

import core.models.*;
import core.models.book.*;
import core.models.person.*;
import java.util.*;

public class Storage {
    
    private static Storage instance;
    
    // Listas internas (nadie las toca directamente)
    private final List<Stand> stands = new ArrayList<>();
    private final List<Publisher> publishers = new ArrayList<>();
    private final List<Person> people = new ArrayList<>();
    private final List<Book> books = new ArrayList<>();

    // Constructor privado → Singleton
    private Storage() {}

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    // ==================== STANDS ====================
    public List<Stand> getStands() {
        List<Stand> copia = new ArrayList<>();
        for (Stand s : stands) {
            copia.add(s.clone());
        }
        return copia;
    }

    public boolean standExists(long id) {
        for (Stand s : stands) {
            if (s.getId() == id) return true;
        }
        return false;
    }

    public Stand findStandById(long id) {
        for (Stand s : stands) {
            if (s.getId() == id) return s.clone();
        }
        return null;
    }

    public void addStand(Stand stand) {
        stands.add(stand.clone());
    }

    public int getStandCount() {
        return stands.size();
    }

    // ==================== EDITORIALES ====================
    public List<Publisher> getPublishers() {
        List<Publisher> copia = new ArrayList<>();
        for (Publisher p : publishers) {
            copia.add(p.clone());
        }
        return copia;
    }

    public boolean publisherExists(String nit) {
        for (Publisher p : publishers) {
            if (p.getNit().equals(nit)) return true;
        }
        return false;
    }

    public Publisher findPublisherByNit(String nit) {
        for (Publisher p : publishers) {
            if (p.getNit().equals(nit)) return p.clone();
        }
        return null;
    }

    public void addPublisher(Publisher publisher) {
        publishers.add(publisher.clone());
    }

    // ==================== PERSONAS ====================
    public List<Person> getPeople() {
        List<Person> copia = new ArrayList<>();
        for (Person p : people) {
            copia.add(p.clone());
        }
        return copia;
    }

    public List<Author> getAuthors() {
        List<Author> autores = new ArrayList<>();
        for (Person p : people) {
            if (p instanceof Author) {
                autores.add((Author) p.clone());
            }
        }
        return autores;
    }

    public List<Manager> getManagers() {
        List<Manager> gerentes = new ArrayList<>();
        for (Person p : people) {
            if (p instanceof Manager) {
                gerentes.add((Manager) p.clone());
            }
        }
        return gerentes;
    }

    public List<Narrator> getNarrators() {
        List<Narrator> narradores = new ArrayList<>();
        for (Person p : people) {
            if (p instanceof Narrator) {
                narradores.add((Narrator) p.clone());
            }
        }
        return narradores;
    }

    public boolean personExists(long id) {
        for (Person p : people) {
            if (p.getId() == id) return true;
        }
        return false;
    }

    public void addPerson(Person person) {
        people.add(person.clone());
    }

    // ==================== LIBROS ====================
    public List<Book> getBooks() {
        List<Book> copia = new ArrayList<>();
        for (Book b : books) {
            copia.add(b.clone());
        }
        return copia;
    }

    public boolean bookExists(String isbn) {
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) return true;
        }
        return false;
    }

    public void addBook(Book book) {
        books.add(book.clone());
    }

    // ==================== CONSULTAS DEL ENUNCIADO ====================
    public List<Book> findBooksByAuthor(Author author) {
        List<Book> resultado = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthors().contains(author)) {
                resultado.add(b.clone());
            }
        }
        return resultado;
    }

    public List<Book> findBooksByFormat(String format) {
        List<Book> resultado = new ArrayList<>();
        for (Book b : books) {
            if (b.getFormat().equalsIgnoreCase(format)) {
                resultado.add(b.clone());
            }
        }
        return resultado;
    }

    public List<Author> getAuthorsOrderedByDifferentPublishers() {
        List<Author> autores = getAuthors();
        autores.sort((a1, a2) -> 
            Integer.compare(a2.getPublisherQuantity(), a1.getPublisherQuantity())
        );
        return autores;
    }
}