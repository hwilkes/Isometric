package main.java.objects;

import java.io.Serializable;

/**
 * Created by Henry on 30/01/2016.
 */
public class Vertex3 implements Serializable {
    public float one;
    public float two;
    public float three;

    public Vertex3(float one, float two, float three){
        this.one = one;
        this.two = two;
        this.three = three;
    }
}
