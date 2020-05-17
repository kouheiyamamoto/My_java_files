/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "CsvData"
 * CsvData.java 「CSVファイルを読み込む」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac CsvData.java
 *     >java CsvData
 * 【キーワード】
 *     CSV(Comma Separated Values:カンマ区切りデータ),  *     正規表現(regular expression), 例外(exception),  *     IO(Input/Output:入出力), ストリーム(stream:流れ), 
 * 【試してみよう】
 *     finally節を利用し、例外が発生しても確実にファイルをクローズするようにする。 *     ExcelのシートをCSV形式で出力して、Javaで読み込み表示する。
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.lang.System;

public class CsvData {
    public static void main(String[] A00){
        String L00 = "busyo.csv";

        try {
            BufferedReader L01 = new BufferedReader(new FileReader(L00));
            String L02;
            while( (L02 = L01.readLine()) != null ) {
                String[] L03 = L02.split(",");
                System.out.printf("%s [政治:%3s 軍事:%3s 智謀:%3s 野望:%3s]%n",
                        L03[0], L03[1], L03[2], L03[3], L03[4]);
            }
            L01.close();
        } catch(FileNotFoundException L04) {
            System.out.println(L00 + "が見つかりませでした。");
        } catch(IOException L05) {
            System.out.println(L00 + "を読み込めませんでした。");
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
CSVとは「データをカンマで区切りで記述したテキストファイル」のことです。
busyo.csvファイルをエディタで開いて中身を確認しておいてください。Excelの
データを利用したいときは、*.csv形式で書き出しておいて、このようにして読
み込めばＯＫです（Jakarta POIで直接読む方法もあります）。

文字の分割を行っているsplitメソッドは、正規表現(java.util.regexパッケー
ジ)が採用されたJ2SE1.4で、新たに追加されたメソッドです。それまでは、
java.util.StringTokenizerを利用して、whileループで取り出していたんです
が、一発で配列に変換できるようになって便利になりましたね。

ちなみに、僕が最も愛する戦国シミュレーションゲームは、システムソフトの
『天下統一』。シンプルなシステムと、九州の武将のパラメータが高いところが
グッドです。
 */
