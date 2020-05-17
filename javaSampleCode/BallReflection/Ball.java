/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "BallReflection"
 * Ball.java 「ウィンドウの内側を反射するボール」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java BallReflection
 * 【キーワード】
 *     乱数(random), 楕円(oval)の描画, 描画色の指定, 入射角と反射角 *     
 * 【試してみよう】
 *     色を指定できるようにする。 *     移動スピードも指定できるようにする。
 */
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

public class Ball {
    int I00;
    int I01;
    int I02;
    int I03;
    int I04;

    Ball(int A00) {
        this.I02 = A00;

        I00 = (int)(Math.random() * (DrawPanel.C00 - I02));
        I01 = (int)(Math.random() * (DrawPanel.C01 - I02));

        // 進行方向はランダム
        if (Math.random() > 0.5) {
            I03 = 1;
        } else {
            I03 = -1;
        }
        if (Math.random() > 0.5) {
            I04 = 1;
        } else {
            I04 = -1;
        }
    }

    void M00() {
        I00 += I03;
        I01 += I04;

        // 壁に衝突すれば反射
        if (I00 >= (DrawPanel.C00 - I02) || I00 <= 0) {
            I03 = -I03;
        }
        if (I01 >= (DrawPanel.C01 - I02) || I01 <= 0) {
            I04 = -I04;
        }
    }

    void M01(Graphics A00) {
        A00.setColor(Color.orange);
        A00.fillOval(I00, I01, I02, I02);
    }
}

/* ■ クラスの外でちょっと一言 ■
まず、一番下のfillOvalメソッドの引数から、いくつかのインスタンス変数名を
特定すると、全体の処理が見えてくるのではと思います。ボールの座標は円の中
心ではなく、円に外接する四角形の左上角になってますが、これはfillOvalメ
ソッドの引数の指定方法とあわせたからです。

このクラスには、イベントやウィンドウシステムの記述がなく、単純にボール関
する処理のみになってるのがミソですね。
 */
