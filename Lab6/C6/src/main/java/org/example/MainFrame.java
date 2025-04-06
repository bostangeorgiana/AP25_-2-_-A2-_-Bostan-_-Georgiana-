package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private DrawingCanvas drawingCanvas;

    public MainFrame() {
        super("Dot Game");
        initialize();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // pt centrare
        setSize(800, 600);
        setLayout(new BorderLayout()); // organizam panouri

        drawingCanvas = new DrawingCanvas();
        configPanel = new ConfigPanel(drawingCanvas);
        controlPanel = new ControlPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(drawingCanvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
