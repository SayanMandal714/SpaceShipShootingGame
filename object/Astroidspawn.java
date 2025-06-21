package core.object;

import core.Movable;
import core.Movement;
import core.Renderable;
import core.Window;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Astroidspawn implements Movement {

    private static final int MAX_ASTROIDS = 100;
    private static final int ATTEMPTS_PER_SPAWN = 20;
    private static final int MIN_VERTICAL_GAP = 50;

    private static gTimer timer = new gTimer(500);
    private static ArrayList<Rectangle> activerect = new ArrayList<>();
    private static Random rn = new Random();

    public Astroidspawn() {
        Movable.add(this);
    }

    @Override
    public void move() throws IOException, InterruptedException {
        if (timer.isRinging()) {

            if (activerect.size() >= MAX_ASTROIDS) {
                timer.reset();
                return;
            }

            for (int attempt = 0; attempt < ATTEMPTS_PER_SPAWN; attempt++) {
                int w = Astroid.getWidth();
                int h = Astroid.getHight();

                int x = rn.nextInt(Window.get_Width() - w);
                int y = rn.nextInt(-Window.get_Height(), 0);

                int GAPx = rn.nextInt(120, 250);   // horizontal spacing range
                int GAPy = rn.nextInt(100, 350);   // vertical spacing range

                Rectangle newRect = new Rectangle(x - GAPx / 2, y - GAPy / 2, w + GAPx, h + GAPy);

                boolean overlaps = false;
                for (Rectangle r : activerect) {
                    int rTop = r.y;
                    int rBottom = r.y + r.height;
                    int newTop = newRect.y;
                    int newBottom = newRect.y + newRect.height;
                    int rLeft = r.x;
                    int rRight = r.x + r.width;
                    int newLeft = newRect.x;
                    int newRight = newRect.x + newRect.width;

                    boolean verticalOverlap = !(newBottom + MIN_VERTICAL_GAP < rTop || newTop - MIN_VERTICAL_GAP > rBottom);
                    if (r.intersects(newRect) || verticalOverlap) {
                        overlaps = true;
                        break;
                    }
                }

                if (!overlaps) {
                    new Astroid(x, y, newRect, GAPy);
                    break;
                }
            }

            timer.reset();
        }
    }

    @Override
    public String getID() {
        return "";
    }

    @Override
    public Renderable getRengerable() {
        return null;
    }

    @Override
    public Astroid getAstroid() {
        return null;
    }

    public static void removeRect(Rectangle a) {
        activerect.remove(a);
    }

    public static void addRect(Rectangle a) {
        activerect.add(a);
    }
}
