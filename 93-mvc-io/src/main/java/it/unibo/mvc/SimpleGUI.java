package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();

    /**
     * Creates a simple GUI which has: a text area, a text field and two buttons.<br>
     * In addiction, there are two panels:
     * the {@code secondPanel} contains the buttons and the {@code mainPanel} the oder elements.<br>
     * If {@code print} is pressed,
     * the controller is asked to show the string contained in the text field on standard output.<br>
     * If {@code showHistory} is pressed instead,
     * the GUI must show all the prints that have been done to this moment in the text area.
     */
    public SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        final JPanel secondPanel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JTextField textField = new JTextField();
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        final Controller controller = new SimpleController();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea.setEditable(false);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.LINE_AXIS));
        secondPanel.add(print);
        secondPanel.add(showHistory);
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextStringToPrint(textField.getText());
                controller.printCurrentString();
            }
        });
        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText(controller.getPrintedStrings().toString());
            }
        });
        mainPanel.add(secondPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
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
