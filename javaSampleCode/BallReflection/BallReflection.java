/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "BallReflection"
 * BallReflection.java 「ウィンドウの内側を反射するボール」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java BallReflection
 * 【キーワード】
 *     画面のリフレッシュレート(refresh rate:垂直走査周波数)
 * 【試してみよう】
 *     タイマーの発生間隔を変えて、アニメーションの見え方を比べる。 *     ウィンドウのサイズを変更可能にし、フレーム内で跳ね返るようにする。
 */
import java.awt.Color;
import java.lang.String;
import javax.swing.JFrame;
import javax.swing.Timer;

public class BallReflection extends JFrame {
    final static int C00 = 30;

    public BallReflection() {
        DrawPanel L00 = new DrawPanel();
        add(L00);

        new Timer(C00, L00).start();
    }

    public static void main(String[] A00) {
        JFrame L00 = new BallReflection();
        L00.setTitle("反射するボール");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.setResizable(false);
        L00.pack();
        L00.setVisible(true);
    }
}

/* ■ クラスの外でちょっと一言 ■
グラフィックを定期的に描画する、つまりアニメーションさせるには、一定間隔
でイベントを発生させる仕組みが必要です。このプログラムでは
javax.swing.Timerを使って、約0.03秒ごとに（毎秒約33回）、
java.awt.event.ActionEventを発生させています。

ゲームでは、毎秒30回画面を書き換える「秒30フレーム」が平均的ですね。書き
換え回数を増やすほど、アニメーションがスムーズになるわけですが、秒60フ
レーム以上は、いくら増やしても同じに見えます。人間の目の限界ってのもあり
ますが、一般的なパソコンのディスプレイは、毎秒60～85回くらいで画面を更新
してるんで、それ以上やっても無駄なわけです。むしろ、増やしすぎると描画に
処理時間を取られて「重く」なるので、気をつけてください。

逆に減らす場合は、動きの少ないものなら、秒15フレームでもそれなりに見えて
くれます。この辺はバランスの問題ですので、実際に試して感触をつかんでくだ
さい。
 */
