package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String FRAME_TITLE = "My second Java graphical interface";
    private static final String MSG_WRITING = "Writing has failed";
    private static final String ERROR_TITLE = "Error";
    private static final String MSG = "An error has occured";

    private final JFrame frame = new JFrame(FRAME_TITLE);

    /**
     * Creates a simple GUI with a file chooser.<br>
     * This class has the same contents of {@code SimpleGUI} but, in addiction, 
     * has a text field which display the path where to save the text wrote and a button 
     * which browse the file system.
     */
    private SimpleGUIWithFileChooser() {
        final JPanel mainPanel = new JPanel();
        final JTextArea textArea = new JTextArea("Write here");
        final Controller controller = new Controller();
        final JButton save = new JButton("Save");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(save, BorderLayout.SOUTH);
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

        final JPanel secondPanel = new JPanel();
        final JTextField textField = new JTextField(controller.getPath());
        final JButton browse = new JButton("Browse...");

        mainPanel.add(secondPanel, BorderLayout.NORTH);
        secondPanel.setLayout(new BorderLayout());
        secondPanel.add(textField, BorderLayout.CENTER);
        secondPanel.add(browse, BorderLayout.LINE_END);
        textField.setEditable(false);
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int result = fileChooser.showSaveDialog(frame);

                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile());
                    textField.setText(fileChooser.getSelectedFile().getPath());
                } else if (result != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, MSG);
                }
            }
        });
        frame.setContentPane(mainPanel);
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
        new SimpleGUIWithFileChooser().display();
    }

}
