/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "MondayCalendar"
 * MondayCalendar.java 「月曜日から始まるカレンダーを作成」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac MondayCalendar.java
 *     >java MondayCalendar
 * 【キーワード】
 *     Staticインポート, java.util.Formatterクラス, 
 * 【試してみよう】
 *     月曜以外の曜日から始まるようにする。
 */
import java.lang.String;
import java.lang.System;
import java.util.Calendar;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONDAY;

public class MondayCalendar {
    public static void main(String[] A00) {
        Calendar L00 = Calendar.getInstance();
        int L01 = L00.get(YEAR);
        int L02 = L00.get(MONTH);
        L00.set(L01, L02, 1);
        int L03 = L00.getActualMaximum(DAY_OF_MONTH);
        int L04 = L00.get(DAY_OF_WEEK);

        System.out.printf("　～ %d年%2d月 ～　%n", L01, L02 + 1);
        System.out.println("月 火 水 木 金 土 日");

        // 空白の個数を求める
        int L06;
        if (L04 < MONDAY) {
            L06 = (L04 + 7) - MONDAY;
        } else {
            L06 = L04 - MONDAY;
        }

        int L05 = 0;

        for (int L07 = 0; L07 < L06; L07++) {
            System.out.print("   ");
            L05++;
        }

        for (int L08 = 1; L08 <= L03; L08++) {
            if (L05 < 6) {
                System.out.printf("%2d ", L08);
            } else {
                System.out.printf("%2d%n", L08);
            }
            L05 = ++L05 % 7;
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
以前、ヨーロッパを旅行したときに、お土産にカレンダーを買ったんですが、そ
のカレンダーは、月曜から始まって日曜で終わる曜日の配列になってました。確
かに「月曜仕事始め、土日は週末」というのが実際の感覚ですよね。で結局、そ
の配列が気に入って、誰にもあげずに自分で使うことにしました。このプログラ
ムはそのカレンダーを再現しています。

プログラム自体はそれほど長くないんですが、処理のロジックを解読するのは難
しいかもしれません。「その月の1日の曜日から空白の個数を求める」「7つ数字
を出力するごとに改行を入れる」というのがヒントです。

世の中には様々な就業形態の人がいると思うので「自分は水曜日が週の始まり
だ！」って人はWednesdayCalendarに挑戦してみてください。
 */
