package com.example.Terrain.engine;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.PointF;

import androidx.annotation.NonNull;

import java.util.Locale;

public class ComplexPoint extends PointF {
    protected float z;

    public ComplexPoint(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public Point translatePointToScreen(float W, float H) {
        float hW = W / 2;
        float hH = H / 2;
        // Учет расстояния от точки до экрана
        float xPos = x / z;
        float yPos = y / z;
        // Транслирование координат точки на плоскость экрана
        xPos = xPos * W + hW;
        yPos = hH - yPos * H;
        return new Point((int) xPos, (int) yPos);
    }

    public static Point translatePointToScreen(ComplexPoint point, float hW, float hH) {
        return point.translatePointToScreen(hW, hH);
    }

    @NonNull
    @Override
    public String toString() {
        return String.format(Locale.getDefault(),"[%.1f ; %.1f] ",x,y);
        //return super.toString();
    }
}
