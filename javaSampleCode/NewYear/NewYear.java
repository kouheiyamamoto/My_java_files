/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "NewYear"
 * NewYear.java 「正月までの日にちを求める」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac NewYear.java
 *     >java NewYear
 * 【キーワード】
 *     カレンダーフィールド(calendar fields), 書式文字列(format string), *     java.util.Formatterクラス, 
 * 【試してみよう】
 *     次の誕生日まで何日か求める。
 */
import java.lang.String;
import java.lang.System;
import java.util.Calendar;
import static java.util.Calendar.DAY_OF_YEAR;

public class NewYear {
    public static void main(String[] A00) {
        Calendar L00 = Calendar.getInstance();
        int L01 = L00.get(DAY_OF_YEAR);
        int L02 = L00.getActualMaximum(DAY_OF_YEAR);
        
        System.out.printf("あと%d回寝ると、お正月。%n", L02 - L01 + 1);
    }
}

/* ■ クラスの外でちょっと一言 ■
java.utilパッケージには、Dateクラス、Calendarクラスという、似たような感
じのクラスが存在します。単純にエポックタイム（1970年1月1日00:00:00からの
経過時間）を扱うときはDate、日付を扱うときはCalendarというのが一般的な使
い分けです。

ここで、不思議なのが「なぜDateクラスで日付を処理しないのか？」ということ
ですよね。実は、JDK1.0のときはDateで日付の処理を行ってました。しかし、
1.1でCalendarが登場して以降は、「年月日時分秒」はこのCalendarの担当に
なって、Dateに残された仕事は「ミリ秒」のみになってしまいました。APIをド
キュメントを見てみると、多くのメソッドが非推奨になっているのが分かると思
います。

そういう事情から、Dateクラスは「日付」と名乗りながら「日付」を処理するこ
とが許されない、悲しい存在になってます。試合に使ってもらえないベテラン野
球選手みたいで、思わず同情しちゃいそうですが、でもまあ、使えないもんは
しゃーないんで、このサンプルではもちろんCalendarを利用してます。

ちなみに、非推奨メソッドが多いからといって、Dateクラス自体が非推奨という
わけじゃありません。Date型を引数にとるメソッドはたくさんあります。
Calender→Dateの変換はCalendar#getTimeメソッドで、Date→Calendarの変換は
Calendar#setTimeメソッドで行いますので、覚えておいてください。

誕生日までの日数を求めるには、今年の誕生日を過ぎたかどうかで場合分けする
必要があります。その処理がポイントになりますね。
 */
