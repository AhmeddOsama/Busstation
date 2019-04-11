/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Station;

/**
 *
 * @author Lenovo
 */
public class External extends Trip{

    public External(String destination, int numberOfStops, Time departure, Time arrival,Driver driver,Vehicle vehicle,String name,float price) {
        super(destination, numberOfStops, departure, arrival, driver, vehicle,name,price);
        this.AvailableSeats=vehicle.seats;
    }
     public External(String name,String destination, Time departure,float price) {
       super(name,destination, departure, price);        
    }
     public External (String Destination,int stops,Time Departure,Time Arrival,Driver driver)
    {
         super(Destination,stops,Departure,Arrival,driver);
    }
    public External(String from,Time departure,Time arrival,Driver driver,Vehicle vehicle,String name,int numberOfStops,float price)
    {
        super(from,departure,arrival,driver,vehicle,name,numberOfStops,price);
        this.AvailableSeats=vehicle.seats;
    }
    

    @Override
   public void calculatePrice()
    {
        
    }
    
}
