package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    private JButton exitButton;
    private JButton saveButton;
    private JButton loadButton;
    private JButton clearButton;

    public ControlPanel(MainFrame frame) {
        exitButton = new JButton("Exit");
        saveButton = new JButton("Save");
        loadButton = new JButton("Load");
        clearButton = new JButton("Export");

        setLayout(new GridLayout(1, 4, 10, 10));
        add(saveButton);
        add(loadButton);
        add(clearButton);
        add(exitButton);

        exitButton.addActionListener(e -> System.exit(0));
        clearButton.addActionListener(this::onClearButtonClick);
    }

    private void onClearButtonClick(ActionEvent e) {

    }
}
