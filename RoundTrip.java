// アニメーションの描画
import java.awt.Color;
public class RoundTrip{
    void run() throws InterruptedException{
        EZ.initialize(400, 400); // 画面を作成
        EZCircle circle = EZ.addCircle(100, 100, 5, 5, Color.BLUE, true);
        this.roundTrip(circle); // アニメーションをするメソッド
    }

    void roundTrip(EZCircle circle) throws InterruptedException{
        Integer deltaX = 20;
        Integer deltaY = 10;
        while(true){ // 無限ループ
            Integer newX = circle.getXCenter() + deltaX; // xに+10ずつ足していくことによって右に動いていく。
            Integer newY = circle.getYCenter() + deltaY; // xに+10ずつ足していくことによって右に動いていく。
            circle.translateTo(newX, newY); // 円を表示するtranslateToのなかの()は中心座標
            if(newX >= 400 || newX <= 0){
                deltaX = deltaX * -1;
            }

            if (newY >= 400 || newY <= 0) {
                deltaY = deltaY * -1;
            }
            EZ.refreshScreen(); // HgClearみたいな感じのやつ
            Thread.sleep(100); // InterruptedExceptionは例外処理しないといけないやつ
            // 呼び出し元に責任を転換する。
        }
    }

    public static void main(String[] args) throws InterruptedException{
        RoundTrip printer = new RoundTrip();
        printer.run();
    }
}

// 呼び出し元のメソッドからメソッドに戻ることで、例外を責任を与えていく。
