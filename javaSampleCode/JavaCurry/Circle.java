/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "JavaCurry"
 * Circle.java 「カレーのパッケージをオブジェクト指向で表現」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java JavaCurry
 * 【キーワード】
 *     楕円(oval)の描画
 * 【試してみよう】
 *     JavaCurry.java参照。
 */
import java.awt.Color;
import java.awt.Graphics;

public class Circle implements Parts {
    int I00;
    int I01;
    int I02;
    Color I03;

    Circle(int A00, int A01, int A02, Color A03) {
        this.I00 = A00;
        this.I01 = A01;
        this.I02 = A02;
        this.I03 = A03;
    }

    public void M00(Graphics A00) {
        A00.setColor(I03);
        A00.fillOval(I00, I01, I02, I02);
    }
}

/* ■ クラスの外でちょっと一言 ■
このサンプルを作るにあたり、「ボンカレーのパッケージってどんなんだっ
け？」ということで、早速、近所のスーパー（ゆめタウン宗像店）へ調査に行き
ました。しかし、僕の記憶にある『ボンカレー ゴールド』はもうそこにはな
く、『ボンカレー ゴールド２１』へとバージョンアップしてるではないです
か！　しかも、パッケージの「丸」が、微妙に立体的で、テカリまで入ってる
じゃないですか！

とりあえず見なかったことにして、スーパーを後にしました……。
 */
