/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.storage.interfaces;

import core.models.Publisher;
import core.models.Stand;

/**
 *
 * @author boths
 */
public interface ICompraStorage {
    void linkStandWithPublisher(Stand stand, Publisher publisher);
    Stand getStandReference(long id);
    Publisher getPublisherReference(String nit);
}
