/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Haiku"
 * Haiku.java 「足し算としての"+"と、文字列連結演算子としての"+"」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Haiku.java
 *     >java Haiku
 * 【キーワード】
 *     加算(add)演算子, 文字列連結(string concatenation)演算子, 式の評価順序
 * 【試してみよう】
 *     (L03 + L04 + L03)ではなく、(L03 + L04 + L03 + "音で構成されます。")としたら、 *     どう表示されるか予想して、試してみる。
 */
import java.lang.String;
import java.lang.System;

public class Haiku {
    public static void main(String[] A00) {
        String L00 = "古池や";
        String L01 = "蛙飛び込む";
        String L02 = "水の音";

        System.out.println("～" + L00 + L01 + L02 + "～");

        int L03 = 5;
        int L04 = 7;

        System.out.println("俳句は" + L03 + L04 + L03 + "の" +
                (L03 + L04 + L03) + "音で構成されます。");    
    }
}

/* ■ クラスの外でちょっと一言 ■
演算子"+"は、その左右の値が両方とも数値の場合には足し算を行い、どちらか
が文字列の場合は、文字列とつなぎ合わせる役目をします。出力結果と見比べ
て、()で数値同士を先に計算させた部分は「17」になって、文字列と足し合わせ
た部分は「575」となってることを確認してください。

このサンプルは自分でもお気に入りで、芭蕉の句には及ばずとも、なかなかに深
い趣のある出来栄えだと自負しております。
 */
