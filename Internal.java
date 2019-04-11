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
public class Internal extends Trip {

    public Internal(String destination, int numberOfStops, Time departure, Time arrival, Driver driver) {
        super(destination, numberOfStops, departure, arrival, driver);
        
    }
    public Internal(String from,Time departure,Time arrival,Driver driver,Vehicle vehicle,String name,int numberOfStops,float price)
    {
    super(from,departure,arrival,driver,vehicle,name,numberOfStops,price); 
    this.AvailableSeats=vehicle.seats;
    }
    
    public Internal(String destination, int numberOfStops, Time departure, Time arrival,Driver driver,Vehicle vehicle,String name,float price) {
        super(destination, numberOfStops, departure, arrival, driver, vehicle,name,price);
        this.AvailableSeats=vehicle.seats;
    }
    
   public Internal(String name,String destination, Time departure,float price) {
     
       super(name,destination, departure, price);
        
    }

    public Internal()
    {
        
    }
    
   // public Internal(String from,Time Departure,Time Arrival,Driver driver,int stops)
    //{
      //  super(from,Departure,Arrival,driver,stops);
    //}
    
    @Override
    public void calculatePrice()
    {
        
    }
    
}
