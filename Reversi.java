import java.awt.Color;

public class Reversi {
    void run() throws InterruptedException {
        init();
        
        Integer up = 235; // 中心座標よりも大きい
        Integer under = 185; // 中心座標よりも小さい
        Integer cw = 40; // 円の横の幅
        Integer ch = 40; // 円の縦の高さ

        EZCircle circle1 = EZ.addCircle(up, under, cw, ch, Color.BLACK, true); // 右上の黒の円
        EZCircle circle2 = EZ.addCircle(up, up, cw, ch, Color.WHITE, true); // 右下の白の円
        EZCircle circle3 = EZ.addCircle(under, up, cw, ch, Color.BLACK, true); // 左上の白の円
        EZCircle circle4 = EZ.addCircle(under, under, cw, ch, Color.WHITE, true); // 左下の黒の円
        
    }

    void init() {
        EZ.initialize(420, 420);
        EZLine background = EZ.addLine(0, 210, 210*2, 210, Color.GREEN, 420); // 緑色の背景

        // 縦の線の描画
        for (Integer x = 10; x < 420; x += 50) {
            EZ.addLine(x, 10, x, 410, Color.BLACK); 
        }
        // 横の線の描画
        for (Integer y = 10; y < 420; y += 50) {
            EZ.addLine(10, y, 410, y, Color.BLACK); 
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Reversi test = new Reversi();
        test.run();
    }
}