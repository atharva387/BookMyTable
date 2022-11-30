package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class homepage extends AppCompatActivity {
    public Button button;
    Spinner spinner;
    String[] area = {
            "Select Area",
            "Kothroud",
            "Karvenagar",
            "Erandwane",
            "Sinhgad Road",
            "Bavdhan",
            "Baner",
            "Viman Nagar",
            "Balewadi",
            "Magarpatta",
            "koregaon park",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageButton imageButton;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        spinner = findViewById(R.id.areaspin);
        button =findViewById(R.id.hotelBookButton);
        ImageButton ib1 = (ImageButton) findViewById(R.id.ib1);
        MaterialButton hotelBookButton =(MaterialButton) findViewById(R.id.hotelBookButton);
        hotelBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(homepage.this,HobInfo.class);
                startActivity(intent);
            }
        });
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                scanCode();
            }
        });
        ArrayAdapter < String > adapter = new ArrayAdapter < String > (this,
                android.R.layout.simple_list_item_activated_1, area);
        spinner.setAdapter(adapter);

        adapter.setDropDownViewResource(R.layout.spinnerlayout);
        spinner.setAdapter(adapter);

    }

    private void scanCode() {
        ScanOptions options = new ScanOptions();
        options.setPrompt("VOLUME UP TO TURN ON THE FLASH");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }
    ActivityResultLauncher < ScanOptions > barLauncher = registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(homepage.this);

            if (result.getContents().equals("01")) {
                builder.setTitle("This bill is for Table No ");

                // builder.setTitle("Result");
                builder.setPositiveButton("BTake me to Cafe menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent resultintent = new Intent(homepage.this, menu.class);
                        resultintent.putExtra("result", result.getContents());
                        startActivity(resultintent);
                    }
                }).show();

                //Intent intent=new Intent(homepage.this,signup.class);
                //startActivity(intent);
            } else if (result.getContents().equals("02")) {
                builder.setTitle("This bill is for Table No 2");
                // builder.setTitle("Result");
                builder.setPositiveButton("Take me to Cafe menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent resultintent = new Intent(homepage.this, menu.class);
                        resultintent.putExtra("result", result.getContents());
                        startActivity(resultintent);
                    }
                }).show();

            } else {
                builder.setTitle("This qr code is invalid");
                // builder.setTitle("Result");
                builder.setPositiveButton("Invalid code Please try again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(homepage.this, homepage.class);
                        startActivity(intent);
                    }
                }).show();
                //  Intent intent=new Intent(homepage.this,Login.class);
                // startActivity(intent);
            }
        }
    });


}