package org.example;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageRepository {
    private final List<ImageItem> images = new ArrayList<>();

    public void addImage(ImageItem image) {
        images.add(image);
        System.out.println("Imagine adaugata: " + image.name());
    }

    public void displayImage(String name) throws IOException {
        for (ImageItem image : images) {
            if (image.name().equals(name)) {
                File file = new File(image.path());
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                } else {
                    System.out.println("Nu merge afisarea");
                }
                return;
            }
        }
        System.out.println("Imaginea nu a fost gasita: " + name);
    }
}
