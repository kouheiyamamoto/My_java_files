// 練習問題 第8講 第4問 854030 山本昂平
import java.io.*;

public class Tee {
    // runMethod
    void run(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(new FileReader(args[0])); // 行単位でファイルの読み取り
        BufferedWriter out = new BufferedWriter(new FileWriter(args[1])); // 行単位でファイルの書き込み

    
    }

    // teeMethod
    void tee(BufferedReader in, BufferedWriter out) throws IOException {
        String line;
        while ((line = in.readLine()) != null) {
            // １行ずつ処理を行う．
        }
        in.close();
    }

    public static void main(String[] args) throws IOException {
        Tee cat = new Tee();
        cat.run(args);
    }
}