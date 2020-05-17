// ? 全体的に問題の意味がわからん
// #まずは紙に書いて問題を整理しやなあかんなと思った。
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Last1 {
    
    void run(String[] args) throws IOException{
        // コマンドライン引数が渡されなかった場合は考えなくてよい。
        for (Integer i = 0; i < args.length; i++) {
            Integer selectNum = Integer.parseInt(args[0]);
            BufferedReader in = new BufferedReader(new FileReader(args[1])); // 1行ずつ読みとるやつ
            analyse(selectNum, in);
        }
    }

    void analyse(Integer n, BufferedReader in) throws IOException{
        HashMap<String, Integer> map = new HashMap<>(); // mapを宣言
        String line; // 読み取ったファイルを1行ずつ分けて行くための変数
        // 読み込んだファイルを最後の行まで読み込むためのループ
        while((line = in.readLine()) != null){
            String[] items = line.split(","); // 読み込んだ行を,で区切って一つ一つ配列に格納する。
            Integer examineeCount;
            // コマンドライン引数で指定された問題の番号の時
            if(Integer.parseInt(items[2]) == n){
                Integer count = map.get(items[4]);
                if(count == null){
                    count = 0;
                }
                map.put(items[4], count++);
            }
            examineeCount = count;
            for(String key : map.keySet()){
                map.put(items[4], count);
            }
            System.out.printf("%s: %f (%d/%d)", items[4]);
        }
        in.close();
    }

    public static void main(String[] args) throws IOException{
        Last1 step1 = new Last1();
        step1.run(args);
    }
}