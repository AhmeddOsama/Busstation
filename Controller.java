/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Station;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
/**
 *
 * @author Lenovo
 */
public class Controller {
    public TextField UserNameField ;
    public Button login;
    public PasswordField PasswordField;
    Stage PrimaryStage;
    Customer customer=new Customer("ahmed","4444","012",20);//to be equal to logged in customer (temporary constructor)
    public Button SearchButton;
    static CustomerGUI CustomerPage=new CustomerGUI();
    public TextField SearchField;
    public ChoiceBox SearchResult;
    public ToggleGroup TripTypeGroup;
    RadioButton button;
    String []st;
    PurchaseSeatGUI page; 
    Button ok;
    public Button Logout;//new
    
    static ManagerGUI ManagerPage=new ManagerGUI();//new
    static Logout logout = new Logout();//new
    public ToggleGroup IdentityToggleGroup;
    public void LoginButtonClicked() throws IOException
    {
        
        String Username=UserNameField.getText();
        String Password=PasswordField.getText();
        System.out.println(Password);
        //validation
        //if there set customer=result customer from validation
        if(button.getText().equalsIgnoreCase("passenger"))//new
        {
          CustomerPage.changeScene();
          
        }//customer page must take customer argument (or take index to customer to access main array of customers 
        
        if(button.getText().equalsIgnoreCase("manager"))//new
        {
            ManagerPage.changeScene();
        }
        //customer page must take customer argument (or take index to customer to access main array of customers 
        
        
    }
    public static void getManager(ManagerGUI man)
    {
        ManagerPage=man;
    }
    public static void getLogout(Logout out)
    {
        logout=out;
    }
    public void LogoutButtonClicked() throws IOException
    {
      logout.changeScene();
    }
    public static void getCustomer(CustomerGUI man)
    {
        CustomerPage=man;
    }
    public void IdentityType()
    {
         if (IdentityToggleGroup.getSelectedToggle() != null) {
                   
                  button = (RadioButton) IdentityToggleGroup.getSelectedToggle();
                   
               }
        
    }
    //Some values for testing
   // Time departure=new Time(20,1,12);//TEMPORARY FOR TESTING
   // Internal alex = new Internal("Trip1","mansheya",departure,(float)10);//TEMPORARY FOR TESTING
   // External cairo = new External("Trip2","cairo",departure,(float)10);//TEMPORARY FOR TESTING
    
    
    public void search()
    {
        SearchResult.getItems().clear();
        if (TripTypeGroup.getSelectedToggle() != null) {        //do search
            
       // BusStation.InternalTrips.add(alex);//TEMPORARY FOR TESTING
       // BusStation.ExternalTrips.add(cairo);//TEMPORARY FOR TESTING
        int i;
        String input =SearchField.getText();
        String tripType=TripType();
        
        
        String resultString;
        System.out.println("string="+tripType+"   input="+input);
        
               int result= customer.searchTrips(input,tripType);
        st=new String[customer.SearchedIndexes.size()];       
               
       if(result==-1)
       {
          AlertBox.display("Message","NO TRIPS FOUND FOR THIS DESTINATION");
       }
       else if(tripType.equalsIgnoreCase("internal"))
       {
           for(i=0;i<customer.SearchedIndexes.size();i++)
        {
           Trip trip =BusStation.InternalTrips.get(customer.SearchedIndexes.get(i));
           String destination=trip.Destination;
           String name=trip.Name;
           int day=trip.Departure.Day;
           int month=trip.Departure.Month;
           int hour=trip.Departure.hour;
           
           resultString=destination+" "+name+" "+String.valueOf(day)+"/"+String.valueOf(month)+" "+hour+"";
            
             
           st[i]=resultString;
           
           SearchResult.getItems().add(st[i]);
        }  
       }
       else if(tripType.equalsIgnoreCase("external"))
       {
           for(i=0;i<customer.SearchedIndexes.size();i++)
        {
           Trip trip =BusStation.ExternalTrips.get(customer.SearchedIndexes.get(i));
           String destination=trip.Destination;
           String name=trip.Name;
           int day=trip.Departure.Day;
           int month=trip.Departure.Month;
           int hour=trip.Departure.hour;
           
           resultString=destination+" "+name+" "+String.valueOf(day)+"/"+String.valueOf(month)+" "+hour+":00";
           st[i]=resultString;
           //Add items to choiceBox
            SearchResult.getItems().add(st[i]);
        }
       }
       
       
       //if didnt choose in radiobutton
       //clear searchedIndexes arraylist in customer  
        //SearchResult.
        }
        else
        {
           AlertBox.display("Warning", "CHOOSE TRIP TYPE"); 
           
        }
        //SearchResult.setValue(st[0]);//default value after search to be shown is first item found
    }
    
    public String TripType()
    {
        
         
               
                   
                    button = (RadioButton) TripTypeGroup.getSelectedToggle();
                   System.out.println("Button: " + button.getText());
                   return button.getText();
                   
               
               //else alert box
       
       
 
    }
    public int getChoice(ChoiceBox<String> c)       //returns index of SearchedIndex element chosen
    {
        int i;
        int CouldntFind=-1;
        String s =c.getValue();
        if(TripType().equalsIgnoreCase("internal"))
        {
        for(i=0;i<customer.SearchedIndexes.size();i++)
        {
            
            Trip t=BusStation.InternalTrips.get(customer.SearchedIndexes.get(i));
            String destination =t.Destination;
            String name=t.Name;
            int day=t.Departure.Day;
            int month=t.Departure.Month;
            int hour=t.AvailableSeats;
            
            String DummyString=destination+" "+name+" "+String.valueOf(day)+"/"+String.valueOf(month)+" "+hour+":00";
            
            if(s.equalsIgnoreCase(DummyString))      
            {
                System.out.println("s="+s);
                System.out.println("DummyString="+DummyString);
                return i;   //location of index
                
            }
            
        }
        }
        else if(TripType().equalsIgnoreCase("external"))
        {
            for(i=0;i<customer.SearchedIndexes.size();i++)
        {
            
            Trip t=BusStation.ExternalTrips.get(customer.SearchedIndexes.get(i));
            String destination =t.Destination;
            String name=t.Name;
            int day=t.Departure.Day;
            int month=t.Departure.Month;
            int hour=t.Departure.hour;
            String DummyString=destination+" "+name+" "+String.valueOf(day)+"/"+String.valueOf(month)+" "+hour+":00";
            if(s.equalsIgnoreCase(DummyString))      
            {
                return i;
            }
            
        }
            
       
        }
        else
        {
            //DO NOTHING JUST FOR NOW
        }
        System.out.println("error finding choice");
        return CouldntFind;
        
    }
        
    public void ChosenTrip() throws IOException
    {
        int indexlocation=getChoice(SearchResult);
        if(indexlocation==-1)
        {
            System.out.println("Error in get choice");
        }
        else
        {    
        int indexInTripsArraylist=customer.SearchedIndexes.get(indexlocation);
        if(TripType().equalsIgnoreCase("internal"))
        {
            //Internal trip=BusStation.InternalTrips.get(indexInTripsArraylist);
            page= new PurchaseSeatGUI(indexInTripsArraylist,"internal");
            page.displayWindow();
        }
        else if(TripType().equalsIgnoreCase("external"))
        {
            page= new PurchaseSeatGUI(indexInTripsArraylist,"internal");
            page.displayWindow();
        }
        
        }
    }
    public void test()
    {
        System.out.println("ACTION");
    }
    
    
    
    
}
