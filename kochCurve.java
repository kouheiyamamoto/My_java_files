
// 山本昂平 854030 第6講 練習問題3
// コッホ曲線の描画
import java.awt.Color;

public class KochCurve {

    void run(String[] args) {

        EZ.initialize(400, 400); // 画面を作成

        // 最初の座標
        Integer x1 = 0;
        Integer y1 = 100;
        Integer x5 = 400;
        Integer y5 = 100;
        // 角度の設定
        Double angle = 0.0; // なにを持って位くるのか

        if (args.length == 0) {
            Integer number = 0;
            this.drawKoch(x1, y1, x5, y5, number, angle);
        } else {
            Integer number = Integer.valueOf(args[0]); // コマンドライン引数を数字に変換
            this.drawKoch(x1, y1, x5, y5, number, angle);
        }
    }

    // コッホ曲線を描画するメソッド
    void drawKoch(Integer x1, Integer y1, Integer x5, Integer y5, Integer dimension, Double angle) {

        if (dimension == 0) {
            // (x1, y1)から(x5, y5)まで線を引く．
            EZ.addLine(x1, y1, x5, y5, Color.RED);
        } else {
        
            // n = 1のとき
            // (x1, y1), (x5, y5) 間の長さの 1/3．これが l となる．
            Double l = ( Math.sqrt( ( (x5 - x1) * (x5 - x1) ) + ( (y5 - y1) * (y5 - y1) ) ) ) / 3.0; // 線分に分けた時の3等分の長さ
            Double delta = Math.PI / 3.0;
            
            // (x2, y2) を求める．
            Double x2 = x1 + l * Math.cos(angle);
            Double y2 = y1 + l * Math.sin(angle);
            
            // (x1, y1)から(x2, y2)まで線を引く
            EZ.addLine(x1, y1, x2.intValue(), y2.intValue(), Color.RED, 1);
            // (x3, y3) を求める（θ は angle + delta）．
            Double x3 = x2 + ( l * Math.cos(angle + delta) );
            Double y3 = y2 + ( l * Math.sin(angle + delta) );
            // (x2, y2)から(x3, y3)まで線を引く
            EZ.addLine(x2.intValue(), y2.intValue(), x3.intValue(), y3.intValue(), Color.RED, 1);
            this.drawKoch(x3.intValue(), y3.intValue(), x3.intValue(), y3.intValue(), dimension - 1, angle + delta);

            Double x4 = x3 + l * Math.cos(angle - delta);
            Double y4 = x3 + l * Math.sin(angle - delta);

            EZ.addLine(x3.intValue(), y3.intValue(), x4.intValue(), y4.intValue(), Color.RED, 1);
            this.drawKoch(x3.intValue(), y3.intValue(), x4.intValue(), y4.intValue(), dimension - 1, angle - delta);

            EZ.addLine(x4.intValue(), y4.intValue(), x5, y5, Color.RED, 1);

            // 途中で積んだ笑
            // n > 1のとき
            
            // x2 = x1 + l * Math.cos(angle + delta);
            // y2 = y1 + l * Math.sin(angle + delta);

            // x3 = x2 + l * Math.cos(angle + delta);
            // y3 = y1 + l * Math.sin(angle + delta);


           // EZ.addLine(ix2.intValue(), iy2.intValue(), x4.intValue(), y4.intValue(), Color.RED, 1);
            //(x2, y2)から(x3, y3)まで線を引く．
           

            // // (x4, y4) を求める（θ は angle - delta）．
            // Double x4 = x3 + ( l * Math.cos(angle - delta) );
            // Double y4 = y3 + ( l * Math.sin(angle - delta) );
            // // (x3, y3)から(x4, y4)まで線を引く
            // EZ.addLine(x3.intValue(), y3.intValue(), x4.intValue(), y4.intValue(), Color.RED, 1);
           

            // (x4, y4)から(x5, y5)まで線を引く．
            EZLine line5 = EZ.addLine(x4.intValue(), y4.intValue(), x5.intValue(), y5.intValue(), Color.RED, 1);
            this.drawKoch(x4.intValue(), y4.intValue(), x5.intValue(), y5.intValue(), dimension - 1, angle + delta);
        
        }
    }

    public static void main(String[] args) {
        KochCurve printer = new KochCurve();
        printer.run(args);
    }
}
