package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class SearchEngine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        logAction("launch");
        boolean running = true;

        while (running) {
            System.out.print("Enter a search term (X or x to exit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("x")) {
                running = false;
            } else {
                logAction("search : " + input);
            }
        }
        logAction("exit");
        scanner.close();
    }


    public static void logAction(String action) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formattedDate = today.format(format1);

        try (FileWriter writer = new FileWriter("logs.txt", true)) {
            writer.write(formattedDate + " " + action + "\n" );
        } catch (Exception e) {
            System.out.println("Can't read this file!");

        }
    }
}
