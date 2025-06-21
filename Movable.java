package core;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;

public class Movable {
static ArrayList<Movement> currentMove =new ArrayList<>();
static ArrayList<Movement>newmove=new ArrayList<>();
static ArrayList<Movement>removemove=new ArrayList<>();

    public static ArrayList<Movement> getCurrentMove() {
        return currentMove;
    }

    static void run() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException {
    for(Movement c : currentMove)c.move();
    currentMove.removeAll(removemove);
    currentMove.addAll(newmove);
    removemove.clear();
    newmove.clear();
}
    public static void add(Movement o){
    newmove.add(o);
    }
   public static void remove(Movement o){
        removemove.add(o);
    }
    public static void removed(Movement o){
        currentMove.remove(o);
    }


}
