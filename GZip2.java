import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.InflaterInputStream;
import java.io.*;

// さっきのzipのやつの改訂版
public class GZip2 {

    void run(String[] args) throws IOException {
        if (args.length == 0) { // もしもコマンドライン引数になにも入力がなかったら
            System.out.println("Please select file.");
        } else {
            for (Integer i = 0; i < args.length; i++) {
                // ? ここの変数宣言はinだけでいいのか
                gzip(args[i]);
            }
        }
    }

    // 指定されたファイルをzip化するためのメソッド
    void gzip(String name) throws IOException {
        
        File initialin = new File(name); // File型でファイル名を受け取る
        InputStream in = new FileInputStream(initialin); // ファイル読み込む
        File initialout = new File(name + ".gz"); // File型で内容を書き出す
        GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(initialout)); // (3) // ファイル名プラス".gz"というファイルに出力する
        
        Integer data; // バイトずつ読み込むからこうなります
        while ((data = in.read()) != -1) {
            out.write(data); // データを１文字書き出す．
        }
        Double parcent = 100*( (double)(initialout.length()) / (double)(initialin.length()) );
        //System.out.println(name + ": " + initialin.length() + " bytes -> " + initialout.length() + " bytes " + "(" + parcent + "%)");
        System.out.printf("%s : %d bytes -> %d bytes (%2.2f%%)", name, initialin.length(), initialout.length(), parcent*100.0);
    }
    public static void main(String[] args) throws IOException {
        GZip2 zip = new GZip2();
        zip.run(args);
    }
}