package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingCanvas extends JPanel {
    private List<Point> dots;

    public DrawingCanvas() {
        this.dots = new ArrayList<>();
        setPreferredSize(new Dimension(400, 400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        drawDots(g2d);
    }

    private void drawDots(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        for (Point dot : dots) {
            g2d.fillOval(dot.x - 5, dot.y - 5, 10, 10);
        }
    }

    public void updateDots(List<Point> newDots) {
        this.dots = newDots;
        repaint();
    }

    public void clearDots() {
        dots.clear();
        repaint();
    }
}
