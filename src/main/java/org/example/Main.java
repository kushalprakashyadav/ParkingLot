package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("You Parking Lot is being Created");

        ParkingLot parkingLot=ParkingLot.INSTANCE;

        System.out.println(parkingLot);

        System.out.println("Your Parking lot is created with 3 levels, with 20 spots for Bike, 40 spots for cars ans 40 spots for Bus, Please add new level, if required");
        while(true){

            System.out.println("\nYou can query here:");

            String input=scanner.nextLine();

            if(input.equals("exit")){
                System.out.println("Closing the Parking lot");
                break;
            }
            if(input.equals("add Level")){
                System.out.println("Adding the new Level");
                parkingLot.addLevel();
            }

            if(input.equals("check for car")){
                System.out.println(parkingLot.checkIfParkingAvailableParkingAtAnyLevel(VehicleType.CAR));
            }
            if(input.equals("check for bike")){
                System.out.println(parkingLot.checkIfParkingAvailableParkingAtAnyLevel(VehicleType.BIKE));
            }
            if(input.equals("check for bus")){
                System.out.println(parkingLot.checkIfParkingAvailableParkingAtAnyLevel(VehicleType.BUS));
            }


        }

    }

}