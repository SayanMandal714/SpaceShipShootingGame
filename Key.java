package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Key implements KeyListener {
    public  static boolean[]keys=new boolean[5];
    static int down=1;
    static int up=0;
    static int right=2;
    static int left=3;
    static int space=4;
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
if(e.getKeyCode()==e.VK_UP||e.getKeyChar()=='e'){
    //up
    keys[0]=true;
     }
if (e.getKeyCode()==e.VK_DOWN||e.getKeyChar()=='d') {
    //down
    keys[1]=true;
}
if (e.getKeyCode()==e.VK_RIGHT||e.getKeyChar()=='f') {
            //right
    keys[2]=true;
        }
if (e.getKeyCode()==e.VK_LEFT||e.getKeyChar()=='s') {
            //left
    keys[3]=true;

        }
if (e.getKeyCode()==e.VK_SPACE) {
            //space
    keys[4]=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

            if(e.getKeyCode()==e.VK_UP||e.getKeyChar()=='e'){
                //up
                keys[0]=false;
            }
            if (e.getKeyCode()==e.VK_DOWN||e.getKeyChar()=='d') {
                //down
                keys[1]=false;
            }
            if (e.getKeyCode()==e.VK_RIGHT||e.getKeyChar()=='f') {
                //right
                keys[2]=false;
            }
            if (e.getKeyCode()==e.VK_LEFT||e.getKeyChar()=='s') {
                //left
                keys[3]=false;

            }
            if (e.getKeyCode()==e.VK_SPACE) {
                //space
                keys[4]=false;
            }
        }
    }

