package org.example;

import java.util.HashMap;
import java.util.List;

public class CarService {
   private HashMap<ServiceCode,Integer>servicePrices = new HashMap<>();
   private CarType carType;

   public CarService(CarType carType){
       this.carType = carType;
       initialiseServicePrices();
   }
   public int servicePrice(ServiceCode code){
      return servicePrices.getOrDefault(code,0);
   }

   public void initialiseServicePrices(){
       servicePrices.put(ServiceCode.BS01,carType==CarType.HATCHBACK?2000 : carType==CarType.SEDAN?4000 : 5000);
       servicePrices.put(ServiceCode.EF01, carType==CarType.HATCHBACK?5000 : carType==CarType.SEDAN?8000 : 10000);
       servicePrices.put(ServiceCode.CF01, carType==CarType.HATCHBACK? 2000 : carType==CarType.SEDAN? 4000 : 6000);
       servicePrices.put(ServiceCode.BF01, carType == CarType.HATCHBACK? 1000 : carType==CarType.SEDAN? 1500 : 2500);
       servicePrices.put(ServiceCode.GF01, carType == CarType.HATCHBACK? 3000 : carType==CarType.SEDAN? 6000 : 8000);
   }

   public int calculateBill(List<ServiceCode>requestedServices){
       int totalBill = 0;
       for(ServiceCode sc : requestedServices){
           int amount = servicePrice(sc);
           if(amount>0) totalBill += amount;
       }return totalBill;
   }

}
