package core.object;
import core.Window;
import core.object.*;
import core.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bullet implements Renderable,Movement{
    BufferedImage img= ImageIO.read(new File("img/bullet.png"));
    private static int witdh= 50;
    private static int height= 65;
    private int layer=1;
    private double speed=300;
    static double x=0;
    static double y=0;

    public Bullet(int x,int y) throws IOException {
        this.x=x;
        this.y=y;
        Render.bultetRefiling(this,20);
        Movable.add(this);
    }

    @Override
    public void draw(Graphics2D g) throws InterruptedException {
g.drawImage(img,(int)x,(int)y,witdh,height,null);
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
    public int get_Width() {
        return witdh;
    }

    @Override
    public int get_Height() {
        return height;
    }

    @Override
    public void move() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        y-=speed*GameTime.getDaltaTime();
        if(y<-Window.get_Height()){
            Render.removeRender(this);
            Render.removeBullet(this);
            Movable.remove(this);

        }
        Movement collidingobj= isColliding(this,"eship");
        if(collidingobj!=null){
            Render.removeRender(collidingobj.getRengerable());
            Movable.remove(collidingobj);
            Render.removeRender(this);
            Render.removeBullet(this);
            Movable.remove(this);
            if(collidingobj.getAstroid()!=null){
                Astroidspawn.removeRect(collidingobj.getAstroid().getRect());
            }
    }
    }

    @Override
    public String getID() {
        return "Bullet";
    }

    @Override
    public Renderable getRengerable() {
        return this;
    }

    @Override
    public Astroid getAstroid() {
        return null;
    }
}
