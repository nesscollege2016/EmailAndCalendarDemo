package ness.tomerbu.edu.emailandcalendardemo;

import android.content.Intent;
import android.os.Build;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.apache.http.protocol.HTTP;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button btnCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalendar = (Button) findViewById(R.id.btnCalendar);

        if (!isLargerThanIceCream()){
            btnCalendar.setVisibility(View.GONE);
        }
    }

    public void email(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"Tomer.bu@gmail"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello, Kitty");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Kitty is a bad bad kitten");

        startActivity(emailIntent);

    }

    public boolean isLargerThanIceCream(){
        return  android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }

    public void calendar(View view) {

    Intent calendarIntent = null;
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);


            Calendar c = Calendar.getInstance();
        c.set(2016, 5, 9, 12, 22);
        long beginTime = c.getTimeInMillis();

        c.set(2016, 5, 9, 22, 10);
        long endTime = c.getTimeInMillis();

        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, false);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime);

        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Android Class");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Beer Sheva");

        startActivity(calendarIntent);
            }
        }

}
