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
    Stage PrimaryStage = new Stage();
    Customer customer;
    public Button SearchButton;
    public Button Logout;//new
    static CustomerGUI CustomerPage=new CustomerGUI();
    static ManagerGUI ManagerPage=new ManagerGUI();//new
    static Logout logout = new Logout();//new
    public TextField SearchField;
    public ChoiceBox SearchResult;
    public ToggleGroup TripTypeGroup;
    public ToggleGroup IdentityToggleGroup;//new
    RadioButton button;
    
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
        
    }
    public void LogoutButtonClicked() throws IOException
    {
      logout.changeScene();
    }
    public static void getCustomer(CustomerGUI man)
    {
        CustomerPage=man;
    }
    public static void getManager(ManagerGUI man)
    {
        ManagerPage=man;
    }
    public static void getLogout(Logout out)
    {
        logout=out;
    }
    public void search()
    {
        String input =SearchField.getText();
        TripType();
       
        //put names of each trip in an array
        //SearchResult.
        
    }
    public void IdentityType()
    {
         if (IdentityToggleGroup.getSelectedToggle() != null) {
                   
                  button = (RadioButton) IdentityToggleGroup.getSelectedToggle();
                   
               }
        
    }
    
    public String TripType()
    {
               if (TripTypeGroup.getSelectedToggle() != null) {
                   
                    button = (RadioButton) TripTypeGroup.getSelectedToggle();  
               }
               //else alert box
       return button.getText();
 
    }
    
   
}
