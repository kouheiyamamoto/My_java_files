/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Java256"
 * Java256.java 「コマンドプロンプトに文字を出力する」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Java256.java
 *     >java Java256
 * 【キーワード】
 *     べき乗(power), 型変換(cast), int(整数)型, java.util.Formatterクラス, 
 * 【試してみよう】
 *     Math.powの引数を変更して「32本のノックを受ける」や、 *     「65536本のノックを受ける」と表示してみる。
 */
import java.lang.Math;
import java.lang.String;
import java.lang.System;

public class Java256 {
    public static void main(String[] a00) {
        int L00 = (int)Math.pow(2, 8);
        System.out.println("宣誓！　我々は、スポーツマンシップにのっとり");
        System.out.printf("正々堂々、%d本のノックを受けることを誓います。%n", L00);
    }
}

/* ■ クラスの外でちょっと一言 ■
java.lang.Math.pow()は、double型を返します。ですので、そのままだと
"256.0"となってしまうので、int型に変換してます。

コンピュータの基本は2進数(binary)ですので、２のべき乗はよく出てきます。
8,16,32,64,128,256,512,1024,65536を見たときにはピンと来るようになってく
ださい。とはいえ、買い物なんかでお釣りが256円だったりしたときに、「すげ
え、ぴったり！」と自慢しても、一般の人には理解してもらえませんからね。

128(イチニッパ)、256(ニゴロ)と発音すると、プロっぽくていい感じです。
 */
