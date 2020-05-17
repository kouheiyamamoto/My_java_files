/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "ArraySort"
 * ArraySort.java 「Arraysで配列をソート」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac ArraySort.java
 *     >java ArraySort
 * 【キーワード】
 *     並び替え(sort), 自然順序付け(natural ordering), 昇順(ascending order), *     Comparable(比較可能)インタフェース, 配列(array)の長さ(length)
 * 【試してみよう】
 *     String型以外の配列をソートしてみる。 *     java.util.Comparatorを実装したクラスを作り、降順に並べ替える。
 */
import java.lang.String;
import java.lang.System;
import java.util.Arrays;

public class ArraySort {
    public static void main(String[] A00) {
        String[] L00 = { "ウインナー", "アンチョビ", "オニオン", "イカ", "エビ" };

        System.out.println("並び替え前");
        M00(L00);

        Arrays.sort(L00);

        System.out.println("並び替え後");
        M00(L00);
    }

    public static void M00(String[] A00) {
        for (int L00 = 0; L00 < A00.length; L00++) {
            System.out.printf("%d番目：%s%n", L00 + 1, A00[L00]);
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
文字列を並べ替えた場合、文字コードの昇順(小さい順)に並びます。この順序を
決定付けているのは、Stringクラスが実装しているjava.lang.Comparableイン
ターフェースのcompareToメソッドです。一度APIドキュメントで確認しておいて
ください。
初めて見るクラスやメソッドに出会ったら、とりあえずAPIドキュメントで調べ
る癖をつけておくと、いいですよ。最初はチンプンカンプンかもしれませんが、
これも一つのトレーニングと心得て、面倒くさがらないようお願いします。

ここに出てきたforループは、配列を全部表示するための基本パターン。J2SE5.0
からは拡張forループを使って配列を全て走査することが可能になりましたが、
何番目の要素かを表示するために、あえて基本パターンを使ってます。

Arrays.sort()メソッドは、引数によって使用するアルゴリズムが違うみたい
で、int,doubleなどの基本型配列の場合はクイックソート、StringやIntegerの
ような参照型配列の場合はマージソートが使われるそうです。興味のある方は調
べてみてください。

ちなみに、皆さんはピザのトッピングは何が好きですか？　僕がこの中から選ぶ
とすれば、アンチョビ＆オニオンあたりかな……なんだかピザを食べたくなって
きたぞ。
 */
