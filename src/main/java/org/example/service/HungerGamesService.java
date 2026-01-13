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
}