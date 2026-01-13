package org.example.controller;

import org.example.model.Ereignis;
import org.example.model.Status;
import org.example.model.Tribut;
import org.example.service.HungerGamesService;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class HungerGamesController {
    private HungerGamesService service;

    public HungerGamesController(HungerGamesService service) {
        this.service = service;
    }

    public void run() {

        try {
            //1
            service.loadData("C:\\Users\\hsvdg\\OneDrive\\Documents\\VSCode_Projects\\PRACTIC_Jeworrek_Oliver_722\\src\\main\\java\\org\\example\\tributes.json", "C:\\Users\\hsvdg\\OneDrive\\Documents\\VSCode_Projects\\PRACTIC_Jeworrek_Oliver_722\\src\\main\\java\\org\\example\\events.json", "C:\\Users\\hsvdg\\OneDrive\\Documents\\VSCode_Projects\\PRACTIC_Jeworrek_Oliver_722\\src\\main\\java\\org\\example\\gifts.json");

            System.out.println("Tributes  " + service.getAllTributes().size());
            System.out.println("Events  " + service.getEventsCount());
            System.out.println("Gifts  " + service.getGiftsCount());

            for (Tribut t : service.getAllTributes()) {
                System.out.println(t);
            }

            // 2
            handleDistrictFilter();
        } catch (IOException e) {}

    }
    private void handleDistrictFilter() {
        System.out.print("Input district: ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int distrikt = scanner.nextInt();
            List<Tribut> filtered = service.filterTributes(distrikt, Status.LEBENDIG);
            filtered.forEach(System.out::println);
        } else {
            System.out.println("Invalid input");
        }
    }
}