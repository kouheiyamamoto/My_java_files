/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Dice"
 * Dice.java 「乱数を使ってサイコロを表現」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Dice.java
 *     >java Dice
 * 【キーワード】
 *     Math(数学)クラス, 乱数(random), 型変換(cast),  *     演算子(operator)の優先順位(priority), java.util.Formatterクラス, 
 * 【試してみよう】
 *     連続して何度か実行し、数値がばらついていることを確認する。 *     java.util.Randomクラスを利用して、乱数を取得する。
 */
import java.lang.Math;
import java.lang.String;
import java.lang.System;

public class Dice {
    public static void main(String[] A00) {
        int L00 = (int)(1 + Math.random() * 6);
        System.out.printf("サイコロころころ... %d が出ました。%n", L00);
    }
}

/* ■ クラスの外でちょっと一言 ■
Math.random()は、0以上1未満のランダムな小数(double型)を返します。ですの
で、何らかの方法で整数に変換してあげないと、「サイコロころこ
ろ...4.688346376357093が出ました」となってしまいます。

この乱数ってのは、サンプルプログラムを面白くするのにもってこいの機能で、
この256ノックでも、何かと利用させてもらってます。
 */
