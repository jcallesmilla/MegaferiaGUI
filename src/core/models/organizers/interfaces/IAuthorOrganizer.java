/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.organizers.interfaces;

import core.models.person.Author;
import java.util.List;

/**
 *
 * @author boths
 */
public interface IAuthorOrganizer {
     List<Author> sortByPublisherCount(List<Author> authors);
}
