//  山本昂平　854030 第6講　練習問題1
// アニメーションの描画
import java.awt.Color;

public class DrawShapes2 {
    void run() throws InterruptedException {
        EZ.initialize(400, 400); // 画面を作成
        Integer x = 50;
        Integer y = 200;
        // 四角形の描画
        EZLine boxBlue = EZ.addLine(100, 200, 300, 200, Color.BLUE, 200); // 塗りつぶししない
        // 4色のLineの描画
        EZLine line1 = EZ.addLine(x, y, y, x, Color.RED, 2); // 塗りつぶししない
        EZLine line2 = EZ.addLine(y, x, y+150, y, Color.YELLOW, 2); // 塗りつぶししない
        EZLine line3 = EZ.addLine(y+150, y, y, y+150, Color.BLACK, 2); // 塗りつぶししない
        EZLine line4 = EZ.addLine(y, y + 150, x, y, Color.GREEN, 2); // 塗りつぶししない
        // 円を描く．(中心座標x, y, 幅，高さ，色，塗りつぶし)
        EZCircle circle = EZ.addCircle(200, 200, 200, 200, Color.WHITE, true);

        
    }

    public static void main(String[] args) throws InterruptedException {
        DrawShapes2 printer = new DrawShapes2();
        printer.run();
    }
}
