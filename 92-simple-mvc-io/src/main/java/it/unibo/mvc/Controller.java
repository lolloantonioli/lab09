package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String SEP = File.separator;
    private static final String FILE_NAME = System.getProperty("user.home") + SEP + "output.txt";

    private File file = new File(FILE_NAME);

    /**
     * Set the file where the user wants to save the text.
     * 
     * @param file the file in which to save.
     */
    public void setFile(final File file) {
        this.file = file;
    }

    /**
     * Returns the current file.
     * 
     * @return the current file.
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Returns the current file path.
     * 
     * @return the current file path.
     */
    public String getPath() {
        return file.getPath();
    }

    /**
     * Writes text on the current file.
     * 
     * @param string the string to write.
     * @throws IOException if writing fails.
     */
    public void writeOnFile(final String string) throws IOException {
        Files.writeString(file.toPath(), string);
    }

}
