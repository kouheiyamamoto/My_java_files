// * 854030 山本昂平
// わからんくなったらすぐ調べる！すぐネットを使う！
// あとはいかにしてメソッドにわけてメソッドの中のコードを短くするか
import java.util.HashMap;
import java.io.*;

public class ScoreAnalyzer2pre {
    HashMap<String, Integer> map = new HashMap<>(); // フィールド変数
    // runMethod
    void run(String[] args) throws IOException {
        Integer commandNumber = Integer.parseInt(args[0]); // 引数の1つめの数字
        BufferedReader loadFile = new BufferedReader(new FileReader(args[1])); // 引数の2つめの数字は読み込みファイルの指定
        analyze(commandNumber, loadFile);
    }

    // analyzeMethod
    void analyze(Integer cNum, BufferedReader file) throws IOException {
        String line;
        // 引数で指定されたファイルを1行ずつ空になるまで読み込んでいく処理
        while ((line = file.readLine()) != null) {
            String items[] = line.split(","); // 読み込んだ行をわける。
            addMap(items[2], items[4], cNum);
        }
        file.close();
        Integer amountOfPeople = countAmountOfPeople(map);
        printMap(map, amountOfPeople);
    }

    void addMap(String subNum, String score, Integer cNum) {
        if (Integer.parseInt(subNum) == cNum) { // 3番目の要素が問題番号であれば
            Integer getScorePeople = map.get(score); // スコアをキーとしてmapから人数をgetする。
            if (getScorePeople == null) {
                getScorePeople = 0;
            }
            getScorePeople++;
            map.put(score, getScorePeople);
        }
    }

    // return countPeople
    Integer countAmountOfPeople(HashMap<String, Integer> mp) {
        Integer count = 0;
        for (String key : mp.keySet()) {
            count += mp.get(key);
        }
        return count;
    }

    // resultPrint
    void printMap(HashMap<String, Integer> mp, Integer people) {
        // ループ処理する
        for (String key : mp.keySet()) {
            System.out.printf("%s, %f", key, mp.get(key).doubleValue() * 100.0 / people);
        }
    }

    // mainMethod
    public static void main(String[] args) throws IOException {
        ScoreAnalyzer2pre step1 = new ScoreAnalyzer2pre();
        step1.run(args);
    }
}