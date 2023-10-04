import io.namoosori.java.tabelClub.entity.TravelClub;
import io.namoosori.java.tabelClub.ui.menu.ClubMenu;

public class StoryAssistant {

    private void startStory(){
        ClubMenu clubMenu = new ClubMenu();
        clubMenu.show();


    }

    public static void main(String[] args){
        StoryAssistant assistant = new StoryAssistant();
        assistant.startStory();
    }
}
