import java.awt.Color; // ペイント用のライブラリを読み込み

public class DrawOval{
  
    void run(String[] args){
    EZ.initialize(400, 400); // 画面の大きさを決める．
    // 円を描く．(中心座標x, y, 幅，高さ，色，塗りつぶし)
    EZCircle circle1 = EZ.addCircle(200, 100, 300, 700, Color.MAGENTA, true); // 塗りつぶしする
    EZCircle circle2 = EZ.addCircle(200, 200, 200, 300, Color.CYAN,  true); // 塗りつぶししない
  }
  
  // mainメソッド
  public static void main(String[] args){
      DrawOval printer = new DrawOval();
      printer.run(args);
  }
}