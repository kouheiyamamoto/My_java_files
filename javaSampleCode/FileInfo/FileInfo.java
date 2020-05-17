/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "FileInfo"
 * FileInfo.java 「ファイルの様々な情報を取得」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac FileInfo.java
 *     >java FileInfo
 * 【キーワード】
 *     絶対パス(absolute path), 相対パス(relative path),  *     URL(Uniform Resource Locator), java.util.Formatterクラス, 
 * 【試してみよう】
 *     ファイルが存在するかどうかのチェックを入れる。 *     フォルダの情報を取得してみる。
 */
import java.io.File;
import java.lang.String;
import java.lang.System;
import java.net.MalformedURLException;

public class FileInfo {
    static final String C00 = "data/sample.txt";

    public static void main(String[] A00) {
        File L00 = new File(C00);
        
        System.out.println("絶対パス　　" + L00.getAbsolutePath());
        try {
            System.out.println("URL 　　　　" + L00.toURL());
        } catch (MalformedURLException e) {
            System.out.println("URLに変換できませんでした。");
        }
        System.out.println("パス名　　　" + L00.getPath());
        System.out.println("ファイル名　" + L00.getName());
        System.out.printf("更新日時　　%1$tD %1$tT%n", L00.lastModified());
        System.out.printf("サイズ　　　%dバイト%n", L00.length());
        System.out.println("絶対パス？　　　" + L00.isAbsolute());
        System.out.println("ディレクトリ？　" + L00.isDirectory());
        System.out.println("ファイル？　　　" + L00.isFile());
    }
}

/* ■ クラスの外でちょっと一言 ■
一口にファイルを指定するといっても、いくつかの方法があります。「絶対パ
ス」「相対パス」「URL」とあるんですが、それぞれの変換に便利なのがFileク
ラスです。

今回のサンプルでは、"data/sample.txt"という実行時のフォルダからの「相対
パス」でファイルを指定しています。そこから「絶対パス」「URL」を取得して
ますので、表示を見比べてその違いを理解してください。

また、Fileクラスでは、そのファイルに関する情報を取得することも出来ます。
このサンプルではその中のいくつかを表示してますが、他にも取得できる情報が
ありますので調べてみてください。
 */
