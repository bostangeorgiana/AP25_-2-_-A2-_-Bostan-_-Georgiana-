package org.example;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        ImageRepository repository = new ImageRepository();

        ImageItem image1 = new ImageItem("Pisica", LocalDate.now(), List.of("animal", "dragut"), "F:/PA~~~#/Lab5/C5/Imagini/pisica.jpg");
        ImageItem image2 = new ImageItem("Peisaj", LocalDate.now(), List.of("munte", "apus"), "F:/PA~~~#/Lab5/C5/Imagini/peisaj.jpg");

        repository.addImage(image1);
        repository.addImage(image2);


        System.out.println("Deschid imaginea 'Pisica'...");
        repository.displayImage("Pisica");

        System.out.println("Deschid imaginea 'Luna'...");
        repository.displayImage("Luna");
    }
}
