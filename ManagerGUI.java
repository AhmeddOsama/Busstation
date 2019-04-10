/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Station;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class ManagerGUI {
    Stage PrimaryStage=new Stage();
    
    public void getStage(Stage PrimaryStage)
    {
        this.PrimaryStage=PrimaryStage;
    }
    public void changeScene() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ManagerPage.fxml"));
        
        PrimaryStage.setScene(new Scene(root,600,600));
        PrimaryStage.show();
    
}
}
