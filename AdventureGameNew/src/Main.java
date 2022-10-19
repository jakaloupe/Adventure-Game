

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Random rand = new Random();

    // Obtain a number between [0 - 49].
    static int rng = rand.nextInt(2)+1;
    static int magicBall = 0;
    static int greenPill = 0;
    static int spellState = 0;
    static int drownState = 0;
    static boolean fell = false;

    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        startMenu();
    }
    public static void startMenu() {
        System.out.println("Welcome to the adventure game, press 1 to Start, 2 to review Instructions, 3 to exit");
        int input1 = userInput.nextInt();
        switch (input1) {
            case 1:
                // runs game method
                gameStart();
                break;
            case 2:
                //instructions();
        }
    }

    public static void gameStart() {
        //dialogue
        System.out.println("You wake up, you feel like you've been asleep for centuries. You look around and notice your surroundings arent as familiar as you thought.");
        System.out.println("You look out the window to a clear blue sky and notice that you are in a castle. You feel nauseous");
        inBedroom();
        //boolean inorder to determine if user has left room

    }
    public static void inBedroom(){
        boolean inRoom = true;
        while (inRoom) {
            // gives user the options to leave room, explore room or to use the washroom
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("You are in the bedroom");
            System.out.println("What would you like to do? Press 1 to leave your room, 2 to explore the room, 3 to use the washroom");
            int rInput = userInput.nextInt();
            if (rInput == 1) {
                inRoom = false;
                hallway();
            }
            //if user chooses "2"
            if (rInput == 2) {
                exploreRoom();
            }

            if (rInput == 3) {
                //lore: someone has put a spell on user. spellState increases as time passes
                exploreWash();
            }
        }
    }

    public static void hallway() {
        boolean inHall = true;
        System.out.println("You are in the hallway, paintings are hanged across the hallway");
        System.out.println("While walking down the hallway you see a tilted painting, would you like to fix it? 1 to fix it, 2 to leave it");
        int hChoice = userInput.nextInt();
        if (hChoice == 1 && rng == 1){
            fell = true;
            dead();
            inHall = false;
        }
        else if (hChoice == 1 && rng == 2){
            System.out.println("You fixed the painting ");
        }
        while (inHall){
            System.out.println("You are in the hallway and you come between a split in the hallway, which way would you like to go? 1 for Left or 2 for Right");
            int hallChoice = userInput.nextInt();
            switch (hallChoice){
                case 1:
                    leftHall();
                    inHall = false;
                    break;

                case 2:
                    rightHall();
                    inHall = false;
                    break;

                default:
                    break;
            }
        }
    }

    public static void leftHall(){

        System.out.println("left hall");
    }

    public static void rightHall(){

        System.out.println("right hall");
    }

    public static void exploreRoom() {
        System.out.println("While exploring the room you see a bedside table with a drawer, Press 1 to open drawer or 2 to leave it");
        int rChoice = userInput.nextInt();
        // if user has chosen to open drawer without a 8ball then method runs
        if (rChoice == 1 && magicBall != 1) {
            System.out.println("While exploring the room, you find a magic 8 ball! Press 1 to pick it up or 2 to leave it");
            int itemChoice = userInput.nextInt();
            // if user chooses to pick up item, method runs otherwise it runs the while loop
            if (itemChoice == 1 && magicBall == 0) {
                magicBall = 1;
                System.out.println("You gained 1 Magic 8 Ball!");
            }
        }
        else if (rChoice == 1 && magicBall == 1){
            System.out.println("The drawer is empty");
        }
    }

    public static void exploreWash() {
        boolean inWash = true;
        while (inWash) {
            System.out.println("---------------------------------------------------------------------------------------------------");
            System.out.println("What would you like to do? 1 to relieve yourself, 2 to wash your face, 3 to open mirror cabinet, or 4 to leave.");
            int wChoice = userInput.nextInt();
            if (wChoice == 1) {
                System.out.println("You relieved yourself, you feel refreshed");
            }
            else if (wChoice == 2){
                System.out.println("Wow! you washed your face. you are refreshed");
                drownState++;
            }
            else if (wChoice == 3){
                System.out.println("You have opened the mirror cabinet");
                openCab();
            }
            else if (wChoice == 4){
                inWash = false;
                spell();
            }
            if (drownState == 5){
                dead();
            }
            if (spellState == 10){
                dead();
            }
        }
    }
    public static void openCab(){
        if (greenPill != 1){
            System.out.println("You have found a green pill! Press 1 to pick it up or 2 to leave it.");
            int itemChoice2 = userInput.nextInt();
            if (itemChoice2 == 1) {
                greenPill = 1;
                System.out.println("You gained 1 Green Pill");
            }
        }
        else if (greenPill == 1){
            System.out.println("The cabinet is empty.");
        }
    }


    // Spell
    public static void spell(){
        spellState += 1;
        if (spellState == 1){
            System.out.println("Your head spins and you are starting to feel nauseous");
        }
        else if (spellState == 2){
            System.out.println("Your feet become heavier, you are starting to become confused, your head spins faster");
        }
    }
    public static void dead(){
        System.out.println("You died");
        if (drownState == 5){
            System.out.println("You drowned by washing your face too many times, your small nose sucked it all up. :(");
        }
        if (spellState == 10){
            System.out.println("The spell engulfed your soul, use Green Pills to reduce the spell, allowing you to live longer.");
        }
        if (fell){
            System.out.println("The floorboard below you opened, revealing metal spikes which impaled you");
        }
        drownState = 0;
        magicBall = 0;
        greenPill = 0;
        spellState = 0;
        startMenu();
    }
}

