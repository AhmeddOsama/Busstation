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

public class ManagerController {
        public TextField DestinationInput;
        public TextField StopsInput;
        public TextField DepartureDay;
        public TextField DepartureMonth;
        public TextField DepartureYear;
        public TextField ArrivalDay;
        public TextField ArrivalMonth;
        public TextField ArrivalYear;
        public Logout logout=new Logout() ;
        public ToggleGroup AddType;
        public RadioButton button;
        public RadioButton VehicleButton;
        public AlertBox box;
        public ToggleGroup VehicleType;
        public TextField NameInput;
        public TextField PriceInput;
        public ChoiceBox<String>DriversList= new ChoiceBox();
        public TextField CancelName;
        public ToggleGroup CancelType;
        public Label numberoftrips;
        
        
        String[] st=new String[10]; 
        public ChoiceBox <String>CancelList;
        public void setnumberoftrips()
        {
            int number=BusStation.InternalTrips.size()+BusStation.ExternalTrips.size();
            numberoftrips.setText(" "+number);
        }
        public void driversList()
        {
            clearList();
            System.out.println("hi");
            int i;
            for(i=0;i<BusStation.AvailableDrivers.size();i++)
        {
            st[i]=BusStation.AvailableDrivers.get(i).Name;
            DriversList.getItems().add(st[i]);
        }
        }
        public void clearList()
        {
         DriversList.getItems().clear();
        }
        public void nextDay()
        {
            
            int i;
            Time.nextDay();
               System.out.println("next day"+Time.RealDay);
            for(i=0;i<BusStation.InternalTrips.size();i++)
            {
                Trip trip = BusStation.InternalTrips.get(i);
                if(trip.Departure.Year==Time.RealYear)
                {
                    if(trip.Departure.Month==Time.RealMonth)
                    {
                        if(trip.Departure.Day<Time.RealDay)
                        {
                            BusStation.InternalTrips.remove(i);
                        }
                    }
                }
            }
            for(i=0;i<BusStation.ExternalTrips.size();i++)
            {
                Trip trip = BusStation.ExternalTrips.get(i);
                if(trip.Departure.Year==Time.RealYear)
                {
                    if(trip.Departure.Month==Time.RealMonth)
                    {
                        if(trip.Departure.Day<Time.RealDay)
                        {
                            BusStation.ExternalTrips.remove(i);
                        }
                    }
                }
            }
            setnumberoftrips();
        }
public void addClicked()
{
    
    int Stops;
    float price;
    String DDay=DepartureDay.getText();
    String DMonth=DepartureMonth.getText();
    String DYear=DepartureYear.getText();
    String ADay=ArrivalDay.getText();
    String AMonth=ArrivalMonth.getText();
    String AYear=ArrivalYear.getText();
    
    
     if (AddType.getSelectedToggle() != null) 
            {
                 button = (RadioButton) AddType.getSelectedToggle();
                     if (VehicleType.getSelectedToggle() != null) 
                    {
                        VehicleButton= (RadioButton) VehicleType.getSelectedToggle();
                        if(Validation.checkDate(DDay,DMonth,DYear)==1&&Validation.checkNumber(StopsInput.getText())==1&&Validation.checkDate(ADay,AMonth,AYear)==1&&Validation.checkFloatNumber(PriceInput.getText())==1)
                        {
                               
                               Stops=Integer.parseInt(StopsInput.getText());
                               price=Float.parseFloat(PriceInput.getText());
                               Time Departure = new Time(Integer.parseInt(DDay),Integer.parseInt(DMonth),Integer.parseInt(DYear));
                               Time Arrival = new Time(Integer.parseInt(ADay),Integer.parseInt(AMonth),Integer.parseInt(AYear));
                               if(button.getText().compareToIgnoreCase("Internal")<=0)
                                {
                                    
                                   Driver driver = BusStation.getDriver(DriversList.getValue());
                                   Vehicle vehicle = BusStation.getVehicle(VehicleButton.getText());
                                    System.out.println("hiiiiii seats "+vehicle.seats);
                                   Internal CreatedTrip1 = new Internal(DestinationInput.getText(), Stops, Departure, Arrival,driver,vehicle,NameInput.getText(),price);
                                   Internal CreatedTrip2 = new Internal(DestinationInput.getText(),Departure, Arrival,driver,vehicle," "+DestinationInput.getText()+"-GCS",Stops,price);
                                   BusStation.InternalTrips.add(CreatedTrip1);
                                   BusStation.InternalTrips.add(CreatedTrip2);
                                   driver.AssignedTrips.add(CreatedTrip1);
                                   driver.AssignedTrips.add(CreatedTrip2);
                                   
                                 }
                               else if(button.getText().compareToIgnoreCase("Externall")<=0)
                              {
                                  Driver driver = BusStation.getDriver(DriversList.getValue());
                                  Vehicle vehicle = BusStation.getVehicle(VehicleButton.getText());
                                  System.out.println("hiiiiii seats "+vehicle.seats);
                                External CreatedTrip1 = new External(DestinationInput.getText(), Stops, Departure, Arrival,driver,vehicle,NameInput.getText(),price);
                                External CreatedTrip2 = new External(DestinationInput.getText(),Departure, Arrival,driver,vehicle,DestinationInput.getText()+" - G.S.B.C",Stops,price);
                                BusStation.ExternalTrips.add(CreatedTrip1);
                                BusStation.ExternalTrips.add(CreatedTrip1);
                                driver.AssignedTrips.add(CreatedTrip1);
                                driver.AssignedTrips.add(CreatedTrip2);
                             }
         
                                AlertBox.display("Notification","Trip Added Successfully");
                                DestinationInput.setText("");
                                StopsInput.setText("");
                                DepartureDay.setText("");
                                DepartureMonth.setText("");
                                DepartureYear.setText("");
                                ArrivalDay.setText("");
                                ArrivalMonth.setText("");
                                ArrivalYear.setText("");
                          }
                        else {
                            AlertBox.display("Error", "Invalid Input");
                        }
                    }
                    else if (VehicleType.getSelectedToggle() == null)
                    {
                        AlertBox.display("Error","No Vehicle Type Selected");
                    }
            }
     else if (AddType.getSelectedToggle() == null)
     {
         AlertBox.display("Error","No Trip Type selected");
     }
     
     clearList();
}
public void cancelList()
{
    RadioButton type;
    int i;
    String cancelDestination;
    String resultString;
    cancelDestination=CancelName.getText();
    if(CancelType.getSelectedToggle()!=null)
    {
        CancelList.getItems().clear();
        type= (RadioButton) CancelType.getSelectedToggle();
        if(type.getText().equalsIgnoreCase("internal"))
        {
            for(i=0;i<BusStation.InternalTrips.size();i++)
            {
                Trip trip =BusStation.InternalTrips.get(i);
                String name=trip.Name;
                String destination=trip.Destination;
                int day=trip.Departure.Day;
                int month=trip.Departure.Month;
                
                int seats=24;
                
                resultString=destination+" "+name+" "+String.valueOf(day)+"/"+String.valueOf(month)+" "+seats+"";
               // System.out.println(" STRING  " +resultString);
                if(cancelDestination.equalsIgnoreCase(BusStation.InternalTrips.get(i).Destination))
                {
                  CancelList.getItems().add(resultString);
                }
            }
        }
        if(type.getText().equalsIgnoreCase("external"))
        {
            for(i=0;i<BusStation.ExternalTrips.size();i++)
            {
                Trip trip =BusStation.ExternalTrips.get(i);
                String name=trip.Name;
                String destination=trip.Destination;
                int day=trip.Departure.Day;
                int month=trip.Departure.Month;
                int hour=trip.Departure.hour;
                int seats=trip.Vehicle.seats;
                resultString=destination+" "+name+" "+String.valueOf(day)+"/"+String.valueOf(month)+" "+seats+"";
                if(cancelDestination.equalsIgnoreCase(BusStation.InternalTrips.get(i).Destination))
                {
                  CancelList.getItems().add(resultString);
                }
            }
        }
    }
    else if (CancelType.getSelectedToggle()==null)
    {
        AlertBox.display("Error","No Trip Type selected");
    }
    
}
public void removeTrip()
{
    int i;

    if(CancelList.getValue()==null)
    {
        AlertBox.display("Error","No Trip Selected");
    }
    else
        {
            RadioButton type= (RadioButton) CancelType.getSelectedToggle();
            if(type.getText().equalsIgnoreCase("internal"))
            {
                 for(i=0;i<BusStation.InternalTrips.size();i++)
                {
                    Trip trip =BusStation.InternalTrips.get(i);
                    String name=trip.Name;
                    String destination=trip.Destination;
                    int day=trip.Departure.Day;
                    int month=trip.Departure.Month;
                    int hour=trip.Departure.hour;
                    int seats=24;
                    
                     String resultString=destination+" "+name+" "+String.valueOf(day)+"/"+String.valueOf(month)+" "+seats+"";
                    if(CancelList.getValue().equalsIgnoreCase(resultString))
                    {
                        Manager.CancelTrip(i,"internal");
                    }
                }
                }
            if(type.getText().equalsIgnoreCase("external"))
            {
                 for(i=0;i<BusStation.InternalTrips.size();i++)
                {
                    Trip trip =BusStation.InternalTrips.get(i);
                    String name=trip.Name;
                    String destination=trip.Destination;
                    int day=trip.Departure.Day;
                    int month=trip.Departure.Month;
                    int hour=trip.Departure.hour;
                    int seats=trip.Vehicle.seats;
                    String resultString=destination+" "+name+" "+String.valueOf(day)+"/"+String.valueOf(month)+" "+seats+"";
      
                    if(CancelList.getValue().equalsIgnoreCase(resultString))
                    {
                        Manager.CancelTrip(i,"external");
                    }
                }
             }
            AlertBox.display("SUCCESS","Trip removed");
            CancelList.getItems().clear();
        }
}
public void logout() throws IOException
{
    logout.changeScene();
}
}
