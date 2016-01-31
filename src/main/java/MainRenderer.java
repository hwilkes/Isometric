package main.java;
import main.java.objects.RenderableObject;
import main.java.objects.Vertex3;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainRenderer {

    private List<RenderableObject> objs;

    private long lastFPS;
    private long fps;
    private long lastFrame;

    private float xrotation = 0;
    private float yrotation = 0;
    private float zrotation = 0;

    private final float xrotationspeed = 0.1f;
    private final float yrotationspeed = 1f;
    private final float zrotationspeed = 0.1f;


    public long getTime() {
        return System.nanoTime() / 1000000;
    }

    private void setupVertices(){
        objs = new ArrayList<RenderableObject>();

        Vertex3[] v = new Vertex3[24];
//        v[0] = new Vertex3(0,0,0);
//        v[1] = new Vertex3(100,0,0);
//        v[2] = new Vertex3(100,100,0);
//        v[3] = new Vertex3(0,100,0);
//
//        v[4] = new Vertex3(0,100,100);
//        v[5] = new Vertex3(0,100,0);
//        v[6] = new Vertex3(0,0,0);
//        v[7] = new Vertex3(0,0,100);
//
//        v[8] = new Vertex3(0,0,0);
//        v[9] = new Vertex3(100,0,0);
//        v[10] = new Vertex3(100,0,100);
//        v[11] = new Vertex3(0,0,100);
//
//        v[12] = new Vertex3(0,100,100);
//        v[13] = new Vertex3(0,100,0);
//        v[14] = new Vertex3(100,100,0);
//        v[15] = new Vertex3(100,1000,100);
//
//        v[16] = new Vertex3(100,100,0);
//        v[17] = new Vertex3(100,0,0);
//        v[18] = new Vertex3(100,0,100);
//        v[19] = new Vertex3(100,100,100);
//
//        v[20] = new Vertex3(0,100,100);
//        v[21] = new Vertex3(0,0,100);
//        v[22] = new Vertex3(100,0,100);
//        v[23] = new Vertex3(100,100,100);
//
         Vertex3[] c = new Vertex3[24];
//        c[0] = new Vertex3(0.0f,0.0f,0.0f);
//        c[1] = new Vertex3(1.0f,1.0f,0.0f);
//        c[2] = new Vertex3(0.0f,0.0f,0.0f);
//        c[3] = new Vertex3(1.0f,1.0f,0.0f);
//        c[4] = new Vertex3(0.0f,0.0f,0.0f);
//        c[5] = new Vertex3(1.0f,1.0f,0.0f);
//        c[6] = new Vertex3(0.0f,0.0f,0.0f);
//        c[7] = new Vertex3(1.0f,1.0f,0.0f);
//        c[8] = new Vertex3(0.0f,0.0f,0.0f);
//        c[9] = new Vertex3(1.0f,1.0f,0.0f);
//        c[10] = new Vertex3(0.0f,0.0f,0.0f);
//        c[11] = new Vertex3(1.0f,1.0f,0.0f);
//        c[12] = new Vertex3(0.0f,0.0f,0.0f);
//        c[13] = new Vertex3(1.0f,1.0f,0.0f);
//        c[14] = new Vertex3(0.0f,0.0f,0.0f);
//        c[15] = new Vertex3(1.0f,1.0f,0.0f);
//        c[16] = new Vertex3(0.0f,0.0f,0.0f);
//        c[17] = new Vertex3(1.0f,1.0f,0.0f);
//        c[18] = new Vertex3(0.0f,0.0f,0.0f);
//        c[19] = new Vertex3(1.0f,1.0f,0.0f);
//        c[20] = new Vertex3(0.0f,0.0f,0.0f);
//        c[21] = new Vertex3(1.0f,1.0f,0.0f);
//        c[22] = new Vertex3(0.0f,0.0f,0.0f);
//        c[23] = new Vertex3(1.0f,1.0f,0.0f);

        c[0] = new Vertex3(1.0f,1.0f,0.0f);
        c[1] = new Vertex3(1.0f,1.0f,0.0f);
        c[2] = new Vertex3(1.0f,1.0f,0.0f);
        c[3] = new Vertex3(1.0f,1.0f,0.0f);
        v[0] = new Vertex3(1.0f, 1.0f,-1.0f);
        v[1] = new Vertex3(-1.0f, 1.0f,-1.0f);
        v[2] = new Vertex3(-1.0f, 1.0f, 1.0f);
        v[3] = new Vertex3( 1.0f, 1.0f, 1.0f);


        c[4] = new Vertex3(1.0f,0.5f,0.0f);
        c[5] = new Vertex3(1.0f,0.5f,0.0f);
        c[6] = new Vertex3(1.0f,0.5f,0.0f);
        c[7] = new Vertex3(1.0f,0.5f,0.0f);
        v[4] = new Vertex3( 1.0f,-1.0f, 1.0f);
        v[5] = new Vertex3(-1.0f,-1.0f, 1.0f);
        v[6] = new Vertex3(-1.0f,-1.0f,-1.0f);
        v[7] = new Vertex3( 1.0f,-1.0f,-1.0f);

        c[8] = new Vertex3(1.0f,0.5f,0.0f);
        c[9] = new Vertex3(1.0f,0.5f,0.0f);
        c[10] = new Vertex3(1.0f,0.5f,0.0f);
        c[11] = new Vertex3(1.0f,0.5f,0.0f);
        v[8] = new Vertex3( 1.0f, 1.0f, 1.0f);
        v[9] = new Vertex3(-1.0f, 1.0f, 1.0f);
        v[10] = new Vertex3(-1.0f,-1.0f, 1.0f);
        v[11] = new Vertex3( 1.0f,-1.0f, 1.0f);

        c[12] = new Vertex3(1.0f,1.0f,0.0f);
        c[13] = new Vertex3(1.0f,1.0f,0.0f);
        c[14] = new Vertex3(1.0f,1.0f,0.0f);
        c[15] = new Vertex3(1.0f,1.0f,0.0f);
        v[12] = new Vertex3( 1.0f,-1.0f,-1.0f);
        v[13] = new Vertex3(-1.0f,-1.0f,-1.0f);
        v[14] = new Vertex3(-1.0f, 1.0f,-1.0f);
        v[15] = new Vertex3( 1.0f, 1.0f,-1.0f);

        c[16] = new Vertex3(1.0f,1.0f,0.0f);
        c[17] = new Vertex3(1.0f,1.0f,0.0f);
        c[18] = new Vertex3(1.0f,1.0f,0.0f);
        c[19] = new Vertex3(1.0f,1.0f,0.0f);
        v[16] = new Vertex3(-1.0f, 1.0f, 1.0f);
        v[17] = new Vertex3(-1.0f, 1.0f,-1.0f);
        v[18] = new Vertex3(-1.0f,-1.0f,-1.0f);
        v[19] = new Vertex3(-1.0f,-1.0f, 1.0f);

        c[20] = new Vertex3(1.0f,0.0f,1.0f);
        c[21] = new Vertex3(1.0f,0.0f,1.0f);
        c[22] = new Vertex3(1.0f,0.0f,1.0f);
        c[23] = new Vertex3(1.0f,0.0f,1.0f);
        v[20] = new Vertex3( 1.0f, 1.0f,-1.0f);
        v[21] = new Vertex3( 1.0f, 1.0f, 1.0f);
        v[22] = new Vertex3( 1.0f,-1.0f, 1.0f);
        v[23] = new Vertex3( 1.0f,-1.0f,-1.0f);

        Vertex3[] t = new Vertex3[24];

        RenderableObject ob = new RenderableObject(v,c,t,400,300);

        objs.add(ob);
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

//    private void render() {
//        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
//        GL11.glLoadIdentity();
//
//        GL11.glTranslatef(0f,0.0f,-7f);
//        GL11.glRotatef(45f,0.0f,1.0f,0.0f);
//        GL11.glColor3f(0.5f,0.5f,1.0f);
//
//        GL11.glBegin(GL11.GL_QUADS);
//        GL11.glColor3f(1.0f,1.0f,0.0f);
//        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
//        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
//        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
//        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
//        GL11.glColor3f(1.0f,0.5f,0.0f);
//        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
//        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
//        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
//        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
//        GL11.glColor3f(1.0f,0.0f,0.0f);
//        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
//        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
//        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
//        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
//        GL11.glColor3f(1.0f,1.0f,0.0f);
//        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
//        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
//        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
//        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
//        GL11.glColor3f(0.0f,0.0f,1.0f);
//        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
//        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
//        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
//        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
//        GL11.glColor3f(1.0f,0.0f,1.0f);
//        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
//        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
//        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
//        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
//        GL11.glEnd();
//
//    }

    private void render(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        GL11.glColor3f(0.5f, 0.5f, 1.0f);

        Iterator<RenderableObject> iter = objs.iterator();
        Vertex3[] v;
        Vertex3[] c;
        RenderableObject o;


        while(iter.hasNext()) {
            GL11.glPushMatrix();
            o = iter.next();

            GL11.glTranslatef(400, 200, 0);
            GL11.glRotatef(45f,0.0f,1.0f,0.0f);
            //GL11.glRotatef(yrotationspeed, 0f, 1f, 0f);
            //GL11.glRotatef(zrotationspeed, 0f, 0f, 1f);

            v = o.getVertices();
            c = o.getColors();
            GL11.glBegin(GL11.GL_QUADS);

            for(int i = 0; i < v.length; i++){
                GL11.glVertex3f(v[i].one,v[i].two,v[i].three);
                GL11.glColor3f(c[i].one,c[i].two,c[i].three);
            }
            GL11.glEnd();

            GL11.glPopMatrix();
        }

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

        // init OpenGL
//        GL11.glMatrixMode(GL11.GL_PROJECTION);
//        GL11.glLoadIdentity();
//        GL11.glOrtho(0, 1024, 0, 768, 1, -1);
//        GL11.glMatrixMode(GL11.GL_MODELVIEW);
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