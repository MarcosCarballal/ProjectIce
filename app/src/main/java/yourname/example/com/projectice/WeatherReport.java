package yourname.example.com.projectice;
import android.util.JsonReader;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.StringReader;


import static yourname.example.com.projectice.GetHTML.getHTML;
// This class is for the call and the parsing of the JSON object provided by the DarkSky API
/**
 * Created by marcos on 7/8/2017.
 * Currently trying to mimic the behavior of http://www.studytrails.com/java/json/java-org-json/
 */
public class WeatherReport{
    private static final String TAG = "WeatherReportActivity";
    private double latitude;
    private double longitude;
    private String timezone;
    private HourlyReport [] hrs;
    private int offset; //Offset for timezone changes? Documentation unclear
    public WeatherReport(){ // Constuctor without arguments
        latitude = 0.0;
        longitude = 0.0;
        timezone = "None";
        hrs = null;
        offset = 0;
    }
    public WeatherReport(double latitude, double longitude, String Method) { // Constructor
        this.latitude = latitude;
        this.longitude = longitude;
        if (Method.equals("TimeMachine"))
        {
            System.out.println("The called method was Time Machine");
            // Find the start of day in Unix time to add onto the request
            long millis = System.currentTimeMillis();
            long unixTime = millis / 1000;
            String key = "";
            try {
                FileReader fr = new FileReader("app/src/main/assets/apikey.txt");
                Scanner s = new Scanner(fr);
                key = s.nextLine();

            } catch (FileNotFoundException e){
                System.out.println(e.getMessage());
                System.exit(1);
            }
            System.out.println("The Unix time called was " + unixTime );
            String url = "https://api.darksky.net/forecast/" + key + "/"
                    + this.latitude + "," + this.longitude + "," + unixTime;
            String result = "";
            try {
                result = getHTML(url);
            } catch (Exception e){
                System.out.println(e.getMessage());
                System.exit(1);
            }
            StringReader sr = new StringReader(result);
            JsonReader jr = new JsonReader(sr);
        } else if (Method.equals("Forecast"))
        {
            Log.d(TAG,"The called method was Forecast");
        } else
        {
            Log.d(TAG,"The called method is not supported");
        }
    }
}

