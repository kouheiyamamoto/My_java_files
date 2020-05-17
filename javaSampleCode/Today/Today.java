/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Today"
 * Today.java 「今日の日付を表示する」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Today.java
 *     >java Today
 * 【キーワード】
 *     java.util.Dateクラス, java.util.Formatterクラス, fromat(書式化する), *     ファクトリ(factory)メソッド
 * 【試してみよう】
 *     それぞれの手法で、年や時間も表示する。 *     
 */
import java.lang.String;
import java.lang.System;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Today {
    public static void main(String[] A00) {
        Calendar L00 = Calendar.getInstance();

        // 日付曜日を一つずつ取得
        String[] L01 = {"日", "月", "火", "水", "木", "金", "土"};
        int L02 = L00.get(Calendar.MONTH) + 1;
        int L03 =  L00.get(Calendar.DAY_OF_MONTH);
        int L04 =  L00.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.printf("今日は%02d月%02d日%s曜日です。%n", L02, L03, L01[L04]);

        // DateFormatを利用
        SimpleDateFormat L05 = new SimpleDateFormat("MM月dd日E曜日");
        System.out.printf("今日は%sです。%n", L05.format(L00.getTime()));

        // 一つのカレンダーオブジェクトから取得
        System.out.printf("今日は%1$tm月%1$td日%1$tAです。%n", L00);
    }
}

/* ■ クラスの外でちょっと一言 ■
人それぞれ、どうしても覚えられないことってあると思うんですが、僕の場合、
Javaで日付を表示する方法をすぐに忘れてしまいます。参考書の同じ部分を開い
ては、「前もここ見たな」と毎回つぶやいてる次第。

Calendarから日付を取り出す方法と、SimpleDateFormatで書式化する方法がある
んですが、そのどちらもが、多分に混乱しがちな要素を含んでるんですよね。月
は0から始まるのに、曜日は1からだったり、定数フィールドやら、パターン文字
列がいっぱいあったり……。

そんな僕の気持ちを知ってか知らずか、J2SE5.0からは、Calendarをprintfで
フォーマットするという、新たな方法が加わりました。もう、全部覚えるの無
理。あきらめます。

このサンプルではその３つの方法で同じ表示を実現しています。単純に出力する
ときはprintf、文字列として整形するときはSimpleDateFormatか、C言語でいう
sprintfにあたるString.formatメソッド、日付を数値として扱いたいときは
Calendarという使い分けになるでしょうね。
 */
