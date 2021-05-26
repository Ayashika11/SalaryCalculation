package com.company;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> hoursPerDay =new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int salary=0,perHourCharge=0;
        for(int days=0;days<7;days++){
            int hour = sc.nextInt();
            hoursPerDay.add(hour);
        }
        salary+=((hoursPerDay.get(0) * 150) + (hoursPerDay.get(6) * 125));
        for(int workDay=1;workDay<6;workDay++)
        {
            perHourCharge=hoursPerDay.get(workDay) * 100;
            if(hoursPerDay.get(workDay)<=8) {
                salary += perHourCharge;
            }
            else {
                salary += (moreThan8hours(hoursPerDay.get(workDay)) + perHourCharge);
            }
        }
        int workInWeek = beyond40(hoursPerDay),bonusHour;
        if(workInWeek>40){
            bonusHour=workInWeek-40;
            salary += bonusHour*25;
        }
        System.out.println(salary);
    }

    private static int moreThan8hours(Integer hour) {
        int remainingHours =hour-8;
        return remainingHours *15;
    }

    private static int beyond40(ArrayList<Integer> workedHours) {
        int total=0;
        for( int work : workedHours) {
            total+=work;
        }
        return total;
    }
}
