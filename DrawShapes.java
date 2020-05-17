import java.awt.Color; // ペイント用のライブラリを読み込み

public class DrawShapes{
  
    void run(String[] args){
    EZ.initialize(800, 800); // 画面の大きさを決める．
    // 円を描く．(中心座標x, y, 幅，高さ，色，塗りつぶし)
    EZCircle circle1 = EZ.addCircle(400, 400, 300, 300, Color.RED, true); // 塗りつぶしする
    EZLine line1 = EZ.addLine(0, 0, 800, 800, Color.CYAN, 20); // 塗りつぶししない
    EZLine line2 = EZ.addLine(800, 0, 0, 800, Color.CYAN, 20); // 塗りつぶししない
  }
  
  // mainメソッド
  public static void main(String[] args){
      DrawShapes printer = new DrawShapes();
      printer.run(args);
  }
}