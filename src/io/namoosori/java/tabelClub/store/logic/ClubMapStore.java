package io.namoosori.java.tabelClub.store.logic;

import io.namoosori.java.tabelClub.entity.TravelClub;
import io.namoosori.java.tabelClub.store.ClubStore;

import java.util.List;

public class ClubMapStore implements ClubStore {
    @Override
    public void create(TravelClub travelClub) {

    }

    @Override
    public TravelClub retrieve(String clubId) {
        return null;
    }

    @Override
    public List<TravelClub> retrieveAllByName(String clubName) {
        return null;
    }

    @Override
    public List<TravelClub> retrieveAll() {
        return null;
    }

    @Override
    public void update(TravelClub updateClub) {

    }

    @Override
    public void delete(String clubId) {

    }
}
