/** *****************************************************************************
 * Final Project: Carnival
 * Max Beard
 *
 * This simulates a journey through a carnival
 ***************************************************************************** */
package carnival;

import java.util.*;

public class Carnival
{
    public static void main(String[] args) 
    {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Final Project by Max Beard\n");

        String name;                    // name of customer
        Customer customer;              // initializing the customer
        int option;                     // option the user inputs
        Food[] foods;
        String[] options = {"Water Shooter", "Balloon Dart Toss", "Ring Toss",
            "Add Tickets", "Ferris Wheel", "Carousel", "Get Food", "Eat Food",
            "Exit Carnival"
        };

        Game waterShooter = new Game("Water Shooter", 4, new String[]{"Stuffed Bear", "Plastic Bear", "Bear keychain"});
        Game balloonDartToss = new Game("Balloon Dart Toss", 4, new String[]{"Stuffed Tiger", "Plastic Tiger", "Tiger keychain"});
        Game ringToss = new Game("Ring Toss", 4, new String[]{"Stuffed Pig", "Plastic Pig", "Pig keychain"});

        Ride ferrisWheel = new Ride("Ferris Wheel", 6);
        Ride carousel = new Ride("Carousel", 6);

        Food hotDog = new Food("Hot Dog", 5);
        Food popcorn = new Food("Popcorn", 5);
        Food cottonCandy = new Food("Cotton Candy", 5);
        Food drink = new Food("Drink", 3);
        foods = new Food[]{hotDog, popcorn, cottonCandy, drink};

        // asking user for name
        System.out.println("Welcome to the Carnival!");
        System.out.print("What is you name? ");
        name = stdIn.nextLine();
        customer = new Customer(name);

        // bringing customer through carnival
        do {
            System.out.printf("\nYou have %d tickets\n", customer.getTickets());
            for (int i = 1; i <= options.length; i += 2) {
                if (i + 1 == 10) {
                    System.out.printf("%d. %s\n", i, options[i - 1]);
                } else {
                    if (i == 1) {
                        System.out.printf("%d. %s\t%d. %s\n", i, options[i - 1], i + 1, options[i]);
                    } else {
                        System.out.printf("%d. %s\t\t%d. %s\n", i, options[i - 1], i + 1, options[i]);
                    }
                }
            }
            System.out.print("What do you want to do? ");
            option = stdIn.nextInt();
            switch (option) {
                case 1:
                    customer.addPrize(waterShooter.playGame());
                    customer.subtractTickets(waterShooter.getGameCost());
                    break;
                case 2:
                    customer.addPrize(balloonDartToss.playGame());
                    customer.subtractTickets(balloonDartToss.getGameCost());
                    break;
                case 3:
                    customer.addPrize(ringToss.playGame());
                    customer.subtractTickets(ringToss.getGameCost());
                    break;
                case 4:
                    System.out.println("Adding 20 tickets");
                    customer.addTickets();
                    break;
                case 5:
                    Carnival.rideRide(ferrisWheel);
                    customer.subtractTickets(ferrisWheel.getRideCost());
                    break;
                case 6:
                    Carnival.rideRide(carousel);
                    customer.subtractTickets(carousel.getRideCost());
                    break;
                case 7:
                    Food food = Carnival.displayFood(foods);
                    customer.grabFood(food);
                    break;
                case 8:
                    customer.eatFood();
                    break;
                case 9:
                    break;
                default:
                    Carnival.validOption();
                    break;
            }
        } while (option != 9);

        // ending carnival journey and displaying prizes if customer has any
        System.out.printf("\nAll Done! Hope you had a great time, %s\n", name);
        customer.displayPrizes();
    } // end main

    public static void rideRide(Ride ride) 
    {
        System.out.printf("Enjoy the %s ride!\n", ride.getRideName());
    } // end rideRide

    public static Food displayFood(Food[] foods)
    {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("Food Choices");
        for (int i = 1; i <= foods.length; i += 2) {
            System.out.printf("%d. %s\t%d. %s\n", i, foods[i - 1].getFoodName(), i + 1, foods[i].getFoodName());
        }
        System.out.print("Which one do you want? ");
        return foods[stdIn.nextInt() - 1];
    } // end displayFood

    public static void validOption() 
    {
        System.out.println("Please enter valid option");
    } // end validOption
} // end Carnival
