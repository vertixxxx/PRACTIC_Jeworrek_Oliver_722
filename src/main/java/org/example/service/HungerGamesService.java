package org.example.service;

import org.example.model.*;
import org.example.repo.HungerGamesRepo;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class HungerGamesService {
    private HungerGamesRepo repository;
    private List<Tribut> tributes;
    private List<Ereignis> events;
    private List<SponsorGeschenk> gifts;

    public HungerGamesService(HungerGamesRepo repository) {
        this.repository = repository;
    }

    public void loadData(String tributesFile, String eventsFile, String giftsFile) throws IOException {
        this.tributes = repository.loadTributes(tributesFile);
        this.events = repository.loadEvents(eventsFile);
        this.gifts = repository.loadGifts(giftsFile);
    }

    public List<Tribut> getAllTributes() {
        return tributes;
    }

    public int getEventsCount() {
        return events.size();
    }

    public int getGiftsCount() {
        return gifts.size();
    }

    // 2
    public List<Tribut> filterTributes(int district, Status status) {
        return tributes.stream()
                .filter(t -> t.getDistrikt() == district && t.getStatus() == status)
                .collect(Collectors.toList());
    }

    //3
    public List<Tribut> getSortedTributes() {
        return tributes.stream()
                .sorted(Comparator.comparingInt(Tribut::getSkillLevel).reversed()
                        .thenComparing(Tribut::getName))
                .collect(Collectors.toList());
    }

    //4
    public void writeSortedTributes(String filename) throws IOException {
        List<Tribut> sorted = getSortedTributes();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Tribut tribut : sorted) {
                writer.write(tribut.toString());
                writer.newLine();
            }
        }
    }
}