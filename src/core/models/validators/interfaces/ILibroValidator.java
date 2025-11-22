/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package core.models.validators.interfaces;

import java.util.List;

/**
 *
 * @author boths
 */
public interface ILibroValidator {
    boolean isValidIsbn(String isbn);
    boolean isValidTitle(String title);
    boolean isValidValue(double value);
    boolean isValidAuthorList(List<Long> authorIds);
    boolean hasNoDuplicates(List<Long> authorIds);
    String getIsbnError();
    String getTitleError();
    String getValueError();
    String getAuthorListError();
}
