package main.java.game.graphics;

import main.java.game.map.IsoMap;

import java.awt.*;

/**
 * Created by Henry on 02/02/2016.
 */
public class IsoMapRenderer {

    private IsoMap map;

    private Dimension screenSize;

    public float[] getHexVertices(){
        return new float[] {
            0.25f, 0.0f,
            0.75f, 0.0f,
            1.0f, 0.5f,
            0.75f, 1.0f,
            0.25f, 1.0f,
            0.0f, 0.5f
        };
    }

    private IsoMapRenderer(IsoMap map,Dimension screenSize){
        this.map = map;
        this.screenSize = screenSize;
    }

    public IsoMap getMap(){
        return map;
    }

    public Dimension getScreenSize(){
        return screenSize;
    }

}
