// * 854030 山本昂平
// わからんくなったらすぐ調べる！すぐネットを使う！
// あとはいかにしてメソッドにわけてメソッドの中のコードを短くするか
import java.util.HashMap;
import java.io.*;

public class ScoreAnalyzer1method {

    // runMethod
    void run(String[] args) throws IOException {
        Integer selectNum = Integer.parseInt(args[0]); // 引数の1つめの数字
        BufferedReader in = new BufferedReader(new FileReader(args[1])); // 引数の2つめの数字は読み込みファイルの指定
        analyze(selectNum, in);
    }

    // analyzeMethod
    void analyze(Integer n, BufferedReader in) throws IOException {
        HashMap<String, Integer> map = makeMethod(in, n); // mapを宣言する
        Integer amountOfPeople = countAmountOfPeople(map);
        printMap(map, amountOfPeople);
    }

    HashMap<String, Integer> makeMethod(BufferedReader in, Integer n) throws IOException {
        String line;
        HashMap<String, Integer> mp = new HashMap<>();
        // 引数で指定されたファイルを1行ずつ空になるまで読み込んでいく処理
        while ((line = in.readLine()) != null) {
            String items[] = line.split(",");
            Integer subjectNum = Integer.parseInt(items[2]);
            Integer people;
            if (subjectNum == n) { // 3番目の要素が問題番号であれば
                p = getScorePeople(mp);
                mp.put(items[4], getScorePeople);
            }
        }
        in.close();
        return mp;
    }

    Integer People = mp.get(items[4]); // スコアをキーとしてmapから人数をgetする。
                if (People == null) {
                    People = 0;
                }
                // TODO: インクリメントはputの中で1行でできる
                getScorePeople++;
                mp.put(items[4], getScorePeople);

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
        for (HashMap.Entry<String, Integer> s : mp.entrySet()) {
            System.out.printf("%s: %2.3f%% (%d/%d)%n", s.getKey(), s.getValue().doubleValue() * 100.0 / people,
                    s.getValue(), people);
        }
    }

    // mainMethod
    public static void main(String[] args) throws IOException {
        ScoreAnalyzer1method step1 = new ScoreAnalyzer1method();
        step1.run(args);
    }
}