package core;

import java.time.Duration;
import java.time.Instant;

public class GameTime {
    private  static Duration fps=Duration.ZERO;
    private static Instant begin=Instant.now();
    private static  Duration last=Duration.ZERO;
    private  static  double time=(double) fps.toMillis()-last.toMillis();;
    public static void begin(){
        begin=Instant.now();
        fps=Duration.ZERO;
    }
    public static  void calcDaltaTime(){
        fps=Duration.between(begin,Instant.now());
        time=(double) fps.toMillis()-last.toMillis();
        last=fps;
    }
    public static double getDaltaTime(){
        return time/1000;
    }
}
