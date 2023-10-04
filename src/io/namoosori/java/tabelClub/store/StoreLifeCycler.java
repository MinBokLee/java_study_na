package io.namoosori.java.tabelClub.store;

import io.namoosori.java.tabelClub.store.logic.ClubMapStore;

public class StoreLifeCycler {

    private static StoreLifeCycler uniqueInstance;

    private ClubStore clubStore;

    private StoreLifeCycler(){
        this.clubStore = new ClubMapStore();
    }

    public static StoreLifeCycler getUniqueInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new StoreLifeCycler();
        }
        return  uniqueInstance;
    }

    public ClubStore requestClubStore(){
        return this.clubStore;
    }
}
