package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConfigPanel extends JPanel {
    private final DrawingCanvas canvas;
    private JLabel label;
    private JSpinner spinner;
    private JButton generateButton;
    private List<Point> dots;

    public ConfigPanel(DrawingCanvas canvas) {
        this.canvas = canvas;
        this.dots = new ArrayList<>();
        setupUI();
    }

    private void setupUI() {
        label = new JLabel("Enter number of dots:");
        spinner = new JSpinner(new SpinnerNumberModel(10, 2, 50, 1));
        generateButton = new JButton("Generate");

        generateButton.addActionListener(this::onGenerateButtonClick);

        setLayout(new FlowLayout()); // FlowLayout -> aranjarea componentelor
        add(label);
        add(spinner);
        add(generateButton);
    }

    private void onGenerateButtonClick(ActionEvent e) {
        int numberOfDots = (int) spinner.getValue();
        generateRandomDots(numberOfDots);
        canvas.updateDots(dots);
    }

    private void generateRandomDots(int numberOfDots) {
        dots.clear();
        Random rand = new Random();

        for (int i = 0; i < numberOfDots; i++) {
            int x = rand.nextInt(380) + 10;  // Ensures dots are not near edges
            int y = rand.nextInt(380) + 10;
            dots.add(new Point(x, y));
        }
    }
}
