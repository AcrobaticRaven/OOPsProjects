package org.example;

public class CoffeeMachineService {
    int moneyEarned;
    int water;
    int coffeeBeans;
    int milk;
    int espressoWater = 250;
    int espressoMilk = 0;
    int espressoBeans = 16;
    int latteWater = 350;
    int latteMilk = 75;
    int latteBeans = 20;
    int cappuccinoWater = 200;
    int cappuccinoMilk = 100;
    int cappuccinoBeans = 12;
    int espressoPrice = 4;
    int lattePrice = 7;
    int cappuccinoPrice = 6;
    int espressoCount;
    int latteCount;
    int cappuccinoCount;

    public CoffeeMachineService(){
        this.water = 0;
        this.milk = 0;
        this.coffeeBeans = 0;
        this.espressoCount = 0;
        this.latteCount = 0;
        this.cappuccinoCount = 0;
        this.moneyEarned = 0;

    }

    public void makePurchase(String st){
        if(st.equals("Espresso") && canMakePurchase(espressoWater,0,espressoBeans)){
            water -= espressoWater;
            coffeeBeans -= espressoBeans;
            moneyEarned+= espressoPrice;
            espressoCount++;
            System.out.println("Enjoy your Espresso");
        }else if(st.equals("Latte") && canMakePurchase(latteWater,latteMilk,latteBeans)){
            water -= latteWater;
            milk -= latteMilk;
            coffeeBeans -= latteBeans;
            moneyEarned += lattePrice;
            latteCount++;
            System.out.println("Enjoy your Latte");
        }else if(st.equals("Cappuccino") && canMakePurchase(cappuccinoWater,cappuccinoMilk,cappuccinoBeans)){
            water -= cappuccinoWater;
            milk -= cappuccinoMilk;
            coffeeBeans -= cappuccinoBeans;
            moneyEarned += cappuccinoPrice;
            cappuccinoCount++;
            System.out.println("Enjoy your Cappuccino");
        }else{
            System.out.println("Sorry not enough ingredients for your choice");
        }
    }
    public boolean canMakePurchase(int reqWater, int reqMilk, int reqBeans){
        return (water>=reqWater && milk >=reqMilk && coffeeBeans>=reqBeans);
    }

    public void fillIngredients(int addedWater, int addedMilk, int addedBeans){
        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedBeans;
    }
    public void takeMoney(){
        System.out.println("You took Rs " + moneyEarned + " from the box");
        moneyEarned = 0;
    }
    public void showIngredients(){
        System.out.println(" water : " + water);
        System.out.println(" milk : " + milk);
        System.out.println(" CoffeeBeans : " + coffeeBeans);
    }
    public void analytics(){
        System.out.println("LatteCount : " + latteCount);
        System.out.println("EspressoCount : " + espressoCount);
        System.out.println("CappuccinoCount : " + cappuccinoCount);
        System.out.println("Ingredients used : ");
        System.out.println("Water : " +(espressoCount*espressoWater + latteCount*latteWater + cappuccinoCount*cappuccinoWater) + " ml");
        System.out.println("Milk : " + (latteCount*latteMilk + cappuccinoMilk*cappuccinoCount) + " ml");
        System.out.println("CoffeeBeans : " + (cappuccinoCount*cappuccinoBeans + latteCount*latteBeans + espressoCount*espressoBeans) + " ml");
    }

}
