package core;

import java.awt.*;

public interface Renderable extends Comparable<Object> {
    void draw(Graphics2D g) throws InterruptedException;
    int getLayer();
    int getX();
    int getY();
    int get_Width();
    int get_Height();
    @Override
   default int compareTo(Object obj){
       Renderable o=(Renderable) obj;
        if(this.getLayer()<o.getLayer())return -1;
        else if(this.getLayer()>o.getLayer()) return 1;
        else return 0;
    }

}
