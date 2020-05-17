/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "JavaCurry"
 * Box.java 「カレーのパッケージをオブジェクト指向で表現」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java JavaCurry
 * 【キーワード】
 *     矩形(rectangle)の描画
 * 【試してみよう】
 *     JavaCurry.java参照
 */
import java.awt.Color;
import java.awt.Graphics;

public class Box implements Parts {
    int I00;
    int I01;
    int I02;
    int I03;
    Color I04;

    Box(int A00, int A01, int A02, int A03, Color A04) {
        this.I00 = A00;
        this.I01 = A01;
        this.I02 = A02;
        this.I03 = A03;
        this.I04 = A04;
    }

    public void M00(Graphics A00) {
        A00.setColor(I04);
        A00.fillRect(I00, I01, I02, I03);
    }
}

/* ■ クラスの外でちょっと一言 ■
ちなみに、僕は辛いのは苦手な方です。というか、すごく汗をかいてしまいま
す。「ココイチ」のカレーでいえば、辛さ普通で結構汗だく。でも、好きなん
で、ちょくちょく食べに行ってます。よく注文するのは「チキンカツカレー」で
すね。
 */
