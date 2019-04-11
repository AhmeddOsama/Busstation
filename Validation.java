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
       if(Integer.parseInt(dummyDay)<=30&&Integer.parseInt(dummyMonth)<13&&Integer.parseInt(dummyYear)>=2019)
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
            int num;
            num=Integer.parseInt(string);
        return 1;
    } catch (Exception e) {
        
        return 0;
    }
    }
    static int checkFloatNumber(String string)
    {
        try {
            float num;
            num=Float.parseFloat(string);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    public int checkManager(String username,String password)
    {
       String string= BusStation.one.Username;
       String string2=BusStation.one.Password;
        if(username.equals(string)&&password.equals(string2))
        {
            return 1;
        }
        return 0;
    }
    public static int checkUser(String username,String password)
    {
        String usercmp;
        String passcmp;
        int i;
        for(i=0;i<BusStation.Customers.size();i++)
        { 
            usercmp=BusStation.Customers.get(i).Username;
            passcmp=BusStation.Customers.get(i).Password;
            
          if(username.equals(usercmp)&&password.equals(passcmp))
          {
              return 1;
          }
        }
        return 0;
    }
}
