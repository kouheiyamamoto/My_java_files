/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "MathOperator"
 * MathOperator.java 「基本的な算術演算子」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac MathOperator.java
 *     >java MathOperator
 * 【キーワード】
 *     演算子(Operator), java.util.Formatterクラス, 
 * 【試してみよう】
 *     割り算の結果を小数点まで求める。 *     マイナスの値で割った余りを求めてみる。
 */
import java.lang.String;
import java.lang.System;

public class MathOperator {
    public static void main(String[] A00) {
        int L00 = 25;
        int L01 = 6;
        double L02 = 2.56;

        System.out.printf("足し算：%d + %d = %d%n", L00, L01, L00 + L01);
        System.out.printf("引き算：%d - %d = %d%n", L00, L01, L00 - L01);
        System.out.printf("掛け算：%d * %d = %d%n", L00, L01, L00 * L01);
        System.out.printf("割り算：%d / %d = %d%n", L00, L01, L00 / L01);
        System.out.printf("剰余算：%d %% %d = %d%n", L00, L01, L00 % L01);
        System.out.printf("剰余算：%d %% %.2f = %.2f%n", L00, L02, L00 % L02);        
    }
}

/* ■ クラスの外でちょっと一言 ■
Javaのみならず、多くのプログラム言語の算術演算子は、一般的な数学とは
ちょっと違った記号を使います。

掛け算は「*」。アルファベットの「X」と区別するためですね。割り算は
「/」。整数同士の割り算の結果は整数（小数点以下切捨て）となるのがポイン
トです。「%」は剰余算と呼ばれ、割った余りを求めるものです。百分率のパー
セントとは関係ありません。この剰余算は整数だけではなく、小数でも使用可
能。実際に使う局面は少ないと思いますが、一応押さえておいてください。

ちなみに、printfの中では"%"が書式を表す記号に使われますので、"%%"と記述
してます。普通にprintlnで表示する場合と違いますので、ご注意を。
 */
