package com.company;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        List<String> names = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            names.add("name" + i);
        }

        Scanner sc = null;
        try (FileWriter fileWriter = new FileWriter("Imena.txt");
             BufferedWriter bw = new BufferedWriter(fileWriter)) {
            for (String line : names) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            FileReader fileReader = new FileReader("Imena.txt");
            sc = new Scanner(fileReader);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("IO ERROR!" + "\n" + e.getMessage());
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }

}
