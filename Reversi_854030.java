import java.awt.Color;

public class Reversi {
    void run() throws InterruptedException {
        init();
        
        Integer up = 235;
        Integer under = 185;
        Integer wx = 235;
        Integer wy = 235; 
        Integer cw = 40;
        Integer ch = 40;

        EZCircle circle1 = EZ.addCircle(up, under, cw, ch, Color.BLACK, true); 
        EZCircle circle2 = EZ.addCircle(up, up, cw, ch, Color.WHITE, true); 
        EZCircle circle3 = EZ.addCircle(under, up, cw, ch, Color.BLACK, true);
        EZCircle circle4 = EZ.addCircle(under, under, cw, ch, Color.WHITE, true);
        
    }

    void init() {
        EZ.initialize(420, 420);
        EZLine background = EZ.addLine(0, 210, 210*2, 210, Color.GREEN, 420);
        for (Integer x = 10; x < 420; x += 50) {
            EZ.addLine(x, 10, x, 410, Color.BLACK); 
        }
        for (Integer y = 10; y < 420; y += 50) {
            EZ.addLine(10, y, 410, y, Color.BLACK); 
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Reversi test = new Reversi();
        test.run();
    }
}