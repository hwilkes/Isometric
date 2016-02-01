package main.java;
import main.java.objects.RenderableObject;
import main.java.objects.Vertex3;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainRenderer {

    //private List<RenderableObject> objs;

    private FloatBuffer vertices;

    private long lastFPS;
    private long fps;
    private long lastFrame;

    private float xrotation = 0;
    private float yrotation = 0;
    private float zrotation = 0;

    private final float xrotationspeed = 0.01f;
    private final float yrotationspeed = 0.01f;
    private final float zrotationspeed = 0.1f;


    public long getTime() {
        return System.nanoTime() / 1000000;
    }

    private void setupVertices(){
        vertices = BufferUtils.createFloatBuffer(3 * 4 * 6);

        vertices.put(new float[] {
                -1.0f, -1.0f, 1.0f,
                1.0f, -1.0f, 1.0f,
                1.0f, 1.0f, 1.0f,
                -1.0f, 1.0f, 1.0f,

                -1.0f, -1.0f, -1.0f,
                -1.0f, 1.0f, -1.0f,
                1.0f, 1.0f, -1.0f,
                1.0f, -1.0f, -1.0f,

                -1.0f, 1.0f, -1.0f,
                -1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, -1.0f,

                -1.0f, -1.0f, -1.0f,
                1.0f, -1.0f, -1.0f,
                1.0f, -1.0f, 1.0f,
                -1.0f, -1.0f, 1.0f,

                1.0f, -1.0f, -1.0f,
                1.0f, 1.0f, -1.0f,
                1.0f, 1.0f, 1.0f,
                1.0f, -1.0f, 1.0f,

                -1.0f, -1.0f, -1.0f,
                -1.0f, -1.0f, 1.0f,
                -1.0f, 1.0f, 1.0f,
                -1.0f, 1.0f, -1.0f});

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

        xrotation += xrotationspeed * d;
        yrotation += yrotationspeed * d;
        zrotation += zrotationspeed * d;

        updateFPS();
    }

    public int getDelta() {
        long time = getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;

        return delta;
    }

    private void render() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT); // Clear The Screen And The Depth Buffer
        GL11.glPushMatrix();
        //GL11.glLoadIdentity(); // Reset The Current Modelview Matrix

        GL11.glTranslatef(0.0f, 0.0f, -5);
        GL11.glRotatef(xrotation, 1.0f, 0.0f, 0.0f); // Rotate On The X Axis
        GL11.glRotatef(yrotation, 0.0f, 1.0f, 0.0f); // Rotate On The Y Axis
        GL11.glRotatef(zrotation, 0.0f, 0.0f, 1.0f); // Rotate On The Z Axis
        GL11.glColor3f(1.0f, 1.0f, 1.0f);

        // Enable vertex arrays
        GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        // Setup vertex array pointer
        vertices.rewind();
        GL11.glVertexPointer(3, 0, vertices);
        // Draw using vertex array
        GL11.glDrawArrays(GL11.GL_QUADS, 0, 24);
        // Disable vertex arrays
        GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
        GL11.glPopMatrix();
    }


//    private void render(){
//        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
//
//        GL11.glColor3f(0.5f, 0.5f, 1.0f);
//
//        Iterator<RenderableObject> iter = objs.iterator();
//        Vertex3[] v;
//        Vertex3[] c;
//        RenderableObject o;
//
//
//        while(iter.hasNext()) {
//            GL11.glPushMatrix();
//            o = iter.next();
//
//            GL11.glTranslatef(400, 200, 0);
//            GL11.glRotatef(45f,0.0f,1.0f,0.0f);
//            //GL11.glRotatef(yrotationspeed, 0f, 1f, 0f);
//            //GL11.glRotatef(zrotationspeed, 0f, 0f, 1f);
//
//            v = o.getVertices();
//            c = o.getColors();
//            GL11.glBegin(GL11.GL_QUADS);
//
//            for(int i = 0; i < v.length; i++){
//                GL11.glVertex3f(v[i].one,v[i].two,v[i].three);
//                GL11.glColor3f(c[i].one,c[i].two,c[i].three);
//            }
//            GL11.glEnd();
//
//            GL11.glPopMatrix();
//        }
//
//    }

    private void loop(){
        while (!Display.isCloseRequested()) {
            int delta = getDelta();
            update(delta);
            render();

            Display.update();
            Display.sync(60);
        }
    }

    private void InitGL() {
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1.0);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();


        GLU.gluPerspective(
                45.0f,
                (float)1024/(float)768,
                0.1f,
                100.0f);

        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        GL11.glHint(GL11.GL_PERSPECTIVE_CORRECTION_HINT, GL11.GL_NICEST);
    }

    public void start() {
        lastFPS = getTime();
        setupVertices();
        try {
            Display.setDisplayMode(new DisplayMode(800,600));
            Display.create();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        InitGL();

        getDelta();
        loop();

        Display.destroy();
    }

    public static void main(String[] argv) {
        MainRenderer mainRenderer = new MainRenderer();
        mainRenderer.start();
    }
}