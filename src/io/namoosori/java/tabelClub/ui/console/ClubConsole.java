package io.namoosori.java.tabelClub.ui.console;

import io.namoosori.java.tabelClub.entity.TravelClub;
import io.namoosori.java.tabelClub.service.ClubService;
import io.namoosori.java.tabelClub.service.ServiceLogicLifeCycler;
import io.namoosori.java.tabelClub.util.ConsoleUtil;

import java.util.List;

public class ClubConsole {

    private ConsoleUtil consoleUtil;

    private ClubService clubService;

    public ClubConsole(){
        this.consoleUtil = new ConsoleUtil();
        // 이후 변경될 코드
        this.clubService =  ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }

    public void register(){
        //
        while(true){
            String clubName = consoleUtil.getValue("Club Name(0.Club Menu)");
            if(clubName.equals("0")){
                return;
            }

            String intro = consoleUtil.getValue("Club Intro(0.Club Menu)");
            if(intro.equals("0")){
                return;
            }
            TravelClub newClub = new TravelClub(clubName, intro);
            // 배열에 저장
            clubService.register(newClub);
            System.out.println("Register club : " + newClub.toString());
        }
    }

    public void findAll(){
        List<TravelClub> foundClubs = clubService.findAll();
        if(foundClubs.isEmpty()){
            System.out.println("Empty~");
            return;
        }
        for(TravelClub club :foundClubs){
            System.out.println(club.toString());
        }
    }

    public void findById(){
        TravelClub foundClub = null;

        while(true){
            String clubId = consoleUtil.getValue("Club id to find(0.Club Menu)");
            if(clubId.equals("0")){
                break;
            }

            foundClub = clubService.findById(clubId);
            if(foundClub != null){
                System.out.println(foundClub.toString());
            }else{
                System.out.println("Can not find club, ID: " + clubId);
            }
        }
    }

    public void findByName(){
        List<TravelClub> foundClubs = null;
        while(true) {
            String clubsName = consoleUtil.getValue("Club name to find(0.Club Menu)");
            if (clubsName.equals("0")) {
                break;
            }

        foundClubs = clubService.findByName(clubsName);
            if(foundClubs != null && foundClubs.isEmpty()) {
                for (TravelClub club : foundClubs) {
                    System.out.println(club);
                }
            }else {
                System.out.println("Can not find club, Name : " + clubsName);
            }
        }
    }

    private TravelClub findOne(){
        TravelClub foundClub = null;

        while(true){
            String clubId = consoleUtil.getValue("Club id to find(0.Club Menu)");
            if(clubId.equals("0")){
                break;
            }

            foundClub = clubService.findById(clubId);

            if(foundClub != null){
                break;
            }else{
                System.out.println("Can not find club, ID: " + clubId);
            }
        }
        return foundClub;
    }

    public void modify(){
        TravelClub targetClub = findOne();

        String newName = consoleUtil.getValue("new Club name(0. Menu, Enter. No Change)");
        if(newName.equals("0")){
            return;
        }
        if(!newName.isEmpty()){
            targetClub.setClubName(newName);
        }

        String newIntro = consoleUtil.getValue("new Club intro(0. Menu, Enter. No Change)");
        if(!newIntro.isEmpty()){
            targetClub.setIntro(newIntro);
        }

        clubService.modify(targetClub);

        System.out.println("Modify Club : " + targetClub.toString());
    }

    public void remove(){
        TravelClub targetClub = findOne();

        String confirmStr = consoleUtil.getValue("Remove this club?(Y:yes, N:no)");
        if(confirmStr.toLowerCase().equals("Y") || confirmStr.toLowerCase().equals("yes")){
            System.out.println("Remove a club --> " + targetClub.getClubName());
        }else{
            System.out.println("Remove cancelled, your club is safe." + targetClub.getClubName());
        }
    }
}