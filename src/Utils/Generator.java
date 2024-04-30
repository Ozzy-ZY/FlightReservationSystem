package Utils;

import Models.Flight;
import Models.Plane;
import java.util.Random;

public class Generator {
    public static Flight FlightGen(String origin, String destination){
        return new Flight(GenerateID(),destination,origin,
                new Plane("Boeing 737",150),randomDateGen());
    }

    private static String GenerateID(){
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 16; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }

    private static String randomDateGen(){
        Random random = new Random();
        int year = 2025;
        int month = random.nextInt(12);
        int day = random.nextInt(daysInMonth(month,year)) +1;
        return String.format("%02d/%02d/%04d",day,month,year);
    }

    private static int daysInMonth(int month,int year){
        return switch (month) {
            case 0, 2, 4, 6, 7, 9, 11 -> 31;
            case 1 -> isLeapYear(year) ? 29 : 28;
            default -> 30;
        };
    }

    private static boolean isLeapYear(int year){
        return  year % 4 == 0 && (year % 100!= 0 || year % 400 == 0);
    }
}
