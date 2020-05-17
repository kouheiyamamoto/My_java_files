/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Slot"
 * Slot.java 「乱数でスロットマシーン」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Slot.java
 *     >java Slot
 * 【キーワード】
 *     ミリ秒(millisecond), エスケープシーケンス(escape sequence:拡張表記),  *     乱数(random), 標準入力(standard input)
 * 【試してみよう】
 *     当たりのパターンを増やす、当たる確立に変化をつけるなど、もっと面白くする。 *     当たったときに、派手な演出を加える。
 */
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.lang.Math;
import java.lang.String;
import java.lang.System;

public class Slot {
    public static void main(String[] A00) {
        int L00 = 100;

        BufferedReader L01 = new BufferedReader(
                new InputStreamReader(System.in));

        while (L00 > 0) {
            int L02 = 0;
            try {
                System.out.println("--------------------------");
                System.out.println("所持金：" + L00);
                System.out.print("いくら賭けますか？：");
                L02 = Integer.parseInt(L01.readLine());
                if (L00 < L02 || L02 <= 0) {
                    System.out.println("お客さん、冗談はやめてくださいよ。");
                    continue;
                }
                L00 -= L02;

            } catch (IOException L03) {
                System.out.println("入力エラーが発生したので終了します。");
                System.exit(1);
            } catch (NumberFormatException L04) {
                System.out.println("数字を入力してください。");
                continue;
            }

            System.out.print("スロットの数字：000");

            long L05 = System.currentTimeMillis() + 1000;

            int L06;

            do {
                L06 = (int)(Math.random() * 1000);
                System.out.printf("\b\b\b%03d", L06);
            } while (System.currentTimeMillis() < L05);

            System.out.println();

            if (L06 == 777) {
                L00 += (L02 * 1000);
                System.out.println("大当たり！");
            } else if (L06 % 111 == 0) {
                L00 += (L02 * 100);
                System.out.println("当たり！");
            }

        }
    }
}

/* ■ クラスの外でちょっと一言 ■
コマンドラインで遊ぶスロットマシーンです。掛け金を決めて、Enterキーを押
すと、スロットが回って数字が出ます。777で1000倍、7以外のゾロ目で100倍と
いう配当になってます。

mainメソッド一本でやっちゃったんで、ローカル変数が多く、変数名解析が案外
難しいかも。まず始めに「所持金」と「掛け金」の変数を特定するといいでしょ
う。

スロットの回転は、バックスペースで前の数字を消しながら、新しい数字を表示
することで表現しました。回転の時間は1秒間。システムの現在時間を利用して
計測してます。このシステム時間はエポックタイムなどと呼ばれ、1970年1月1日
0時0分0秒からの経過時間が、ミリ秒(1秒＝1000ミリ秒)で表されます。

ちなみに自分は1969年生まれ。コンピュータ的には「紀元前生まれ」って感じな
のかな。ちょっとショック。
 */
