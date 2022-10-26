package AdventureGameNew.src;

import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class AdventureGame {

        Person person = new Person();
        int magicBall = 0;
        int greenPill = 0;
        boolean fell = false;
        boolean inRoom = true;
        Scanner userInput = new Scanner(System.in);

        public AdventureGame() {
            startMenu();
        }
        public void startMenu() {
            System.out.println("Welcome to the adventure game");
            System.out.println("1: Start Game");
            System.out.println("2: Instructions");
            System.out.println("3: Exit Program");
            int input1 = userInput.nextInt();
            switch (input1) {
                case 1:
                    // runs game method
                    gameStart();
                    break;
                case 2:
                    instructions();
                    break;
                case 3:
                    System.exit(0);
            }
        }

        public void gameStart() {
            //lore
            System.out.println("You wake up, you feel like you've been asleep for centuries. You look around and notice your surroundings arent as familiar as you thought.");
            System.out.println("You look out the window to a clear blue sky and notice that you are in a castle. You feel nauseous");
            inBedroom();
        }
        public void inBedroom(){
            //boolean inorder to determine if user has left room
            while (inRoom) {
                // gives user the options to leave room, explore room or to use the washroom
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("You are in the bedroom");
                System.out.println("What would you like to do?");
                System.out.println("1: Leave room");
                System.out.println("2: Explore room");
                System.out.println("3: Use Washroom");
                System.out.println("4: Inventory");
                try{
                    userInput.nextLine();
                    int rInput = userInput.nextInt();
                    switch (rInput){
                        case 1:
                            inRoom = false;
                            hallway();
                            break;

                        case 2:
                            exploreRoom();
                            break;

                        case 3:
                            exploreWash();
                            break;

                        case 4:
                            inventory();
                    }
                }
                catch (InputMismatchException exception){
                    System.out.println("Invalid Input!");
                }
            }
        }

        public void hallway() {
            boolean inHall = true;
            System.out.println("You are in the hallway, paintings are hanged across the hallway");
            System.out.println("While walking down the hallway you notice a slightly tilted painting, it kind of bothers you, but it isn't a big deal");
            System.out.println("1: Fix the painting for satisfaction");
            System.out.println("2: Leave it");
            int hChoice = userInput.nextInt();
            if (hChoice == 1 && rng() == 1){
                fell = true;
                dead();
                inHall = false;
            }
            else if (hChoice == 1 && rng() == 2){
                System.out.println("You fixed the painting ");
            }
            while (inHall){

                try {
                    System.out.println("You are in the hallway and you come between a split in the hallway, which way would you like to go?");
                    System.out.println("1: Left");
                    System.out.println("2: Right");
                    userInput.nextLine();
                    int hallChoice = userInput.nextInt();
                    switch (hallChoice) {
                        case 1 -> {
                            leftHall();
                            inHall = false;
                        }
                        case 2 -> {
                            rightHall();
                            inHall = false;
                        }
                        default -> {
                        }
                    }
                }
                catch (InputMismatchException exception){
                    System.out.println("Invalid input!");
                }
            }
        }

        public void leftHall(){

            System.out.println("left hall");
        }

        public void rightHall(){

            System.out.println("right hall");
        }

        public void exploreRoom() {
            System.out.println("While exploring the room you see a bedside table with a drawer");
            System.out.println("1: Open Drawer");
            System.out.println("2: Leave it");
            int rChoice = userInput.nextInt();
            // if user has chosen to open drawer without a 8ball then method runs
            if (rChoice == 1 && magicBall != 1) {
                System.out.println("While exploring the room, you find a magic 8 ball!");
                System.out.println("1: Pick it up");
                System.out.println("2: Leave it");
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

        public void exploreWash() {
            boolean inWash = true;
            while (inWash) {
                System.out.println("---------------------------------------------------------------------------------------------------");
                System.out.println("What would you like to do? ");
                System.out.println("1: Relieve yourself");
                System.out.println("2: Wash your face");
                System.out.println("3: Open mirror cabinet");
                System.out.println("4: Leave");

                try {
                    int wChoice = userInput.nextInt();
                    switch (wChoice) {
                        case 1:
                            System.out.println("You relieved yourself, you feel refreshed");
                            break;
                        case 2:
                            System.out.println("Wow! you washed your face. you are refreshed");
                            person.setDrownState(person.getDrownState()+1);
                            break;

                        case 3:
                            System.out.println("You have opened the mirror cabinet");
                            openCab();
                            break;

                        case 4:
                            inWash = false;
                            spell();
                    }
                }
                catch (InputMismatchException exception){
                    System.out.println("Invalid Input!");
                }
                if (person.getDrownState() >= 5){
                    dead();
                    inWash = false;
                    inRoom = false;
                }
            }
        }
        public void openCab(){
            if (greenPill != 1){
                System.out.println("You have found a green pill! Press 1 to pick it up or 2 to leave it.");
                System.out.println("1: Pick it up");
                System.out.println("2: Leave it");
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

        public void inventory(){
            System.out.println("<strong>Inventory</strong>");
        }

        public double rng(){
            Random rand = new Random();
            // Obtains a number between [0 - 50].
            int rng = rand.nextInt(2)+1;
            return rng;
        }

        // Spell
        public void spell(){
            person.setSpellState(person.getSpellState()+1);
            if (person.getSpellState() == 1){
                System.out.println("Your head spins and you are starting to feel nauseous");
            }
            else if (person.getSpellState() == 2){
                System.out.println("Your feet become heavier, you are starting to become confused, your head spins faster");
            }
            else if (person.getSpellState() == 3){
                System.out.println("Your eyes feel heavy, almost sleepy like.");
            }
            else if (person.getSpellState() == 4){
                System.out.println("You feel slow, you feel like you can barely move, but you keep pushing on.");
            }
            else if (person.getSpellState() == 5){
                dead();
            }
        }
        public void dead(){
            System.out.println("You died");
            if (person.getDrownState() == 5){
                System.out.println("You drowned by washing your face too many times, your small nose sucked it all up. :(");
            }
            if (person.getSpellState() == 5){
                System.out.println("The spell engulfed your soul, use Green Pills to reduce the spell, allowing you to live longer.");
            }
            if (fell){
                System.out.println("The floorboard below you opened, revealing metal spikes which impaled you");
            }
            person.setDrownState(0);
            magicBall = 0;
            greenPill = 0;
            person.setSpellState(0);
            startMenu();
        }

        public void instructions(){
            System.out.println("Idk");
        }
    }

