package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Level {

    private List<Spot> spotList;
    private Map<VehicleType,Integer> mapOfUnParkedSlots;
    private Integer levelNumber;

    public Level(List<Spot> spotList, Integer levelNumber, int countOfBikeSlots, int countOfCarSlots, int countOfBusSlots){
        this.spotList=spotList;
        this.levelNumber=levelNumber;
        this.mapOfUnParkedSlots =new HashMap<>();
        mapOfUnParkedSlots.put(VehicleType.BIKE,countOfBikeSlots);
        mapOfUnParkedSlots.put(VehicleType.CAR,countOfCarSlots);
        mapOfUnParkedSlots.put(VehicleType.BUS,countOfBusSlots);
    }

    public List<Spot> getSpotList(){
        return spotList;
    }

    public Map<VehicleType,Integer> getMapOfUnParkedSlots(){
        return mapOfUnParkedSlots;
    }
}
