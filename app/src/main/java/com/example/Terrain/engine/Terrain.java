package com.example.Terrain.engine;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Terrain {
    protected List<ComplexPoint> grid;
    private int rowCount;

    public Terrain(int rowCount) {
        this.rowCount = rowCount;
        float deep = 0.5f;
        grid = new ArrayList<>();
        float step = 1.0f / (rowCount - 1);
        for (int y = 0; y < rowCount; y++) {
            for (int x = 0; x < rowCount; x++) {
                grid.add(new ComplexPoint(x * step - 0.5f, y * step - 0.5f, 1.0f));
            }
            deep+=0.01f;
        }
        //grid.get(75).param = 1;
    }

    public List<ComplexPoint> toPoints() {
        return this.grid;
    }

    @NonNull
    @Override
    public String toString() {
        Iterator<ComplexPoint> iter = this.grid.iterator();
        ComplexPoint pCp = null;
        String str = "";
        int stroke = 0;
        while (iter.hasNext()) {
            pCp = iter.next();
            str = str.concat(pCp.toString());
            stroke++;
            if (stroke == this.rowCount) {
                stroke = 0;
                str = str.concat("\n");
            }

        }
        return str;
    }

    public void onTouch(float x, float y) {
        for (ComplexPoint pCp : grid) {

            float distance = pCp.getDistance(x-0.5f, y+0.5f);
            if (distance < 0.1f) {
                pCp.param = 1;
                pCp.z-=0.003f;
            }
            else pCp.param = 0;
        }

    }
}
