/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Station;

import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lenovo
 */
public class BusStation extends Application{
    public static ArrayList<Internal> InternalTrips = new ArrayList<Internal>();
    public static ArrayList<External> ExternalTrips = new ArrayList<External>();
    public static ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
    public static ArrayList<Driver> Drivers = new ArrayList<Driver>();
    public static ArrayList<Customer> Customers=new ArrayList<Customer>();
    public static ArrayList<Driver> AvailableDrivers =new ArrayList<Driver>();
    public static ArrayList<Vehicle> AvailableVehicles = new ArrayList<Vehicle>();
    
    CustomerGUI CustomerPage=new CustomerGUI();
    ManagerPage.getStage(PrimaryStage);
    
    public void start(Stage PrimaryStage) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
        CustomerPage.getStage(PrimaryStage);
        Controller.getCustomer(CustomerPage);
        
        PrimaryStage.setTitle("Hi man");
        PrimaryStage.setScene(new Scene(root,600,300));
        PrimaryStage.show();
    }

    
    public static void main(String[] args)
    {
        launch(args);
    }

}

