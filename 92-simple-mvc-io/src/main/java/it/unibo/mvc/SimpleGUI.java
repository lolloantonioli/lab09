package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {

    private static final String FRAME_TITLE = "My first Java graphical interface";
    private static final String MSG_WRITING = "Writing has failed";
    private static final String ERROR_TITLE = "Error";

    private final JFrame frame = new JFrame(FRAME_TITLE);

    /**
     * Creates a simple GUI which has a text area with a button "Save".<br>
     * The button is used to save the text wrote in the text area in a file.
     */
    public SimpleGUI() {
        final JPanel myPanel = new JPanel();
        final JTextArea textArea = new JTextArea("Write here");
        final Controller controller = new Controller();
        final JButton save = new JButton("Save");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myPanel.setLayout(new BorderLayout());
        myPanel.add(textArea, BorderLayout.CENTER);
        myPanel.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeOnFile(textArea.getText());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, MSG_WRITING, ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setContentPane(myPanel);
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();

        frame.setSize(sw / 3, sh / 3);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Starts the graphical application.
     * 
     * @param args not used.
     */
    public static void main(final String[] args) {
        new SimpleGUI().display();
    }

}
