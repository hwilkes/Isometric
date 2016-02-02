package main.java.game;

import main.java.game.graphics.IsoMapRenderer;
import main.java.game.map.IsoMap;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

/**
 * Created by Henry on 02/02/2016.
 */
public class GameInstance {

    private IsoMap map;
    private IsoMapRenderer renderer;

    private long lastFPS;
    private long fps;
    private long lastFrame;
    private float rotation = 0;

    float x = 400, y = 300;

    private final int xSize = 1024;
    private final int ySize = 768;

    public GameInstance(){
        map = new IsoMap(10,10);
    }

    public long getTime() {
        return System.nanoTime() / 1000000;
    }

    private void updateFPS() {
        if (getTime() - lastFPS > 1000) {
            Display.setTitle("FPS: " + fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
    }

    private void update(int d){
        int x = Mouse.getX();
        int y = Mouse.getY();

        rotation += 0.15f * d;

        //System.out.println("X: "+x+" Y: "+y);

        updateFPS();
    }

    public int getDelta() {
        long time = getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;

        return delta;
    }


    private void loop(){
        while (!Display.isCloseRequested()) {
            int delta = getDelta();
            update(delta);
            render();

            Display.update();
            Display.sync(60);
        }
    }

    public void start() {
        lastFPS = getTime();

        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        // init OpenGL
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 800, 0, 600, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        getDelta();
        loop();

        Display.destroy();
    }

    public static void main(String[] argv) {
        //GameInstance game = new GameInstance();
        //game.start();
    }
}
