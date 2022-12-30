package com.example.surfviewvectors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.example.surfviewvectors.engine.Engine;
import com.example.surfviewvectors.engine.Model;

public class MainActivity extends AppCompatActivity {
    Engine engine;
    SurfaceView surface;
    TextView txtInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        surface = findViewById(R.id.surface);
        txtInfo = findViewById(R.id.txt_info);

        engine=new Engine(surface);

        surface.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtInfo.setText("Click");
            }
        });
        surface.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                txtInfo.setText("Long Click");
                return false;
            }
        });

    }

    @Override
    protected void onDestroy() {
        engine.stop(true);
        super.onDestroy();
    }
}