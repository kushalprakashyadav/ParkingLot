package org.example;

public class Spot {

    private Vehicle vehicle;
    private boolean isParked;
    private VehicleType vehicleType;

    public Spot(Vehicle vehicle,boolean isParked,VehicleType vehicleType){
        this.vehicle=vehicle;
        this.isParked=isParked;
        this.vehicleType=vehicleType;
    }

    public boolean getIfParked(){
        return isParked;
    }

    public VehicleType getVehicleType(){
        return vehicleType;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }
    public void setIfParked(boolean park){
         this.isParked=park;
    }
    public void setVehicle(Vehicle vehicle){
         this.vehicle=vehicle;
    }
}
