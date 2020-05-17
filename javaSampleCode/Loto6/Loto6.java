/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Loto6"
 * Loto6.java 「配列をシャッフルする」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Loto6.java
 *     >java Loto6
 * 【キーワード】
 *     配列(array), 並べ替え(sort), 乱数(random)
 * 【試してみよう】
 *     結果を、過去の当選番号と比較する。(Loto6.csvを参照のこと) *     ミニロトや、ナンバーズの予想に対応する。 *     出現した数字で実際に購入してみる。
 */
import java.lang.Math;
import java.lang.String;
import java.lang.System;
import java.util.Arrays;

public class Loto6 {

    public static void main(String[] A00) {
        final int L00 = 43;
        final int L01 = 6;
        int[] L02 = new int[L00];

        for (int L03 = 0; L03 < L00; L03++) {
            L02[L03] = L03 + 1;
        }

        int[] L04 = M00(L02, L01);
        Arrays.sort(L04);

        System.out.printf("%d個の数字から%d個の数字を選ぶと...%n", L00, L01);
        for (int L05 : L04) {
            System.out.printf("%02d ", L05);
        }
    }

    static int[] M00(int[] A00, int A01) {
        for (int L00 = 0; L00 < A00.length; L00++) {
            int L01 = (int)(Math.random() * A00.length);
            int L02 = A00[L01];
            A00[L01] = A00[L00];
            A00[L00] = L02;
        }

        int[] L03 = new int[A01];
        for (int L00 = 0; L00 < A01; L00++) {
            L03[L00] = A00[L00];
        }
        
        return L03;
    }
}

/* ■ クラスの外でちょっと一言 ■
43個の数字から6つの数字の組み合わせを選ぶ「ロト６」をテーマに作ってみま
した。配列の操作をしている部分が、一見分かりづらいかもしれませんね。言葉
で説明すれば、「43個の数字をシャッフルして、先頭の6個を別の配列にコ
ピー。それを小さい順に並び替え」となります。メソッドの引数と戻り値に注意
して、データの流れを追いかけてください。

同一フォルダにある"Loto6.csv"には、223回までの当選番号が入ってます。最新
のデータは、サイト（みずほ銀行など）やフリーのツール（＠宝くじNewsなど）
を利用して入手してください。

実は、人間って、無作為に数字を選択するのが苦手なんですよね。個人個人で
は、ばらばらな数字を選択していても、それが何万、何十万人と集まれば、どう
しても、文化的、社会的な傾向が出てしまうものです。そいう観点から言えば、
コンピュータによるランダムな選択は、高額配当を狙うときの参考になるかもし
れませんね。
 */
