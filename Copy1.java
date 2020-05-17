import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// 必要な import 文を書いてください．
public class Copy1 {
    void run(String[] args) throws IOException {
        if(args.length < 2){
            System.out.println("cp: コマンドライン引数には,少なくとも,コピー元,コピー先を指定する必要があります。");
        }else{
            // コマンドライン引数に必要な分のファイルが指定されているか確認する．
            File in = new File(args[0]);
            File out = new File(args[1]);
            copy(in, out);    
        }
    }

    // fromファイルを1行ずつよみこんでtoにコピーするメソッド
    void copy(File from, File to) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(from)); // 1行ずつ読み込むためにBufferedReaderに代入
        PrintWriter out = new PrintWriter(new FileWriter(to)); // 1行ずつ読み込んだファイルを書き出すためにPrintWriter
        String line;
        while((line = in.readLine()) != null) { // 読み込んだファイルの中身がなくなるまで
            out.print(line);
        }
        out.close();
    }
    // mainメソッド
    public static void main(String[] args) throws IOException {
        Copy1 copy = new Copy1();
        copy.run(args);
    }
}