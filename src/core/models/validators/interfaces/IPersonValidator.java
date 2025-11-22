/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.validators.interfaces;

/**
 *
 * @author boths
 */
public interface IPersonValidator {
    boolean isValidId(long id);
    boolean isValidName(String name);
    String getIdError();
    String getNameError();
}
