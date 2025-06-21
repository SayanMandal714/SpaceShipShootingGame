package core;

import java.awt.*;
import core.object.*;
import java.io.IOException;


import core.object.Astroid;
import core.object.Background;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Entry {
    public static void main(String[] args) throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {

        Window window=new Window("Space Game");
       window.setBackground(new Color(0,0,139));
        Render r=new Render();
        Movable m=new Movable();
        SpaceShip ship=new SpaceShip((int) Window.get_Width()/2, (int) Window.get_Height()/2);
        new Background(0);
        new Astroidspawn();
        new Astroidspawn();

        m.add(ship);
        r.addRender(ship);
        window.add(r);


        window.addKeyListener(new Key());
        window.packWindow();

        GameTime.begin();
        while (true){
            r.repaint();
            m.run();
    GameTime.calcDaltaTime();
        }
    }
}
