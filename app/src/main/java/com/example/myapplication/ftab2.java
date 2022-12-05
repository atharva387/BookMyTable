package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class ftab2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ftab2, container, false);
        ImageButton I1 = (ImageButton) view.findViewById(R.id.menuim1);

        I1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Bevmenu.class);
                startActivity(i);
            }
        });
        ImageButton I2 = (ImageButton) view.findViewById(R.id.menuim2);

        I2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), indianmenu.class);
                startActivity(i);
            }
        });
        ImageButton I3 = (ImageButton) view.findViewById(R.id.menuim3);

        I3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), chinesemenu.class);
                startActivity(i);
            }
        });
        ImageButton I4 = (ImageButton) view.findViewById(R.id.menuim4);

        I4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), hobspmenu.class);
                startActivity(i);
            }
        });

        // Inflate the layout for this fragment);
        return view;

    }
}