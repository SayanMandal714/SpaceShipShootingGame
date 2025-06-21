package core;

import core.object.Astroid;
import core.object.Audio;
import core.object.Bullet;
import core.object.gTimer;


import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;


public class SpaceShip implements Renderable,Movement{
    BufferedImage img= ImageIO.read(new File("img/ship.png"));
    private static double x,y;
    private static final int witdh=85;
    private static int height=75;
    private int layer=2;
    private double speed=200;
    private gTimer timer=new gTimer(300);
    public static int getWitdh() {
        return witdh;
    }

    public static int getHeight() {
        return height;
    }


    public SpaceShip(int x,int y) throws IOException {
        this.x=x;
        this.y=y;
    }

    @Override
    public void draw(Graphics2D g) {

        g.drawImage(img, (int) x, (int) y,witdh,height,null);
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


    public int get_Width() {
        return witdh;
    }

    @Override
    public int get_Height() {
        return height;
    }

    @Override
    public void move() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
        if(Key.keys[Key.down]&&y<=Window.get_Height()-height){
            this.y+=speed*GameTime.getDaltaTime();

        }
        if (Key.keys[Key.right] && x <= Window.get_Width() -witdh){
            this.x+=speed*GameTime.getDaltaTime();
        }
        if(Key.keys[Key.left]&&x>=0){
           this.x-=speed*GameTime.getDaltaTime();
        }
        if(Key.keys[Key.up] &&y>=0){
            this.y-=speed*GameTime.getDaltaTime();
        }
        if(Key.keys[Key.space]&& timer.isRinging()){
            new Bullet((int)(x+20), (int) y);
            Audio.playSound("img/shot.wav");
        }else {
            Key.keys[Key.space]=false;
            timer.reset();
        }
        Movement collidingobj= isColliding(this,"eship");
        if(collidingobj!=null){
            Audio.playSound("img/collide.wav");
    Render.removeRender(collidingobj.getRengerable());
    Movable.remove(collidingobj);
    Render.removeRender(this);
    Movable.remove(this);

        }
    }

    @Override
    public String getID() {
        return "ship";
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
