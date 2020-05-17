// 第9講　小テスト
// UNIXのcpコマンドを作成する。

import java.io.*; // いろんなFile型を扱うためにimport

public class Copier_854030 {
    void run(String[] args) throws IOException { // throws IOExceptionは例外処理
        FileReader in = new FileReader(args[0]); // こっちのinが読み込む方
        FileWriter out = new FileWriter(args[1]); // こっちのoutは書き込む方
        this.copy(in, out);
        in.close(); // 読み込む方のストリームを終了する
        out.close(); // 書き込む方のストリームを終了する
    }

    // コマンドライン引数で受け取った1つ目のファイルを2つ目のファイルにコピーするためのメソッド
    void copy(FileReader in, FileWriter out) throws IOException {
        int data;
        while ((data = in.read()) != -1) { // １文字ずつ読み込み，
                                           // データが読み込めなくなるまで繰り返す．
            out.write(data); // データを１文字書き出す．
        }
    }
    // mainメソッド
    public static void main(String[] args) throws IOException {
        Copier_854030 test = new Copier_854030();
        test.run(args);
    }
}