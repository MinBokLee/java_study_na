package io.namoosori.java.tabelClub.ui.console;

import io.namoosori.java.tabelClub.service.ClubService;
import io.namoosori.java.tabelClub.service.ServiceLogicLifeCycler;
import io.namoosori.java.tabelClub.service.logic.ClubServiceLogic;

public class ClubSubConsole {
    private ClubService clubService;

    public ClubSubConsole(){
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }
}
