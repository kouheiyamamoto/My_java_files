/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "DecimalSeparator"
 * DecimalSeparator.java 「異なる言語環境で、数値を表示する」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac DecimalSeparator.java
 *     >java DecimalSeparator
 * 【キーワード】
 *     ロケール(locale:地域), ファクトリ(factory)メソッド
 * 【試してみよう】
 *     その他の国の表示形式を調べてみる。 *     各国ごとの日付の表示形式を調べてみる。
 */
import java.lang.String;
import java.lang.System;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalSeparator {
    public static void main(String[] A00) {
        NumberFormat L00;
        int L01 = 2980;
        double L02 = 3.14;

        L00 = NumberFormat.getInstance(Locale.JAPANESE);
        System.out.printf("日本では　 %s や %s と数字を書きますが、%n",
                L00.format(L01), L00.format(L02));

        L00 = NumberFormat.getInstance(Locale.GERMANY);
        System.out.printf("ドイツでは %s や %s と書きます。%n",
                L00.format(L01), L00.format(L02));
    }
}

/* ■ クラスの外でちょっと一言 ■
JavaのAPIドキュメントを眺めてて、使ったことないクラスや、初めて見るメ
ソッドに出会うと、ちょっとワクワクして試しに使ってみたくなります。そし
て、たとえ実用的ではなくとも、そこに何かの発見があると得した気分になりま
す。

今回のNumberFormat.getInstanceメソッドでのロケール指定はまさにそのパター
ン。ロケールとは、言語や文化的地域を表すもので、日付や数値を表示する際に
参照されます。通常は何も指定せずに、その環境のデフォルトのロケール（皆さ
んの場合はおそらく日本語）を採用するんですが、このサンプルのように指定す
ることも可能です。

僕はこのメソッドに出会って、小数点を.(ピリオド)で表記しない国が、ヨー
ロッパを中心にたくさんあることを知りました。ありがとうJavaの国際化。あり
がとうNumberFormat。
 */
