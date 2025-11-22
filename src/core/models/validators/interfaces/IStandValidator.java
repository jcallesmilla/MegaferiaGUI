/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.validators.interfaces;

/**
 *
 * @author boths
 */
public interface IStandValidator {
  boolean isValidId(long id);
    boolean isValidPrice(double price);
    String getIdError();
    String getPriceError();  
}
