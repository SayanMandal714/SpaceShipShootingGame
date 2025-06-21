package core;
import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
   private static int height=920;
   private static int width=630;
   String win_name;


    public static int get_Width() {
        return width;
    }


    public static int get_Height() {
        return height;
    }

    public Window(String name) {
       super(name);
       this.win_name=name;
       setSize((int) width, (int) height);
       setTitle(name);
       setUp();
   }

   public  Window(String name, int height,int width){
       super(name);
       this.win_name=name;
       setSize( width, height);
       setTitle(name);

       this.height=height;
       this. width=width;
       setUp();
   }
   private void setUp(){
       JLabel label=new JLabel("Let\'s Shoot");
       label.setForeground(Color.white);
       label.setHorizontalAlignment(SwingConstants.CENTER); // Center horizontally
       label.setVerticalAlignment(SwingConstants.TOP);      // Align to top
       add(label);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setResizable(true);
   }
   public  void  packWindow(){
       pack();
       setResizable(false);
   }

}
