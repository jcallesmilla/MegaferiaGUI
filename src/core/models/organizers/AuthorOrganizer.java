/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.organizers;

import core.models.organizers.interfaces.IAuthorOrganizer;
import core.models.person.Author;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author boths
 */
public class AuthorOrganizer implements IAuthorOrganizer{
  @Override
    public List<Author> sortByPublisherCount(List<Author> authors) {
        List<Author> sorted = new ArrayList<>(authors);
        // Ordenar primero por cantidad de editoriales (descendente), luego por ID (ascendente)
        sorted.sort(Comparator
            .comparingInt(Author::getPublisherQuantity).reversed()
            .thenComparingLong(Author::getId));
        return sorted;
    }
}
