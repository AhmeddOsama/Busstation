/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bus_Station;

/**
 *
 * @author Lenovo
 */
public class Time {
    int Day;
    int Month;
    int Year;
    int hour;
    int minute;
    
   static int RealDay=1;
   static int RealMonth=1;
   static int RealYear=2019;
    
    
    public Time(int day,int month,int year,int hour,int minute)
    {
        
    }
    public Time(int day,int month,int year)
    {
        Day=day;
        Month=month;
        Year=year;
    }
    public Time()
    {
        
    }
    public static void nextDay()
    {
        if(RealMonth==12&&RealDay==30)
        {
            RealMonth=1;
            RealDay=1;
            RealYear++;
        }
        if(RealDay==30)
        {
            RealMonth++;
            RealDay=1;
        }
        else
        {
            RealDay++;
        }
        
    }
    
}
