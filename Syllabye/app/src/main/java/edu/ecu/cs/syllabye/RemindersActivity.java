package edu.ecu.cs.syllabye;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RemindersActivity extends AppCompatActivity {
    Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);


        mBackButton = (Button) findViewById(R.id.back);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Back Button
                Intent intent = new Intent(RemindersActivity.this, SyllabyeActivity.class);
                startActivity(intent);
            }

        });
    }
}
