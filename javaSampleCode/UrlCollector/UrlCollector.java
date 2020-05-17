/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "UrlCollector"
 * UrlCollector.java 「正規表現を使ってWebサイトからリンクを抽出」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac UrlCollector.java
 *     >java UrlCollector
 * 【キーワード】
 *     URL(Uniform Resource Locator), 検索ロボット(search robot),  *     正規表現(regular expression), java.util.regex.Patternクラス,
 * 【試してみよう】
 *     収集したURLをもとに、さらにURLを収集する。 *     Webページに含まれる画像のリンクを収集する。
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.lang.System;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlCollector {
    static final String C00 = "http://www.groovy-number.com/link.html";
    static final String C01 = "<a href=\"([^\"]+)\">";

    public static void main(String[] A00) {
        System.out.printf("[%s]から、URLを検索...%n", C00);
        int L00 = 0;

        try {
            URL L01 = new URL(C00);
            BufferedReader L02 = new BufferedReader(new InputStreamReader(
                    L01.openStream()));

            String L03;
            Pattern L04 = Pattern.compile(C01, Pattern.CASE_INSENSITIVE);

            while ((L03 = L02.readLine()) != null) {
                Matcher L05 = L04.matcher(L03);
                while (L05.find()) {
                    L00++;
                    System.out.println(L05.group(1));
                }
            }
            
            L02.close();
        } catch (IOException L06) {
            System.out.println("ページ読み込み中にエラーが起きました。");
        }

        System.out.println(L00 + "件のURLを発見しました。");
    }
}

/* ■ クラスの外でちょっと一言 ■
Googleに代表される「ロボット型検索エンジン」というのがあります。これは検
索ロボット（クローラー、スパイダーとも呼ばれる）が、全世界のWebサイトを
自動的に巡回して、Webページをデータベースに保存していく仕組みになってま
す。

その巡回の基本になってるのが、このサンプルのように、あるページに含まれる
リンクを抜き出し、それを次々にたどることで、ページを収集する手法です。ち
なみに、2005年3月現在、Googleは16億以上のURLを集めているとのこと。すご
いっすね。

リンクを抜き出す正規表現は、"<a href=\"([^\"]+)\">"となってます。これ
は、<a href="～">という文字列のパターンを意味します。「～」の部分には
「[^\"]+」という表現で、「ダブルクオーテーション(")以外(^)の文字が1文字
以上(+)」という指定をしています。「()」は文字のグループ化を表し、パター
ンにマッチした場合、抜き出したい部分を囲んでいます。

そのパターンをコンパイルするときに指定した「CASE_INSENSITIVE」は、大文字
小文字を区別しないという意味。つまり<A HREF="～">というタグもOKというこ
とです。

Matcherのfindメソッドは、先頭からパターンにマッチする部分をサーチしま
す。さらに前回発見した位置を保持してますので、再度findメソッドを呼び出し
たら、その位置から後ろを探してくれます。whileループと組み合わせれば、一
行に複数のリンクが存在する場合に対応できますね。

実はこの正規表現、かなり手抜きです。URLを"で囲ってないのはダメ、シングル
クオーテーション(')で囲ってもダメ、href以外の属性があるのもダメ、aの後ろ
にスペースが2つ以上あってもダメ……となってます。ぜひ、より許容範囲の広
い正規表現のパターンを調べてみてください。
 */
