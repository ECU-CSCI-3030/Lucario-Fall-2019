package edu.ecu.cs.syllabye;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class TesseractActivity extends AppCompatActivity {

    private Context context;
    int PERMISSION_ALL = 1;
    boolean flagPermissions = false;

    String [] PERMISSIONS = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tesseract);
    }

    void checkPermissions() {
        if (!hasPermissions(context, PERMISSIONS)) {
            requestPermissions(PERMISSIONS, PERMISSION_ALL);
            flagPermissions = false;
        }
        flagPermissions = true;
    }

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission)
                        != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

}
