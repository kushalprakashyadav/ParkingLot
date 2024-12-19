package org.example;


import org.example.Vehicles.Bike;
import org.example.Vehicles.Car;

import java.util.ArrayList;
import java.util.List;


public enum ParkingLot {

    INSTANCE;

    private List<Level> levelList=new ArrayList<>();

    public synchronized void addLevel(){

        List<Spot> spotList=new ArrayList<>();
        for(int i=0;i<20;i++){
            spotList.add(new Spot(null,false,VehicleType.BIKE));
        }

        for(int i=0;i<40;i++){
            spotList.add(new Spot(null,false,VehicleType.CAR));
        }

        for(int i=0;i<40;i++){
            spotList.add(new Spot(null,false,VehicleType.BUS));
        }
        Level level=new Level(spotList,levelList.size()+1,20,40,40);
        levelList.add(level);
    }

    public synchronized ParkingData parkTheVehicle(String vehicleNumber,VehicleType vehicleType){
        for(int i=0;i<levelList.size();i++){
            for(int j=0;j<100;j++){
                Spot spot=levelList.get(i).getSpotList().get(j);
                if(!spot.getIfParked()){
                    if(vehicleType.equals(VehicleType.BIKE)){
                        spot.setVehicle(new Bike(vehicleNumber));
                        spot.setIfParked(true);
                        levelList.get(i).getMapOfUnParkedSlots().put(spot.getVehicleType(),levelList.get(i).getMapOfUnParkedSlots().get(spot.getVehicleType())-1);
                        return new ParkingData(i+1,j+1);
                    }else if(vehicleType.equals(VehicleType.CAR) && !spot.getVehicleType().equals(VehicleType.BIKE)){
                        spot.setVehicle(new Car(vehicleNumber));
                        spot.setIfParked(true);
                        levelList.get(i).getMapOfUnParkedSlots().put(spot.getVehicleType(),levelList.get(i).getMapOfUnParkedSlots().get(spot.getVehicleType())-1);
                        return new ParkingData(i+1,j+1);
                    }else if(vehicleType.equals(VehicleType.BUS) && spot.getVehicleType().equals(VehicleType.BUS)) {
                        spot.setVehicle(new Bike(vehicleNumber));
                        spot.setIfParked(true);
                        levelList.get(i).getMapOfUnParkedSlots().put(spot.getVehicleType(),levelList.get(i).getMapOfUnParkedSlots().get(spot.getVehicleType())-1);
                        return new ParkingData(i + 1, j + 1);
                    }

                }
            }
        }

            throw new RuntimeException("All slots are full, will not be able to park the "+vehicleType.name());

    }

    public synchronized void unPark(Integer level,Integer slotNumber){
        levelList.get(level-1).getSpotList().get(slotNumber-1).setIfParked(false);
        levelList.get(level-1).getSpotList().get(slotNumber-1).setVehicle(null);
    }

    public boolean checkIfParkingAvailableParkingAtAnyLevel(VehicleType vehicleType){
        if(vehicleType.equals(VehicleType.BIKE)){
            for(Level level:levelList){
                if(level.getMapOfUnParkedSlots().values().stream().filter(x->x>0).findFirst().isPresent()){
                    return true;
                }
            }
            return false;
        }else if(vehicleType.equals(VehicleType.CAR)){
            for(Level level:levelList){
                if(level.getMapOfUnParkedSlots().get(VehicleType.CAR)>0 ||level.getMapOfUnParkedSlots().get(VehicleType.BUS)>0 ){
                    return true;
                }
            }
            return false;
        }else{
            for(Level level:levelList){
                if(level.getMapOfUnParkedSlots().get(VehicleType.BUS)>0 ){
                    return true;
                }
            }
            return false;
        }
    }


}
