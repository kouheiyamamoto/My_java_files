/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "CharOperation"
 * CharOperation.java 「Unicode文字同士をビット演算」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac CharOperation.java
 *     >java CharOperation
 * 【キーワード】
 *     ビット演算(bit operation), 論理積(and), ユニコード(Unicode), *     java.util.Formatterクラス, 
 * 【試してみよう】
 *     二つの漢字をコマンドラインから受け取るようにする。 *     OR演算やXOR演算も試してみる。 *     
 */
import java.lang.Integer;
import java.lang.String;
import java.lang.System;

public class CharOperation {
    public static void main(String[] A00) {
        char L00 = '生';
        char L01 = '死';
        char L02 = (char)(L00 & L01);

        System.out.printf("「%c」と「%c」、それは「%c」である。%n", L00, L01, L02);
        System.out.println(L00 + ":" + Integer.toBinaryString(L00));
        System.out.println(L01 + ":" + Integer.toBinaryString(L01));
        System.out.println(L02 + ":" + Integer.toBinaryString(L02));
    }
}

/* ■ クラスの外でちょっと一言 ■
その昔、アルファベットの大文字小文字変換は、ビット演算解説の定番テーマで
した。おかげで、ビット演算の仕組みのみならず、文字を数値として処理する実
感も学ぶことができました。ASCIIコード表をながめて、「なるほどな」と納得
したものです。

ところが、最近はそんなナイスなテーマがないんですよね。Stringクラスのメ
ソッドを呼べば、基本的な処理はほとんど可能なんですから。でも、文字に対す
る演算は、コンピュータの本質を理解するうえでも重要な要素。てなわけで、
『愛のJava256本ノック』では、強引に文字を数値として処理することに、真剣
に取り組んでます。

char型同士をANDした結果に、わざわざchar型をキャスト（型変換）してます
が、これは「数値演算の結果は、int型またはlong型になる」というJavaの言語
仕様のためです。

ちなみに、JIS第一水準に限定し、漢字同士をANDして別の漢字になる組み合わせ
を調べたところ、30万8395通りありました。OR、XORも含めると、相当な数にな
りますね。きっと他にもUnicodeに隠されたメッセージが存在すると思います。
お暇な方は探してみてください。
 */
