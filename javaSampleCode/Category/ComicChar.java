/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Category"
 * ComicChar.java 「Setを使ったカテゴリー分類」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java Category
 * 【キーワード】
 *     コンストラクタ(constructor)
 * 【試してみよう】
 *     Category.javaを参照。
 */
import java.lang.String;

public class ComicChar {
    String I00;    // カテゴリー名
    String I01;    // キャラクター名

    public ComicChar(String A00, String A01) {
        this.I00 = A00;
        this.I01 = A01;
    }
}

/* ■ クラスの外でちょっと一言 ■
これは、単純にデータを管理するクラスです。comic_char.csvの形式が、
  [カテゴリー名],[キャラクター名]
のようになってますので、それぞれのデータを格納するフィールドを用意してい
ます。CSVファイルの行数分、このクラスのインスタンスが生成されますので、
CSVファイルの中身を確認しておいてください。

それにしても『北斗の拳』は熱いぜ！　熱くて死ぬぜ！
 */
