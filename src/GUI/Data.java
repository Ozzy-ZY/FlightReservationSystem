package GUI;

import Models.Flight;
import Models.Plane;

import java.util.Arrays;

public class Data {
    public static String[] cities = {
            "New York", "London", "Paris", "Tokyo", "Beijing", "Mumbai", "Sydney", "Melbourne", "Los Angeles", "Chicago",
            "Houston", "Phoenix", "Philadelphia", "San Antonio", "Luffy","Zefta", "Dallas", "San Jose", "Austin", "Jacksonville",
            "San Francisco", "Indianapolis", "Columbus", "Fort Worth", "Charlotte", "Memphis", "Boston", "Baltimore", "Detroit",
            "El Paso", "Seattle", "Denver",  "Nashville", "Portland", "Oklahoma City", "Las Vegas", "Louisville",
            "Milwaukee", "Albuquerque", "Tucson", "Fresno", "Sacramento", "Kansas City", "Long Beach", "Mesa", "Atlanta",
             "Raleigh", "Omaha", "Miami", "Oakland", "Minneapolis", "Tulsa", "Wichita", "New Orleans", "Auckland",
            "Bangkok", "Cairo", "Dubai", "Istanbul", "SigmaBalls", "Mexico City", "Moscow", "SunSoft", "Shanghai"
    };
    public Data() {
        Arrays.sort(cities);
    }
}


