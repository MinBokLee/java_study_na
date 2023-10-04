package io.namoosori.java.tabelClub.service.logic;

import io.namoosori.java.tabelClub.entity.TravelClub;
import io.namoosori.java.tabelClub.service.ClubService;
import io.namoosori.java.tabelClub.store.ClubStore;
import io.namoosori.java.tabelClub.store.StoreLifeCycler;

import java.util.List;

public class ClubServiceLogic implements ClubService {

    private ClubStore clubStore;

    public ClubServiceLogic(){
        this.clubStore = StoreLifeCycler.getUniqueInstance().requestClubStore();
    }

    @Override
    public void register(TravelClub travelClub) {
        this.clubStore.create(travelClub);
    }

    @Override
    public List<TravelClub> findAll() {

        return this.clubStore.retrieveAll();
    }

    @Override
    public List<TravelClub> findByName(String clubName) {

        return this.clubStore.retrieveAllByName(clubName);
    }

    @Override
    public TravelClub findById(String clubId) {

        return this.clubStore.retrieve(clubId);
    }

    @Override
    public void modify(TravelClub modifyClub) {

        this.clubStore.update(modifyClub);
    }

    @Override
    public void remove(String clubId) {
        this.clubStore.delete(clubId);
    }
}
