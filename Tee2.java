import java.io.*;

public class Tee2 {
    void run(String[] args) throws IOException {

        BufferedReader in;
        // コマンドライン引数が1つしか与えられなかった場合．
        if (args.length == 1) {
            in = new BufferedReader(new InputStreamReader(System.in));
        } else {
            in = new BufferedReader(new FileReader(args[1]));
        }
        PrintWriter out = new PrintWriter(new FileWriter(new File(args[0]))); // 標準入力から受け取るから標準出力から受け取る
        this.tee(in, out);
        in.close(); // 読み込む方のストリームを終了する
        out.close(); // 書き込む方のストリームを終了する
    }

    // 標準入力のファイルを標準出力で表示する。
    void tee(BufferedReader in, PrintWriter out) throws IOException {
        String line;
        // 1行ずつ読み取っていく
        while ((line = in.readLine()) != null) {
            
            System.out.printf("%s%n",line);
            out.println(line); // 出力ファイルに書き出し
        }
        in.close();
    }

    // mainメソッドは省略．
    public static void main(String[] args) throws IOException {
        Tee2 copy = new Tee2();
        copy.run(args);
    }
}