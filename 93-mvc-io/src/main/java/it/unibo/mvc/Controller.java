package it.unibo.mvc;

import java.util.List;

/**
 * Models a simple controller responsible of I/O access.<br>
 * It considers only the standard output, and it is able to print on it.
 */
public interface Controller {

    /**
     * Sets the next string to print.
     * 
     * @param string the next string to print.
     * @throws NullPointerException if the string is null.
     */
    void setNextStringToPrint(String string);

    /**
     * Gets the next string to print.
     * 
     * @return the next string to print.
     */
    String getNextStringToPrint();

    /**
     * Gets the history of the printed strings.
     * 
     * @return a {@code List} of {@code Strings}.
     */
    List<String> getPrintedStrings();

    /**
     * Prints the current string.
     * 
     * @throws IllegalStateException if the current string is unset.
     */
    void printCurrentString();

}
