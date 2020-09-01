/** *****************************************************************************
 * Customer.java
 * Max Beard
 *
 * simulates a customer at the carnival
 ***************************************************************************** */
package carnival;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer 
{
    Scanner stdIn = new Scanner(System.in);
    String name;
    int tickets;
    ArrayList<String> prizes;
    String[] foods;

    public Customer(String name) 
    {
        this.name = name;
        tickets = 20;
        prizes = new ArrayList<>();
        foods = new String[2];
    } // end Customer constructor

    public void addTickets()
    {
        tickets += 20;
    } // end addTickets

    public void subtractTickets(int cost) 
    {
        tickets -= cost;
    } // end subtractTickets

    public void addPrize(String i)
    {
        if (!i.contains("sorry")) {
            prizes.add(i);
        }
    } // end addPrize

    public void displayPrizes()
    {
        if (!prizes.isEmpty()) {
            System.out.println("You won these prizes:");
            for (String i : prizes) {
                System.out.println(i);
            }
        }
    } // end displayPrizes

    public int getTickets() 
    {
        return tickets;
    } // end getTickets

    public void grabFood(Food food) 
    {
        if (foods[0] == null) {
            foods[0] = food.getFoodName();
            System.out.printf("Enjoy your %s\n", foods[0]);
            tickets -= food.getFoodCost();
        } else if (foods[1] == null) {
            foods[1] = food.getFoodName();
            System.out.printf("Enjoy your %s\n", foods[1]);
            tickets -= food.getFoodCost();
        } else {
            System.out.println("You don't have enough hands!");
        }
    } // end grabFood

    public void eatFood()
    {
        int eat;
        if(foods[0] == null && foods[1] == null){
            System.out.println("You don't have any food to consume");
        } else {
            if (foods[0] == null) {
                System.out.printf("2. %s\n", foods[1]);
            } else if (foods[1] == null) {
                System.out.printf("1. %s\n", foods[0]);
            } else {
                System.out.printf("1. %s\t2. %s\n", foods[0], foods[1]);
            }
            System.out.print("Which do you want to consume? ");
            eat = stdIn.nextInt();
            System.out.printf("Yummm! That %s was good!\n", foods[eat - 1]);
            foods[eat - 1] = null;
        }
    } // end eatFood
} // end Customer
