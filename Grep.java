// 共通するプログラムがあるか確認するプログラム
import java.io.*;

public class Grep{
    void run(String[] args) throws IOException{
            File file1 = new File(args[1]);
            grep(args,file1);
    }
    void grep(String[] args, File file) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(file)); // 1行ずつ読みとるやつ
        String line;
        while((line = in.readLine()) != null){ // 1行ずつ代入する
            if (line.contains(args[0])){ // 入力したキーワードと比較する
                System.out.printf("%s: %s%n",args[1],line);
            }
        }
        in.close();
    }
    public static void main(String[] args) throws IOException{
        Grep cat = new Grep();
        cat.run(args);
    }
}