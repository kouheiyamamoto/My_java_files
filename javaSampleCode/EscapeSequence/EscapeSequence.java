/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "EscapeSequence"
 * EscapeSequence.java 「エスケープシーケンスで遊んでみる」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac EscapeSequence.java
 *     >java EscapeSequence
 * 【キーワード】
 *     エスケープシーケンス(escape sequence:拡張表記), バックスラッシュ
 * 【試してみよう】
 *     ソース内の文字列と、実際に出力された文字列を比較する。 *     自分でエスケープシーケンスを含む文章を考えて、表示する。
 */
import java.lang.String;
import java.lang.System;

public class EscapeSequence {
    public static void main(String[] A00) {
        String L00 = "今月の新刊：\n";
        String L01 = "\t\"愛欲\bの横山\b\bノック256本物語\"\t定価 \\1280";

        System.out.println(L00 + L01);

        System.out.println("「ビープ音」が鳴るかも！？\07");
    }
}

/* ■ クラスの外でちょっと一言 ■
エスケープシーケンスは、キーボードから入力できない文字(改行、バックス
ペースなど)や、Java言語において特別な意味を持つ記号（" ' \など）を記述す
るために用意されています。いくつかの種類がありますが、よく使われるのは、
\" \' \\ \nですので、この４つから覚えてください。

サンプルではビープ音を鳴らしてますが、これはコントロールコードというもの
を出力することによって実現してます。環境によっては音が出ないかもしれませ
んし、実用性も低いので、「こんなこともできるんだ」程度に覚えておいてくだ
さい。
 */
