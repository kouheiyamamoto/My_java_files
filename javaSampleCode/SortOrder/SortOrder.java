/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "SortOrder"
 * SortOrder.java 「読み仮名順に名前をソート」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac SortOrder.java
 *     >java SortOrder
 * 【キーワード】
 *     無名インナクラス(anonymous inner class), 並べ替え(sort),  *     java.lang.Comparableインターフェース *     
 * 【試してみよう】
 *     50音の降順（逆順）で並べ替える。 *     Personクラスに年齢などを追加して、その項目で並べ替える。 *     コンパイル後、どんな.classファイルが出来たのか確認する。
 */
import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortOrder {

    class Person {
        String I00;
        String I01;

        public Person(String A00, String A01) {
            this.I00 = A00;
            this.I01 = A01;
        }
    }

    public SortOrder() {
        List<Person> L00 = new ArrayList<Person>();

        L00.add(new Person("小泉純一郎", "こいずみ じゅんいちろう"));
        L00.add(new Person("ペ・ヨンジュン", "ぺ よんじゅん"));
        L00.add(new Person("堀江貴文", "ほりえ たかふみ"));
        L00.add(new Person("王 貞治", "おう さだはる"));
        L00.add(new Person("プリティ長嶋", "ながしま ぷりてぃ"));

        System.out.println("---- 並び替え前 ----");
        for (Person L01 : L00) {
            System.out.printf("%s(%s)%n", L01.I00, L01.I01);
        }

        Collections.sort(L00, new Comparator<Person>() {
            public int compare(Person A00, Person A01) {
                return A00.I01.compareTo(A01.I01);
            }
        });

        System.out.println("\n---- ５０音順 ----");
        for (Person L02 : L00) {
            System.out.printf("%s(%s)%n", L02.I00, L02.I01);
        }
    }

    public static void main(String[] args) {
        new SortOrder();
    }
}

/* ■ クラスの外でちょっと一言 ■
自分で設計したクラスのインスタンスを並べ替えるには、前もってComparableイ
ンターフェースを実装しておく方法と、ソート時にComparatorを指定する方法の
２つがあります。今回紹介するのは後者の方。この方法なら、指定する
Comparatorを変えることで、様々な順序に並べ変えることが可能です。

このサンプルには２つのインナークラスが登場します。インナークラスとはクラ
スの中に定義されたクラスのこと。１つはPersonクラス。これは分かりやすいで
すよね。もう１つは、Collections.sortメソッドの引数の中で無名（匿名）イン
ナークラスとして定義されています。

無名インナークラスってのは、クラス定義の省略形で、ほんの数行、しかも他か
ら参照されないようなその場限りのクラスを作る場合に、「わざわざ名前をつけ
て定義するほどでもねーな」ってときに使います。ただし、あまり長い無名イン
ナークラスを作ってしまうと、処理の流れが見えにくくなってしまいます。そう
いう場合には、通常の名前つきインナークラスで記述すべきですね。

J2SE 5.0の新機能「ジェネリックス」はListやMapなどのコレクション系が有名
ですが、Comparatorにも使えます。Object型をキャストしなくていいですし、間
違って違う型を渡す心配もなく、安全ですね。
 */
