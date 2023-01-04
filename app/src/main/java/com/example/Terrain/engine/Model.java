package com.example.Terrain.engine;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private ArrayList<ComplexPoint> pointArray;
    private final int rows = 100;
    private final int colomns = 100;
    private final float zMax = 2.0f;
    private String renderParam;
    protected final Terrain terrain;

    public String getRenderParam() {
        return renderParam;
    }

    public Model() {
        pointArray = new ArrayList<>();
        terrain = new Terrain(100);
        //renderParam=new String("grid");
        renderParam=new String("Terrain");
        pointArray.add(new ComplexPoint(0.0f,0.0f,1.0f));

    }

    // Add Random point into ArrayList
    public void update(long elapsedTime) {

    }

    // Return full ArrayList of points
    public List<ComplexPoint> getTerrainList() {
        return this.terrain.toPoints();
    }

}
