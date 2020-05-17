/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Precision"
 * Precision.java 「小数の精度を検証する」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Precision.java
 *     >java Precision
 * 【キーワード】
 *     整数(integer), 単精度(single precision), 倍精度(double precision),  *     浮動小数点(floating point number), 10進数,(decimal), 2進数(binary),  *     リテラル(literal)
 * 【試してみよう】
 *     int型の「変数」同士を計算して、bouble型の結果を求める。 *     BigDecimalクラスを利用して、誤差を生じさせず0.1を10回足し合わせる。
 */
import java.lang.String;
import java.lang.System;

public class Precision {
    public static void main(String[] A00) {

        System.out.println("リテラルの計算");
        System.out.println("整数(int)演算     ：10  /  3   = " + (10 / 3));
        System.out.println("単精度(float)演算 ：10F /  3F  = " + (10F / 3F));
        System.out.println("倍精度(double)演算：10D  / 3D  = " + (10D / 3D));
        System.out.println("倍精度(double)演算：10.0 / 3.0 = " + (10.0 / 3.0));

        System.out.println();

        System.out.println("0.1を10回足し合わせた結果は...");

        double L00 = 0.0;
        for (int L01 = 0; L01 < 10; L01++) {
            L00 += 0.1;
        }

        System.out.println("なんと、1.0じゃなくて　" + L00);
    }
}

/* ■ クラスの外でちょっと一言 ■
Javaにおける数式の計算結果は、式に含まれる値の型によって変化します。整数
同士の計算なら結果も整数。"15 / 10 = 1.5"ではなくて、"15 / 10 = 1"ですの
で、お間違えなきよう。

じゃあ、整数同士を演算して小数の結果を得たい場合にはどうする？

まず、型を指定してリテラルを記述するという方法があります。リテラルとは
ソースの中に直接書き込まれた値のこと。数値の末尾にFまたはfがあればfloat
型、Dまたはdがあればdouble型と解釈されます。また、"15.0"のようにわざと小
数点をつけるという方法もあります。この場合、数値はdouble型として解釈され
ます。

コンピュータの世界の小数には、「精度」という概念があるのも知っておく必要
があります。これはどこまで小数点以下を表現するかということで、逆の言い方
をすれば、小数のずーっと末端部分は打ち切られているということになります。
実行結果を見ていただければ、floatとdoubleの打ち切り方の違いが分かるで
しょう。

もう一つ、コンピュータの世界の小数で留意すべき点に、「10進数との誤差」が
あります。実は10進数の小数を2進数で表現することは不可能で、0.1という数字
ですら、それに最も近い浮動小数点によって表されてます。10回足しても1.0に
ならないのはその誤差のためです。

こういうことは、知ってれば「そんなもんか」と思えますが、知らなかったら、
「Javaは小学生レベルの計算も出来んのか！！」と怒っちゃいそうですよね。
BigDecimalを使えば誤差のない計算が出来ますので、ご安心を。
 */
