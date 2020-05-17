// 学籍番号 854030 
// 山本昂平

// 課題1のやつを使って課題2を作る
// わからんくなったらすぐ調べる！すぐネットを使う！
// あとはいかにしてメソッドにわけてメソッドの中のコードを短くするか
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.io.*;

public class ScoreAnalyzer2 {

    // フィールド変数達
    HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
    HashMap<String, Integer> score = new HashMap<>();
    ArrayList<String> scoreList = new ArrayList<>(); // 点数を代入するリスト
    ArrayList<String> sortScoreList = new ArrayList<>(); // 点数を重複しないように代入するリスト

    // runMethod
    void run(String[] args) throws IOException {
        BufferedReader loadFile = new BufferedReader(new FileReader(args[0])); // 読み込むファイルを指定
        analyze2(loadFile);
    }

    void analyze2(BufferedReader file) throws IOException {
        String line;
        Integer amountOfPeople = 0; // 試験を受けた人数の合計を代入する変数
        // 引数で指定されたファイルを空になるまで読み込んでいく
        while ((line = file.readLine()) != null) {
            String[] items = line.split(","); // 読み込んだ行を分ける
            addMap(items[2], items[4]);
            Integer numberOfScorePeople = score.get(items[4]);
            countNumberOfScorePeople(items[2], items[4], numberOfScorePeople);
        }
        file.close();
        makeScoreList(score);
        makeSortScoreList(scoreList);
        printSortScoreList(sortScoreList);
        System.out.println();
        allPrint(amountOfPeople, map, score);
    }

    void addMap(String subNum, String scoreNum) {
        if (map.get(subNum) == null) {
            score = new HashMap<String, Integer>();
            score.put(scoreNum, 0);
            map.put(subNum, score);
        }
        score = map.get(subNum);
    }

    void countNumberOfScorePeople(String subNum, String scoreNum, Integer scorePeople) {
        if (scorePeople == null) {
            scorePeople = 0;
        }
        scorePeople++;
        score.put(scoreNum, scorePeople);
        map.put(subNum, score);
    }

    void makeScoreList(HashMap<String, Integer> score) {
        for (HashMap.Entry<String, HashMap<String, Integer>> entry : map.entrySet()) {
            score = entry.getValue();
            for (HashMap.Entry<String, Integer> vertical : score.entrySet()) {
                scoreList.add(vertical.getKey());
            }
        }

    }

    void makeSortScoreList(ArrayList<String> scoreList) {
        sortScoreList = new ArrayList<String>(new HashSet<>(scoreList));
    }

    void printSortScoreList(ArrayList<String> sortScoreList) {
        for (Integer i = 0; i < sortScoreList.size(); i++) {
            System.out.printf(",%s", sortScoreList.get(i));
        }
    }

    void allPrint(Integer amountOfPeople, HashMap<String, HashMap<String, Integer>> map,
            HashMap<String, Integer> score) {
        for (HashMap.Entry<String, HashMap<String, Integer>> entry1 : map.entrySet()) {
            System.out.print(entry1.getKey());
            score = entry1.getValue();
            amountOfPeople = countAmountOfPeople(score);
            // for(HashMap.Entry<String, Integer> entry2 : score.entrySet()){
            for (Integer i = 0; i < sortScoreList.size(); i++) {
                String scoreNum = sortScoreList.get(i);
                if (score.get(scoreNum) == null) {
                    System.out.print(",");
                } else {
                    System.out.printf(",%2.3f",
                            score.get(scoreNum).doubleValue() * 100.0 / amountOfPeople.doubleValue());
                }
            }
            System.out.println();
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

    // mainMethod
    public static void main(String[] args) throws IOException {
        ScoreAnalyzer2 step2 = new ScoreAnalyzer2();
        step2.run(args);
    }
}