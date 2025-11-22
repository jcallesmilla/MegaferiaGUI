/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.storage.interfaces;

import core.models.Publisher;
import java.util.List;

/**
 *
 * @author boths
 */
public interface IEditorialStorage {
   void add(Publisher publisher);
    Publisher findByNit(String nit);
    boolean exists(String nit);
    List<Publisher> getAll();  
}
