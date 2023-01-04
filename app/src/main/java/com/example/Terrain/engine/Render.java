package com.example.Terrain.engine;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;

import java.util.Iterator;

public class Render {
    private final Paint paint;

    public Render(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private void cls(Canvas canvas){
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.DKGRAY);
        canvas.drawRect(0.0f,0.0f,canvas.getWidth(),canvas.getHeight(),this.paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setColor(Color.BLACK);
        canvas.drawRect(0.0f,0.0f,canvas.getWidth(),canvas.getHeight(),this.paint);
    }

    public void draw(Canvas canvas,Model model){
        this.cls(canvas);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6.0f);
        paint.setColor(Color.WHITE);
        paint.setTextSize(25);

        // For each statement below
        ComplexPoint pCp = null;
        for (int i = 0;i<model.getTerrainList().size();i++) {
            pCp = model.getTerrainList().get(i);
            Point point = pCp.translatePointToScreen(canvas.getWidth(), canvas.getHeight());

            if(pCp.getParam()==1) paint.setColor(Color.RED);
            else paint.setColor(Color.WHITE);

            paint.setStrokeWidth(10);
            canvas.drawPoint(point.x, point.y, paint);
            paint.setStrokeWidth(1);
            //canvas.drawText(String.valueOf(i),point.x+6.0f,point.y,paint);
            //canvas.drawText(pCp.toString(),point.x+6.0f,point.y,paint);
        }

    }

    public void drawComplexPoint(ComplexPoint point){

    }
}
