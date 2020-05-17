/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Alphabet"
 * Alphabet.java 「forループを使ってアルファベットを表示」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Alphabet.java
 *     >java Alphabet
 * 【キーワード】
 *     char(文字)型, forループ, インクリメント(increment:増加)演算子, Unicode *     
 * 【試してみよう】
 *     平仮名や漢字をインクリメントしてみる。 *     ループカウンターをchar型にし、表示用の変数と兼用させてAからZまで表示する。
 */
import java.lang.String;
import java.lang.System;

public class Alphabet {
    public static void main(String[] A00) {
        char L00 = 'A';

        for (int L01 = 0; L01 <= ('Z' - 'A'); L01++) {
            System.out.print(L00++);
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
文字をそのまま計算式で使うこともできます。JavaはUnicodeを採用してますの
で、文字を0～65535までの2バイトのコードで管理しています。ですので、内部
的には、いわゆる半角(1バイト)・全角(2バイト)の区別がありません。アルファ
ベット以外の文字がどういう順番で文字が並んでるのか、気になって眠れないと
いう方は、思い切って0から65535まで全部の文字を表示してみると、スッキリす
るでしょう。

ちなみに、'A'は文字、"A"は文字列なので、キチンと区別してくださいね。
 */
