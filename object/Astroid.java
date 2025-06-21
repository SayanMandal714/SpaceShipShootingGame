package core.object;
import core.*;
import core.Window;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Astroid  implements Renderable,Movement{
    BufferedImage img = ImageIO.read(new File("img/A2.png"));

    private static Random rn=new Random();
    private static int hight=70;
    private static int width=60;
    private int layer=2;

    public static int getHight() {
        return hight;
    }
    public static int getWidth(){return width;}
@Override
    public int get_Width() {
        return width;
    }

    @Override
    public int get_Height() {
        return hight;
    }


    private double speed=100;
    private double x;
    private double y;
    private  Rectangle rect;
    private int gapy;
    public Astroid(int x,int y,Rectangle rect,int gapy) throws IOException, InterruptedException {
        this.x=x;
        this.y=y;
        this.rect=rect;
        this.gapy=gapy;
        Astroidspawn.addRect(this.rect);
        Render.addRender(this);
        Movable.add(this);

    }

    public Rectangle getRect() {
        return rect;
    }

    @Override
    public void draw(Graphics2D g) throws InterruptedException {

        g.drawImage(img,(int)x,(int)y,width,hight,null);
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public int getX() {
        return (int) x;
    }

    @Override
    public int getY() {
        return (int) y;
    }

    @Override
    public void move() {
        y+=speed*GameTime.getDaltaTime();
        rect.y= (int) (y+gapy);

        if(y>=Window.get_Height()){
            Render.removeRender(this);
            Movable.remove(this);
            Astroidspawn.removeRect(this.rect);
        }

    }


    @Override
    public String getID() {
        return "eship";
    }

    @Override
    public Renderable getRengerable() {
        return this;
    }

    @Override
    public Astroid getAstroid() {
        return this;
    }
}
