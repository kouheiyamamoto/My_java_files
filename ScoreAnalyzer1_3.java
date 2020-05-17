// わからんくなったらすぐ調べる！すぐネットを使う！
// あとはいかにしてメソッドにわけてメソッドの中のコードを短くするか
import java.util.HashMap;
import java.io.*;

public class ScoreAnalyzer1_3 {

    void run(String[] args) throws IOException {

        Integer selectNum = Integer.parseInt(args[0]); // 引数の1つめの数字
        BufferedReader in = new BufferedReader(new FileReader(args[1])); // 引数の2つめの数字は読み込みファイルの指定
        analyze(selectNum, in);
    }

    // あと間違ってるのは、問題を受けた総数の計算だけ？
    void analyze(Integer n, BufferedReader in) throws IOException {
        HashMap<String, Integer> map = new HashMap<>(); // mapを宣言する
        String line;
        Integer amountOfPeople = 0;
        // 引数で指定されたファイルを1行ずつ空になるまで読み込んでいく処理
        while ((line = in.readLine()) != null) {
            String items[] = line.split(",");
            if (Integer.parseInt(items[2]) == n) { // 3番目の要素が問題番号であれば
                Integer numberOfScorePeople = map.get(items[4]); // スコアをキーとしてmapから人数をgetする。
                if (numberOfScorePeople == null) {
                    numberOfScorePeople = 0;
                }
                numberOfScorePeople++;
                map.put(items[4], numberOfScorePeople); // これでその点とった人の人数が取得できる。
            }
        }
        in.close();
         // 試験受けた人の人数を出すためvalueを足し合わせた。
         for (String key : map.keySet()) {
            amountOfPeople += map.get(key);
        }
        // ループ処理する
        for (HashMap.Entry<String, Integer> s : map.entrySet()) {
            // System.out.println(s.getKey() + ":" + s.getValue());
            System.out.printf("%s: %2.3f%% (%d/%d)%n", s.getKey(), s.getValue().doubleValue() * 100.0 / amountOfPeople,
                    s.getValue(), amountOfPeople);
        }
    }

    public static void main(String[] args) throws IOException {
        ScoreAnalyzer1_3 step1 = new ScoreAnalyzer1_3();
        step1.run(args);
    }
}