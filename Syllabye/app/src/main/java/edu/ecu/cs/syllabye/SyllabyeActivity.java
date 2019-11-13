package edu.ecu.cs.syllabye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SyllabyeActivity extends AppCompatActivity {

    private static final String TAG = "SyllabyeActivity";

    private Button mCalendarButton;
    private Button mRemindersButton;
    private Button mUploadButton;
    private Button mSettingsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_syllabye);

        mCalendarButton = (Button) findViewById(R.id.calendar_button);
        mCalendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start CalendarActivity
                Intent intent = new Intent(SyllabyeActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });
        mRemindersButton = (Button) findViewById(R.id.reminders_button);
        mRemindersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start RemindersActivity
                Intent intent = new Intent(SyllabyeActivity.this, RemindersActivity.class);
                startActivity(intent);
            }
        });
        mUploadButton = (Button) findViewById(R.id.upload_button);
        mUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start UploadActivity
                Intent intent = new Intent(SyllabyeActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });
        mSettingsButton = (Button) findViewById(R.id.settings_button);
        mSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start SettingsActivity
                Intent intent = new Intent(SyllabyeActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}
