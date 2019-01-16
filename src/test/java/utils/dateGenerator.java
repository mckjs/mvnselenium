package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateGenerator {

/*    public void main(String args[]) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        *//*String newDate = dateFormat.format(date);*//*
        System.out.println(">>2weeks>>>... " + this.setNextWeekDate());
        System.out.println(">>today>>>... " + this.setTodayDate());
    }*/

    public String setTodayDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MM/yyyy");
        String todayDate = dateFormat.format(date);

        System.out.println(">>todayDate>>>... " + todayDate);

        return todayDate;
    }

    public String setNextWeekDate() {
        int noOfDays = 14; //i.e two weeks
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
        Date Time = calendar.getTime();
        System.out.println(">>Time>>>... " + Time);
        String newDate = date.toString();
        return newDate;
    }

}
