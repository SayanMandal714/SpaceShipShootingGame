package core.object;

import core.GameTime;
import core.Movement;
import core.Renderable;

import java.io.IOException;

public class gTimer implements Movement {
    double begain;
    double set;
    public gTimer(int set){
        this.begain=set;
        this.set = set;
    }
    @Override
    public void move() throws IOException {
     set-= GameTime.getDaltaTime()*1000;
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

    public  void reset(){
        set=begain;
    }
    public boolean isRinging(){
        if(set>=0) return true;
        return false;

    }
}
