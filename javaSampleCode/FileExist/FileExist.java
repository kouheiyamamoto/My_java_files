/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "FileExist"
 * FileExist.java 「ファイルの存在チェック」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac FileExist.java
 *     >java FileExist
 * 【キーワード】
 *     抽象パス名(abstract pathname), ディレクトリ(directory), ファイル(file)
 * 【試してみよう】
 *     ディレクトリが存在するかどうか調べる。 *     ファイルが存在した場合に、その絶対パスを表示する。
 */
import java.io.File;
import java.lang.String;
import java.lang.System;

public class FileExist {
    public static void main(String[] A00) {
        String[] L00 = {"FileExist.java", "Love256.java", "FileExist.class"};

        for (String L01 : L00) {
            File L02 = new File(L01);
            if (L02.exists() && L02.isFile()) {
                System.out.printf("ファイル「%s」は存在します。%n", L01);
            } else {
                System.out.printf("ファイル「%s」は存在しません。%n", L01);
            }
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
ファイルの存在チェックには、オープンするときに、FileNotFoundExceptionを
捕まえる方法と、このFileクラスを使う方法があります。ファイルを読み書きす
るのなら、例外で対応してもいいですが、単純に存在をチェックするだけなら、
Fileクラスの方が簡単ですね。

ファイルが「存在しない」ことを想定しながら、プログラムを組むのが基本。
とはいえ、この『愛のJava256本ノック』でも、「存在する」ことを前提とした
箇所がいくつかあります。そんな場所を見つけたら、きちんと対処するよう修正
してください。手抜きじゃないっすよ。皆さんへの愛の試練として、わざと残し
てるんですからね。「作りこみ腹八分目」がモットーなんですから。マジで。
 */
