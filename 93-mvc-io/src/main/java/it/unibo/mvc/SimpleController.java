package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Implementation of a simple controller.
 * 
 */
public final class SimpleController implements Controller {

    private final List<String> history = new ArrayList<>();
    private String nextString;

    private static final String MSG = "The next string to print is unset";

    @Override
    public void setNextStringToPrint(final String string) {
        nextString = Objects.requireNonNull(string);
    }

    @Override
    public String getNextStringToPrint() {
        return nextString;
    }

    @Override
    public List<String> getPrintedStrings() {
        return Collections.unmodifiableList(history);
    }

    @Override
    public void printCurrentString() {
        if (nextString != null) {
            history.add(nextString);
            System.out.println(nextString); // NOPMD is requested in the exercise.
        } else {
            throw new IllegalStateException(MSG);
        }
    }

}
