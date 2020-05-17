/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Rounding"
 * Rounding.java 「MathとBigDecimalによる小数点の四捨五入、切り捨て、切り上げ」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Rounding.java
 *     >java Rounding
 * 【キーワード】
 *     ceil(切り上げ), floor(切り下げ), round(四捨五入),　10進数(decimal), *     列挙型(enumerated type),
 * 【試してみよう】
 *     BigDecimalに用意されている8個の丸め込みモードをチェックする。 *     printfメソッドやjava.text.NumberFormatクラスで、小数を整形して表示してみる。
 */
import java.lang.Math;
import java.lang.String;
import java.lang.System;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rounding {
    public static void main(String[] A00) {

        System.out.println("小数を整数にする（Mathクラス）");

        double L00 = 25.6;
        System.out.println("元の値　：" + L00);
        System.out.println("切り上げ：" + (int)Math.ceil(L00));
        System.out.println("切り捨て：" + (int)Math.floor(L00));
        System.out.println("四捨五入：" + Math.round(L00));

        System.out.println("\n小数点第１位までにする（BigDecimalクラス）");

        BigDecimal L01 = new BigDecimal("256.256");
        System.out.println("元の値　：" + L01);
        System.out.println("切り上げ：" + L01.setScale(1, RoundingMode.CEILING));
        System.out.println("切り捨て：" + L01.setScale(1, RoundingMode.FLOOR));
        System.out.println("四捨五入：" + L01.setScale(1, RoundingMode.HALF_UP));
    }
}

/* ■ クラスの外でちょっと一言 ■
数値を扱うとき、必要な桁数に収まるよう、値を「丸め込み」たいときがありま
すよね。そんなときによく使われるのが、切り上げ、切り捨て、四捨五入です。

基本型(intやdoubleなど)で処理を進める場合は、Mathクラスが便利。インスタ
ンスを生成することなく、手軽に利用できます。ただし精度の問題上、小数を整
数に変換するときにしか使うべきではありません。

BigDecimalは、インスタンスの生成が伴うなど、多少面倒ですが、そのぶん細か
く丸め込み処理を制御することができ、精度の問題もありません。場合によって
使い分けてください。

BigDecimalの丸めモードの指定には、以前は整数フィールド
（BigDecimal.ROUND_HALF_UPなど）が使われていましたが、J2SE 5.0からは、
java.math.RoundingModeの列挙型の使用が推奨されています。
 */
