package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;



import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.ScanIntentResult;

public class menu extends AppCompatActivity {
    private TextView textView;
    private EditText editText;
    private ImageView imageView;
    private ScrollView scrollView;
    private RecyclerView recyclerView;

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button b1 = (Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b1.setVisibility(View.INVISIBLE);
            }
        });
        Button b4 = (Button) findViewById(R.id.button4);
        Button b3 = (Button) findViewById(R.id.button3);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=count+1;
                b3.setText(Integer.toString(count));
            }
        });
        Button b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count!=0){count=count-1;}
                b3.setText(Integer.toString(count));
            }
        });
    }

}