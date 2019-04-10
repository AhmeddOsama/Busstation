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
        
        public ToggleGroup AddType;
        public RadioButton button;
        public RadioButton VehicleButton;
        public AlertBox box;
        public ToggleGroup VehicleType;
        
public void addClicked()
{
    int Stops;
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
                        if(Validation.checkDate(DDay,DMonth,DYear)==1&&Validation.checkNumber(StopsInput.getText())==1&&Validation.checkDate(ADay,AMonth,AYear)==1)
                        {
                               Stops=Integer.parseInt(StopsInput.getText());
                               Time Departure = new Time(Integer.parseInt(DDay),Integer.parseInt(DMonth),Integer.parseInt(DYear));
                               Time Arrival = new Time(Integer.parseInt(ADay),Integer.parseInt(AMonth),Integer.parseInt(AYear));
                               if(button.getText().compareToIgnoreCase("Internal")<=0)
                                {
                                   Internal CreatedTrip = new Internal(DestinationInput.getText(),Stops, Departure, Arrival,BusStation.getDriver());
                                   BusStation.InternalTrips.add(CreatedTrip);
         
                                 }
                               else if(button.getText().compareToIgnoreCase("Externall")<=0)
                              {
                                External CreatedTrip = new External(DestinationInput.getText(),Stops, Departure, Arrival,BusStation.getDriver());             
                                BusStation.ExternalTrips.add(CreatedTrip);
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
                    }
                    else if (VehicleType.getSelectedToggle() != null)
                    {
                        AlertBox.display("Error","No Vehicle Type Selected");
                    }
            }
     else if (AddType.getSelectedToggle() != null)
     {
         AlertBox.display("Error","No Trip Type selected");
     }
     
     
}



}

