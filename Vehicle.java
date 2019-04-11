/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Station;

import java.util.Set;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;

/**
 *
 * @author Lenovo
 */
public class Vehicle {
    private Boolean Available=true;
    private float factor;
    int seats;
    String type;
  public Vehicle()
  {
      
  }
    public Boolean getAvailable() {
        return Available;
    }

    public float getFactor() {
        return factor;
    }

    
    public void setFactor(float factor) {
        this.factor = factor;
    }

}

class Limo extends Vehicle
        {
     public Limo ()
     {
         this.seats=6;
         this.type="Limo";
     }
     

   
        }
class MiniBus extends Vehicle
        {
    public MiniBus ()
     {
         this.seats=14;
         this.type="MiniBus";
     }
        }
class Bus extends Vehicle
        {
     public Bus ()
     {
         this.seats=24;
         this.type="Bus";
     }
        }   