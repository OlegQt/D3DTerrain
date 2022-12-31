package com.example.Terrain.engine;

import java.util.ArrayList;

public class Model {
    private ArrayList<ComplexPoint> pointArray;
    private final int rows = 100;
    private final int colomns = 100;
    private final float zMax = 2.4f;

    public Model() {
        pointArray = new ArrayList<>();

        //pointArray.add(new ComplexPoint(0.5f,0.0f,1.0f));
        float xStep = 1.0f / rows;
        float yStep = 1.0f / colomns;
        float zStep = zMax/(float)colomns;

        ComplexPoint pCp = null;
        for (int x = -rows; x <= rows; x++) {
            for (int y = 0; y <= colomns; y++) {
                pCp = new ComplexPoint(x * xStep, -y * yStep, zMax-(y*zStep));
                pointArray.add(pCp);
            }

        }
        xStep = 0;
    }

    // Add Random point into ArrayList
    public void update(long elapsedTime) {

    }

    // Return full ArrayList of points
    public ArrayList<ComplexPoint> getPointsArray() {
        return this.pointArray;
    }
}
