package io.namoosori.java.tabelClub.ui.menu;

import io.namoosori.java.tabelClub.ui.console.ClubConsole;

import java.util.Scanner;

public class ClubMenu {

    private Scanner scanner;
    private ClubConsole clubConsole;

    public ClubMenu(){
        this.scanner = new Scanner(System.in);
        this.clubConsole = new ClubConsole();
    }

    public void show(){
        int inputNumber = 0;

        while(true){
            displayMenu();
            inputNumber = selectMenu();
            switch (inputNumber){
                case 1:
                    clubConsole.register();
                    break;
                case 2:
                    clubConsole.findAll();
                    break;
                case 3:
                    clubConsole.findById();
                case 4:
                    clubConsole.findByName();
                    break;
                case 5:
                    clubConsole.modify();
                    break;
                case 6:
                    clubConsole.remove();
                    break;
                case 0:
                    //
                    return;
                default:
                    System.out.println("chose again");
            }
        }
    }

    private void displayMenu(){
        System.out.println("----------------------------------");
        System.out.println("Club Menu");
        System.out.println("----------------------------------");
        System.out.println("1. Register");
        System.out.println("2. find(All)");
        System.out.println("3. find(ID)");
        System.out.println("4. find(Name)");
        System.out.println("5. modify");
        System.out.println("6. Remove");
        System.out.println("----------------------------------");
        System.out.println("0. Previous");
        System.out.println("----------------------------------");
    }

    private int selectMenu(){
        System.out.print("Select : ");
        int menuNumber = scanner.nextInt();
        if(menuNumber >= 0 && menuNumber <= 6){
            scanner.nextLine();
            return menuNumber;
        }else{
            System.out.println("it's a invalid number -->" + menuNumber);
            return -1;
        }

    }
}
