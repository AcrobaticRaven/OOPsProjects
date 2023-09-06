package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CoffeeMachine {
    public static void main(String[] args) {

        CoffeeMachineService coffeeMachineService = new CoffeeMachineService();

        boolean isRunnning = true;
        Scanner sc = new Scanner(System.in);

        while(isRunnning){
            System.out.println("Enter a command (buy/fill/take/show/exit/analytics) : ");
            String comd = sc.nextLine();

            if(comd.equals("buy")){
                System.out.println("Enter the coffee type (Espresso/Latte/Cappuccino) :");
                String coffeeType = sc.nextLine();
                coffeeMachineService.makePurchase(coffeeType);
            }else if(comd.equals("fill")){
                System.out.println("Enter the amount of water(ml) : ");
                int addedWater = Integer.parseInt(sc.nextLine());
                System.out.println("Enter the amount of milk(ml) ");
                int addedMilk = Integer.parseInt(sc.nextLine());
                System.out.println("Enter the amount of Coffee Beans : ");
                int addedBeans = Integer.parseInt(sc.nextLine());
                coffeeMachineService.fillIngredients(addedWater,addedMilk,addedBeans);
            }else if(comd.equals("take")){
                coffeeMachineService.takeMoney();
            }else if(comd.equals("show")){
                coffeeMachineService.showIngredients();
            }else if(comd.equals("exit")){
                isRunnning = false;
            }else if(comd.equals("analytics")){
                coffeeMachineService.analytics();
            }else{
                System.out.println("Invalid command, try again");
            }
        }
    }
}