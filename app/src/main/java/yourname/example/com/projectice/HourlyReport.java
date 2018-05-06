
package yourname.example.com.projectice;

/**
 * Created by marco on 7/17/2017.
 */

class HourlyReport extends WeatherReport {
    public int time;
    public String summary;
    public String icon;
    public int precipIntensity;
    public int precipProbability;
    public HourlyReport(String JSON) {
        super(); // Constructor

    }
}

