package core.object;
import core.*;
import core.Window;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class Background implements Renderable,Movement {
    BufferedImage img= ImageIO.read(new File("img/s1.jpg"));

    private static int witdh= (int) Window.get_Width();
    private static int height=  (int) (Window.get_Height()*2);
    private int layer=0;
    private double speed=400;
    static double y=0;

    public Background(int y) throws IOException {
        this.y=y;
        Render.addRender(this);
        Movable.add(this);
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public int getX() {
        return 0;
    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int get_Width() {
        return witdh;
    }

    @Override
    public int get_Height() {
        return height;
    }

    @Override
    public void draw(Graphics2D g) throws InterruptedException {

        g.drawImage(img,0, (int) y,witdh,height,null);


    }

    @Override
    public void move() {
        int h=Window.get_Height();
        y+= speed*GameTime.getDaltaTime();

        if(y>0)y=-h;
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public Renderable getRengerable() {
        return null;
    }

    @Override
    public Astroid getAstroid() {
        return null;
    }
}
