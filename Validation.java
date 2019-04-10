/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Station;

public class Validation {
    
    static int checkDate(String Day,String Month,String Year)
    {
        String dummyDay=Day;
        String dummyMonth=Month;
        String dummyYear=Year;
        System.out.println(" Day  "+Integer.parseInt(dummyDay)+" ");
       if(Integer.parseInt(dummyDay)<30&&Integer.parseInt(dummyMonth)<13&&Integer.parseInt(dummyYear)>=2019)
       {
           return 1;
       }
       else 
       {
           //error
           return 0;
       }
    }
    static int checkNumber(String string)
    {
        try {
        return 1;
    } catch (Exception e) {
        //alert box;
        return 0;
    }
    }
    
}
