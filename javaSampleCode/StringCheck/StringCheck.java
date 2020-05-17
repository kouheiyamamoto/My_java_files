/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "StringCheck"
 * StringCheck.java 「正規表現で入力文字が半角英数かどうかチェック」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac StringCheck.java
 *     >java StringCheck
 * 【キーワード】
 *     正規表現(regular expression), java.util.regex.Patternクラス, *     コマンドラインパラメータ, 配列の長さ(length)
 * 【試してみよう】
 *     郵便番号や電話番号のチェックを行う。 *     SwingのGUIで入力チェックを行う。 *     
 */
import java.lang.String;
import java.lang.System;

public class StringCheck {
    public static void main(String[] A00) {
        if (A00.length < 1) {
            System.out.println("使い方：>java StringCheck チェックする文字列");
            System.exit(1);
        }
        
        System.out.println("入力：" + A00[0]);
        if (A00[0].matches("[0-9a-zA-Z]+")) {
            System.out.println("チェック結果：半角英数のみの文字列です。");
        } else {
            System.out.println("チェック結果：半角英数以外の文字が含まれます。");
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
Webの登録フォームなどで、「入力は半角英数でお願いします」というのがあり
ますよね。その入力された文字のチェックに便利なのが正規表現。文字列がパ
ターンにマッチしているかどうか判定することが出来ます。

このサンプルでは"[0-9a-zA-Z]+"という表現で、「数字(0-9)もしくはアルファ
ベットの大文字(A-Z)小文字(a-z)の1回以上の繰り返し(+)」というパターンとの
チェックを行ってます。

正規表現の詳しい説明はAPIドキュメントの、java.util.regex.Patternクラスに
あるので、一度目を通しておいてください。String.matchesメソッドはその
Patternクラスを手軽に利用するためのメソッドになってます。

最近の1.4になって初めて、Javaで正規表現が標準サポートされたため、その解
説サイトは意外と少ないです。その点、Perlは伝統的に正規表現となじみが深
く、初心者に対する解説サイトもたくさんあります。多少Perlの正規表現とは違
いがあるものの、もっと正規表現を知りたいという人は、Perlの入門サイトも含
めて活用するといいでしょう。
 */
