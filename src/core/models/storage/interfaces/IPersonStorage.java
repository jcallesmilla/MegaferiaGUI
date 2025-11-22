/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.storage.interfaces;

import core.models.person.Author;
import core.models.person.Manager;
import core.models.person.Narrator;
import core.models.person.Person;
import java.util.List;

/**
 *
 * @author boths
 */
public interface IPersonStorage {
   void addPerson(Person person);
    Person findById(long id);
    boolean exists(long id);
    List<Person> getAllPeople();
    List<Author> getAllAuthors();
    List<Manager> getAllManagers();
    List<Narrator> getAllNarrators(); 
}
