package io.namoosori.java.tabelClub.entity;

import io.namoosori.java.tabelClub.util.DateUtil;

import java.util.UUID;

public class TravelClub {

    //Fields
    private final int MINIMUM_NAME_LENGTH = 3;
    private final int MINIMUM_INTRO_LENGTH = 10;

    private String id;
    private String clubName;
    private String intro;
    private String foundationDay;

    private TravelClub(){
        this.id = UUID.randomUUID().toString();
    }

    public TravelClub(String clubName, String intro){
        this();
        setClubName(clubName);
        setIntro(intro);
        this.foundationDay = DateUtil.today();
    }

    //Methods
    //setter
    public void setClubName(String clubName) {
        if(clubName.length() < MINIMUM_NAME_LENGTH){
            System.out.println("Club name should be longer then " + MINIMUM_NAME_LENGTH);
            return;
        }
        this.clubName = clubName;
    }

    public String getClubName(){
        return  this.clubName;
    }

    public void setIntro(String intro) {
        if (intro.length() < MINIMUM_INTRO_LENGTH) {
            System.out.println("Club name should be longer then " + MINIMUM_INTRO_LENGTH);
            return;
        }
        this.intro = intro;
    }

    public String getIntro(){
        return  this.intro;
    }

    public String getId(){
        return this.id;
    }

    public String getFoundationDay(){
        return this.foundationDay;
    }

    public static TravelClub getSample(){
        String clubName = "Sample Club";
        String intro = "Sample club intro~~";
        TravelClub sampleClub = new TravelClub(clubName, intro);
        return sampleClub;

//        return new TravelClub("Sample Club","Sample club intro~~");
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Travel club ID : ").append(id);
        builder.append("ClubName : ").append(clubName);
        builder.append("Intro : ").append(intro);
        builder.append("FoundationDay : ").append(foundationDay);

        return builder.toString();
    }
}
