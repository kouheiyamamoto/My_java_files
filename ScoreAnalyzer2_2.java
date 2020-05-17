// # 課題1のやつを使って課題2を作る
// わからんくなったらすぐ調べる！すぐネットを使う！
// あとはいかにしてメソッドにわけてメソッドの中のコードを短くするか
import java.util.HashMap;
import java.io.*;

public class ScoreAnalyzer2_2 {

    // runMethod
    void run(String[] args) throws IOException {
        Integer selectNum = Integer.parseInt(args[0]); // 引数の1つめの数字
        BufferedReader in = new BufferedReader(new FileReader(args[1])); // 引数の2つめの数字は読み込みファイルの指定
        analyze(selectNum, in);
    }

    // analyzeMethod
    // あと間違ってるのは、問題を受けた総数の計算だけ？
    void analyze(Integer n, BufferedReader in) throws IOException {
        HashMap<String, Integer> map = new HashMap<>(); // mapを宣言する
        String line;
        // 引数で指定されたファイルを1行ずつ空になるまで読み込んでいく処理
        while ((line = in.readLine()) != null) {
            String items[] = line.split(",");
            if (Integer.parseInt(items[2]) == n) { // 3番目の要素が問題番号であれば
                Integer getScorePeople = map.get(items[4]); // スコアをキーとしてmapから人数をgetする。
                if (getScorePeople == null) {
                    getScorePeople = 0;
                }
                getScorePeople++;
                map.put(items[4], getScorePeople);
            }
        }
        in.close();
        Integer amountOfPeople = countAmountOfPeople(map);
        //printMap(map, amountOfPeople);
        
         // 最終的な出力の部分
         // ループ処理する
         for (HashMap.Entry<String, Integer> s : map.entrySet()) {
            System.out.printf("%s,%2.3f", s.getKey(), s.getValue().doubleValue() * 100.0 / amountOfPeople);
        }
    }

    // return countPeople
    Integer countAmountOfPeople(HashMap<String, Integer> mp){
        Integer count = 0;
        for (String key : mp.keySet()) {
            count += mp.get(key);
        }
        return count;
    }

    // resultPrint 
    void printMap(HashMap<String, Integer> mp, Integer people){
         // ループ処理する
         for (HashMap.Entry<String, Integer> s : mp.entrySet()) {
            System.out.printf("%s: %2.3f%% (%d/%d)%n", s.getKey(), s.getValue().doubleValue() * 100.0 / people,
                    s.getValue(), people);
        }
    }

    // mainMethod
    public static void main(String[] args) throws IOException {
        ScoreAnalyzer2_2 step2 = new ScoreAnalyzer2_2();
        step2.run(args);
    }
}