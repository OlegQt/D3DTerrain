package com.example.Terrain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import com.example.Terrain.engine.Engine;

import java.util.Locale;

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

        engine = new Engine(surface);

        surface.setOnTouchListener((view, motionEvent) -> {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            String strPosition = "X=%.1f  Y=%.1f";
            strPosition = String.format(Locale.getDefault(), strPosition, x, y);
            txtInfo.setText(strPosition);
            return false;
        });
    }


    @Override
    protected void onDestroy() {
        engine.stop(true);
        super.onDestroy();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }


}