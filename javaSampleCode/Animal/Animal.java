/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Animal"
 * Animal.java 「コマンド引数とswitch文を使って、なんちゃって動物占い」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Animal.java
 *     >java Animal
 * 【キーワード】
 *     switch文, 剰余演算子(%), 文字列(String)を整数(int)に変換,  *     コマンドライン引数(arguments)の取得, 例外(exception)の捕捉(catch)
 * 【試してみよう】
 *     動物の種類を増やす。 *     正しい年月日かどうかのチェックをする。
 */
import java.lang.Integer;
import java.lang.NumberFormatException;
import java.lang.String;
import java.lang.System;

public class Animal {
    public static void main(String[] A00) {
        final int L00 = 6;
        int L01 = 0;
        int L02 = 0;
        int L03 = 0;

        if (A00.length < 3) {
            System.out.println("使用例 >java Animal 1969 6 26");
            System.exit(1);
        }

        try {
            L01 = Integer.parseInt(A00[0]);
            L02 = Integer.parseInt(A00[1]);
            L03 = Integer.parseInt(A00[2]);
        } catch (NumberFormatException L04) {
            System.out.println("生年月日には数字を指定してください。");
            System.exit(1);
        }

        int L05 = (L01 + L02 + L03) % L00;

        System.out.printf("%d年%d月%d日生まれのあなたは...%n", L01, L02, L03);

        switch (L05) {
            case 0:
                System.out.println("穏やかな心をもったヒツジです。");
                break;
            case 1:
                System.out.println("おっとりマイペースのコアラです。");
                break;
            case 2:
                System.out.println("自分が一番のライオンです。");
                break;
            case 3:
                System.out.println("孤独が大好きなオオカミです。");
                break;
            case 4:
                System.out.println("お調子者のサルです。");
                break;
            case 5:
            default:
                System.out.println("不思議な性格のタスマニアンデビルです。");
                break;
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
入力された日付を無理やり計算するという、インチキ臭いアルゴリズムですが、
実際にやってみると、「お、当たってるかも！？」と思ったりしちゃいます。ま
あ、占いってだいたいそんなものなんでしょうね。

正しい日付かどうか調べるには、チェックしたい年月日を使って、実際に
java.util.Calendarインスタンスを生成するやり方がいいでしょう。検索エンジ
ンで"java 日付 妥当性"で探すと、いいサンプルが見つかると思います。
 */
