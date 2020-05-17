/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Hokaben"
 * Hokaben.java 「Mapを使ってデータ管理」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Hokaben.java
 *     >java Hokaben
 * 【キーワード】
 *     コレクションフレームワーク(collections framework), *     ハッシュ法(hashing), データ検索アルゴリズム,  *     ジェネリックス(generics), ボクシング(boxing), アンボクシング(unboxing),
 * 【試してみよう】
 *     System.out.println(L00)で、マップの内容を表示してみる。 *     コマンドラインから弁当名を受け取って、価格を検索して表示する。
 */
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.String;
import java.lang.System;
import java.util.Map;
import java.util.HashMap;

public class Hokaben {
    public static void main(String[] args) {
        Map<String, Integer> L00 = new HashMap<String, Integer>();
        
        L00.put("のり弁当", 290);
        L00.put("から揚弁当", 390);
        L00.put("チキン南蛮弁当", 460);
        L00.put("デミハンバーグ弁当", 420);
        L00.put("シャケ弁当", 380);
        L00.put("ロースカツ弁当", 560);
        L00.put("幕の内弁当", 450);
        L00.put("ビーフカレー", 390);
        L00.put("親子丼", 390);
        L00.put("ビッグチキンカツ弁当", 390);

        System.out.println("～　弁当の金額を検索　～");
        M00(L00, "幕の内弁当");
        M00(L00, "チキン南蛮弁当");
        M00(L00, "フォアグラ弁当");
        M00(L00, "ビッグチキンカツ弁当");
    }

    public static void M00(Map<String, Integer> A00, String A01) {
        try {
            int L00 = A00.get(A01);
            System.out.printf("「%s」%d円%n", A01, L00);
        } catch (NullPointerException L01) {
            System.out.printf("「%s」はメニューにございません。%n", A01);
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
Mapは、今回の例でいえば「弁当名」と「値段」のような感じで、「キー」と
「値」がペアになった情報を扱うときに使います。データ量が増えても、キーで
検索すれば、値を素早く取り出せるのが特徴です。

Map<String, Integer>という宣言は、キーはString型、値はInteger型しかダメ
よ、という意味で、違う種類のデータが入ることを未然に防ぐ働きがあります。
実際には、putでデータを追加するときも、getで値を取り出すときも、基本型の
intを使ってますが、これはint型とInteger型が自動的に変換されるという機能
が可能にしている記述方法です。

Mapはあくまでもインターフェースですので、newする場合は、HashMap、
TreeMap、LinkedHashMapなどのクラスを使うことになります。それぞれ特徴があ
るんですが、今回は一番高速に動作するHashMapを採用しました。ただし変数は
Map型として宣言してますので、他のMap系クラスを使う場合も、newのところさ
え書き換えればOK。弁当価格検索メソッドを修正する必要はありません。

このように、「Mapインターフェースを実装したヤツなんでも来い」状態で変数
を宣言しておくと、後々、ソースコードの再利用性が高まるわけですね。オブ
ジェクト指向に慣れていないと、いまひとつピンと来ないかもしれませんが、イ
ンターフェース経由でインスタンスをいじくるのが、Javaでは一つのスタイルに
なってますので、どんどん真似していって下さい。
 */
