package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.myapplication.R.id.recycler2;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String result = getIntent().getExtras().get("result").toString();
        TextView textView1 = (TextView) findViewById(R.id.text1);
        TextView textView2 = (TextView) findViewById(R.id.text2);
        TextView textView3 = (TextView) findViewById(R.id.text3);
        TextView textView4 = (TextView) findViewById(R.id.text4);
        TextView textView5 = (TextView) findViewById(R.id.text5);
        TextView textView6 = (TextView) findViewById(R.id.text6);
        EditText editText1 = (EditText) findViewById(R.id.edittext1);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView1);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(recycler2);
        textView.setText("Table No" + result);

    }

}