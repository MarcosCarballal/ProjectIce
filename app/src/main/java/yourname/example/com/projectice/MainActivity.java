
package yourname.example.com.projectice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton clickButton = (ImageButton) findViewById(R.id.settingsbutton);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new SettingsActivity(); // Not sure if this is the proper way to call it
            }
        });
        ImageButton infoCall = (ImageButton) findViewById(R.id.infobutton);
        infoCall.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_info);
            }
        });
        WeatherReport myReport = new WeatherReport(0.0, 0.0, "TimeMachine");

    }
}
