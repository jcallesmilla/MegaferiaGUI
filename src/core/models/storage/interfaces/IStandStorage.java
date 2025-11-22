/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.storage.interfaces;

import core.models.Stand;
import java.util.List;

/**
 *
 * @author boths
 */
public interface IStandStorage {
    void add(Stand stand);
    Stand findById(long id);
    boolean exists(long id);
    List<Stand> getAll();
}
