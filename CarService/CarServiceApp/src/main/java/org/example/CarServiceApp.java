package org.example;

import java.util.ArrayList;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class CarServiceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the car type (HATCHBACK/SEDAN/SUV) : ");
        CarType carType = CarType.valueOf(sc.nextLine().toUpperCase());
        CarService carService = new CarService(carType);

        System.out.print("Enter the service codes : ");
        String input = sc.nextLine();
        ArrayList<ServiceCode>requestedServices = new ArrayList<>();
        for(String code : input.split(" ")){
            try {
                requestedServices.add(ServiceCode.valueOf(code.toUpperCase()));
            }catch(IllegalArgumentException e){
                System.out.println("Invalid service code :" + code);
            }
        }

        int totalBill = carService.calculateBill(requestedServices);
        System.out.println("Your Bill : " + totalBill);
        System.out.println("Car Type : " + carType);
        for(ServiceCode code : requestedServices){
            int price = carService.servicePrice(code);
            System.out.println("Service code : " + code + " costs : " + price);
        }if(totalBill>10000) System.out.println("Complimentary cleaning worth - 2000 provided");
        System.out.println("______________________________________________");
        System.out.println("TotalBill : " + totalBill);

    }
}