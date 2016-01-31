package main.java.objects;

import java.io.Serializable;

/**
 * Created by Henry on 31/01/2016.
 */
public class RenderableObject implements Serializable {
    private Vertex3[] vertices;
    private Vertex3[] colors;
    private Vertex3[] txcoords;
    private float xCoordinate;
    private float yCoordinate;

    public RenderableObject(Vertex3[] vertices,Vertex3[] colors,Vertex3[] txcoords, float x, float y){
        if(vertices.length != colors.length || vertices.length != txcoords.length){
            throw new IllegalArgumentException("Arrays must be of the same length");
        }

        this.vertices = vertices;
        this.colors = colors;
        this.txcoords = txcoords;

        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public float getXCoordinate(){
        return xCoordinate;
    }

    public float getYCoordinate(){
        return yCoordinate;
    }

    public Vertex3[] getVertices(){
        return vertices;
    }

    public Vertex3[] getColors(){
        return colors;
    }

    public Vertex3[] getTXCoords(){
        return txcoords;
    }
}
