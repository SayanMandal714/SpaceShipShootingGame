package core.object;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    public  static void playSound(String filepath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audio= AudioSystem.getAudioInputStream(new File(filepath));
        Clip clip=AudioSystem.getClip();
        clip.open(audio);
        clip.setMicrosecondPosition(0);
        clip.start();

    }
}
