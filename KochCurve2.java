
//  山本昂平　854030 第6講　練習問題2
// アニメーションの描画
import java.awt.Color;

public class KochCurve2 {
    void run(String[] args) throws InterruptedException {
        EZ.initialize(400, 400); // 画面を作成
        Integer x = 200;
        Integer y = 200;
        EZLine line1 = EZ.addLine(x, y - 200, x, x + 200, Color.BLACK, 1); // 縦線
        EZLine line2 = EZ.addLine(x - 200, y, x + 200, y, Color.BLACK, 1); // 横線
        DrawSineCurve();
    }

    void DrawSineCurve() {
        // deltaは
        Double delta = (2 * Math.PI) / 400;
        Double s = 400 / (2 * Math.PI);
        Integer deltaI = delta.intValue();
        Integer sI = s.intValue();
        // 399本の直線を書く
        for (Integer i = 0; i < 400; i++) {
            // xはi
            // yはv,
            Double v = Math.sin(i * delta) * s;
            Integer vI = v.intValue();
            EZLine line3 = EZ.addLine(i, vI + 200, i + 1, vI + 201, Color.RED, 1);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        KochCurve2 printer = new KochCurve2();
        printer.run(args);
    }
}
