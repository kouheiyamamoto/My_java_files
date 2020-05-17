/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "JavaCurry"
 * JavaCurry.java 「カレーのパッケージをオブジェクト指向で表現」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java JavaCurry
 * 【キーワード】
 *     大塚食品, ボンカレーゴールド
 * 【試してみよう】
 *     Box、Circle、Textを上手く組み合わせ、右下にJASマークを入れる。 *     http://www.jasnet.or.jp/
 */
import java.awt.Color;
import java.lang.String;
import java.lang.System;
import javax.swing.JFrame;

public class JavaCurry extends JFrame {

    public JavaCurry() {
        add(new DrawPanel());
    }

    public static void main(String[] A00) {
        JFrame L00 = new JavaCurry();
        L00.setTitle("オブジェクト指向レトルトカレー");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.pack();
        L00.setResizable(false);
        L00.setVisible(true);
    }
}

/* ■ クラスの外でちょっと一言 ■
本当は、ハウス『ジャワカレー』のパッケージをやりたかったんですが、かなり
複雑で、とてもプリミティブな図形の組み合わせでは表現不可能なため、断腸の
思いで、大塚食品『ボンカレー ゴールド』を題材にしました。

レトルトカレーマニアにつっこまれる前に、言い訳しておきます。
 */
