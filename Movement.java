package core;

import core.object.Astroid;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public interface Movement {
    void move() throws IOException, InterruptedException, UnsupportedAudioFileException, LineUnavailableException;
    String getID();
    Renderable getRengerable();
    Astroid getAstroid();
    public  default  Movement isColliding(Renderable cobj,String callID){
        ArrayList<Movement> obj=Movable.getCurrentMove();
        for (Movement o :obj){
            if(Objects.equals(o.getID(), callID)){
                boolean x= cobj.getX()<o.getRengerable().getX()+o.getRengerable().get_Width() &&cobj.getX()+cobj.get_Width()>o.getRengerable().getX();
              boolean y=  cobj.getY()<o.getRengerable().getY()+o.getRengerable().get_Height() &&cobj.getY()+cobj.get_Height()>o.getRengerable().getY();
              if(y&&x){return o;}

            }
        }
        return  null;
    }

}
