import java.util.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.io.*;

public class GZip {

    void run(String[] args) throws IOException {
        if (args.length == 0) { // もしもコマンドライン引数になにも入力がなかったら
            System.out.println("Please select file.");
        } else {
            for (Integer i = 0; i < args.length; i++) {
                
                // ? ここの変数宣言はinだけでいいのか
                GZIPInputStream in = new GZIPInputStream(new FileInputStream(args[i])); 
                GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream("GZip"));

                gzip(in,out);
            }
        }
    }

    // 指定されたファイルをzip化するためのメソッド
    void gzip(GZIPInputStream id, GZIPOutputStream od) throws IOException {
        // ? 出力先のファイルはどうやって指定すればいいのか
        // ? ここのメソッド内でoutputするファイルを宣言するのか
        // ? あとは出力の仕方(明日になればできるであろう)
        Integer data; // バイトずつ読み込むからこうなります
        while ((data = id.read()) != -1) {
            od.write(data); // データを１文字書き出す．
        }
        System.out.println(id + ": " +)
    }
    public static void main(String[] args) throws IOException {
        GZip zip = new GZip();
        zip.run(args);
    }
}