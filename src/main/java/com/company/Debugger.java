package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Marshall on 04/10/2015.
 *
 * This class controls the debug window that prints out system level events
 */
public class Debugger {

    private static final JFrame FRAME = new JFrame("Debugger");
    private static final Dimension WINDOW_SIZE = new Dimension (450, 450);
    private static final JTextArea TEXT_AREA = new JTextArea(5, 30);
    private final static String NEW_LINE = "\n";


    public Debugger() {
        // Set close operation
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create text area
        TEXT_AREA.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(TEXT_AREA);
        scrollPane.setPreferredSize(WINDOW_SIZE);
        FRAME.add(scrollPane,BorderLayout.CENTER);

        // Pack frame
        FRAME.pack();
        FRAME.setLocationRelativeTo(null);
    }

    // Displays the debugger window
    public void spawn() {
        FRAME.setVisible(true);
    }

    // Prints a string to the debugger window
    public void print(String string) {
        TEXT_AREA.append(string + NEW_LINE);
    }
}
