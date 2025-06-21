package core;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;

public class Render extends JPanel {
    private static ArrayList<Renderable>render=new ArrayList<>();
    private static ArrayList<Renderable>newrender=new ArrayList<>();
    private static ArrayList<Renderable>removerender=new ArrayList<>();
    private static ArrayList<Renderable>bullets=new ArrayList<>();
    private static ArrayList<Renderable>newbullets=new ArrayList<>();
   private  int limit;
    public Dimension getPreferredSize() {
        return new Dimension((int)Window.get_Width(), (int) Window.get_Height());
    }

    public static void addRender(Renderable o){
        newrender.add(o);
    }

    public static void bultetRefiling(Renderable o, int limit){
        if(newbullets.size()<=limit){
        newbullets.add(o);
    }
    }
    public static void removeRender(Renderable o){
        removerender.add(o);
    }
    public static void removed(Renderable o){
        render.remove(o);
    }
    public static void removeBullet(Renderable o){
        bullets.remove(o);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // clears the panel
        Graphics2D g2 = (Graphics2D) g;
for(Renderable obj:render) {
    try {
        obj.draw(g2);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
        render.removeAll(removerender);
        removerender.clear();
        render.addAll(newrender);
        if (bullets.isEmpty()) {
            bullets.addAll(newbullets);
            newbullets.clear();
           render.addAll(bullets);
        }
        if(render.size()>0)Collections.sort(render);
        newrender.clear();


    }
}
