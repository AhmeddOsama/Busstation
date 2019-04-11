/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Station;

import com.sun.org.apache.xerces.internal.util.DraconianErrorHandler;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sun.util.locale.provider.AvailableLanguageTags;

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
    
    public static Manager one = new Manager("ahmedosama","5935");
    
    ManagerGUI ManagerPage=new ManagerGUI();
    Logout logout = new Logout();
    CustomerGUI CustomerPage=new CustomerGUI();

    
    public void start(Stage PrimaryStage) throws IOException
    {
        //testing shit //
        makeDrivers();
        makeVehicles();
        //-------------------------//
        Parent root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
        CustomerPage.getStage(PrimaryStage);
        Controller.getCustomer(CustomerPage);
        ManagerPage.getStage(PrimaryStage);
        logout.getStage(PrimaryStage);
        Controller.getManager(ManagerPage);//new
        Controller.getLogout(logout);
        PrimaryStage.setTitle("Hi man");
        PrimaryStage.setScene(new Scene(root,600,300));
        PrimaryStage.show();
    }

    
    public static void main(String[] args)
    {
        launch(args);
    }
    public static void makeDrivers()
            {
                int i;
                for(i=0;i<10;i++)
                {
                    Driver hoss = new Driver("Hossam "+i,"20");
                    AvailableDrivers.add(hoss);
                }
            }
     public static void makeVehicles()
             {
                 int i;
                 for(i=0;i<10;i++)
                 {
                     Limo limo= new Limo();
                     Bus bus = new Bus();
                     MiniBus minibus = new MiniBus();
                     AvailableVehicles.add(bus);
                     AvailableVehicles.add(limo);
                     AvailableVehicles.add(minibus);
                 }
             }
    public static Driver getDriver(String driver)
    {
        int i;
        Driver assigned ;
       
        for(i=0;i<AvailableDrivers.size();i++)
        {
            
         if(AvailableDrivers.get(i).Name.equalsIgnoreCase(driver))
         {
             System.out.println("done and string "+driver);
             assigned=AvailableDrivers.get(i);
             AvailableDrivers.remove(i);
             return assigned;
         }
        }
        return null;
    }
 public static Vehicle getVehicle(String type)
 {
     int i;
     Vehicle vehicle;
     if(type.equalsIgnoreCase("bus"))
     {
         vehicle=new Bus();
        
     }
     else if(type.equalsIgnoreCase("limo"))
     {
      
         vehicle= new Limo();
     } 
     else if(type.equalsIgnoreCase("minibus"))
     {
         
         vehicle= new MiniBus();
     }
     for(i=0;i<AvailableVehicles.size();i++)
     {
         if(AvailableVehicles.get(i).type.equalsIgnoreCase(type))
         {
             
             vehicle=AvailableVehicles.get(i);
         
             AvailableVehicles.remove(i);
             return vehicle;
         }
     }
     return null;
 }

}

