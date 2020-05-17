/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "NumFormat"
 * NumFormat.java 「NumberFormatを使って、3桁区切りの数値を計算する」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac NumFormat.java
 *     >java NumFormat
 * 【キーワード】
 *     ファクトリ(factory)メソッド, parse(解析する), format(書式化する)
 * 【試してみよう】
 *     小数点やマイナスを含む3桁区切りの数字を演算する。
 */
import java.lang.String;
import java.lang.System;
import java.text.NumberFormat;
import java.text.ParseException;

public class NumFormat {
    public static void main(String[] A00) {
        String L00 = "3,776";
        String L01 = "8,848";
        int L02;

        NumberFormat L03 = NumberFormat.getInstance();

        try {
            L02 = L03.parse(L00).intValue() + L03.parse(L01).intValue();
            System.out.printf("%s + %s = %s%n", L00, L01, L03.format(L02));
        } catch (ParseException L04) {
            System.out.println("文字列を解析できませんでした。");
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
3桁で区切られた数字を扱うときには、このNumberFormatクラスが便利です。オ
ブジェクトの取得は、newで生成せずに、getInstanceメソッドで行います。その
点さえ注意しておけば後は簡単。parseメソッドで文字から数値に変換して、
formatメソッドで数値から文字に変換します。

これを知らないと、いちいちカンマを取り除いたり挿入したりと、余分なコード
を書くハメになりますね。少しでも楽したいという思考は、プログラマーにとっ
て重要なメンタリティです。皆さんも、どんどん楽するための知識を蓄えてくだ
さい。
 */
