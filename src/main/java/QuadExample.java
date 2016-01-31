package main.java;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class QuadExample {

    

    private long lastFPS;
    private long fps;
    private long lastFrame;
    private float rotation = 0;

    float x = 400, y = 300;

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

    private void render(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        GL11.glColor3f(0.5f, 0.5f, 1.0f);

        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 0);
        GL11.glRotatef(rotation, 0f, 0f, 1f);
        GL11.glTranslatef(-x, -y, 0);

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x - 50, y - 50);
        GL11.glVertex2f(x + 50, y - 50);
        GL11.glVertex2f(x + 50, y + 50);
        GL11.glVertex2f(x - 50, y + 50);

        //GL11.glVertex3f();

        GL11.glEnd();
        GL11.glPopMatrix();
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
        QuadExample quadExample = new QuadExample();
        quadExample.start();
    }
}