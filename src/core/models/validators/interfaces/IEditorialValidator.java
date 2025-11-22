/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.validators.interfaces;

/**
 *
 * @author boths
 */
public interface IEditorialValidator {
    boolean isValidNit(String nit);
    boolean isValidName(String name);
    boolean isValidAddress(String address);
    String getNitError();
    String getNameError();
    String getAddressError(); 
}
