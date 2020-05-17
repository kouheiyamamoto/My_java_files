import java.util.HashMap;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.Map;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;

public class ScoreAnalyzer2ryuusei{
    HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
    HashMap<String, Integer> scores = new HashMap<>();
    ArrayList<String> gradelist = new ArrayList<>(); //点数の記憶

    void run(String[] args) throws IOException{
        File file = new File(args[0]);
        Analyze(file);
        //以下はデバッグ
        System.out.println(map.get("2").get("1"));
        System.out.println(gradelist);
        printResult();
    }
    //コマンドライン引数で渡された文字列をファイルとして順に処理
    void Analyze(File file) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;

        while((line = in.readLine()) != null){//一行ずつ読み込む
            String[] items = line.split(",");
            Registration(items);//マップの登録
        }
        Collections.sort(gradelist);
        //RatioCalculation(examineeCount,);
        in.close();
    }
    //マップの登録
    void Registration(String[] items) throws IOException{
        if (!map.containsKey(items[2])) { //課題番号が入っていない時初期化
            map.put(items[2], new HashMap<String, Integer>());
        }
        if (!gradelist.contains(items[4])) { //点数が入っていない場合初期化
            gradelist.add(items[4]);
        }
        scores = map.get(items[2]);
        Integer numberOfAssingnment = scores.get(items[4]);//スコアの人数
        if (numberOfAssingnment == null) {//当該スコアの人数がnullのとき0で初期化
            scores.put(items[4], 0);
        }
        scores.put(items[4], scores.get(items[4])+1); //人数を１足して再登録
        //map.get(items[2]).put(items[4], map.get(items[2]).get(items[4])+1); //人数を１足して再登録
    }
    //受験者数を調べる
    Double CountPeople() throws IOException{
        Double sumAll = 0.0;

        for(String scoreKey:scores.keySet()){
            sumAll += Double.valueOf(scores.get(scoreKey));
        }
        return sumAll;
    }
    //ある得点を取った人の人数を調べる
    Double GradeNum(String num){
        Double sumGrade;
        sumGrade = Double.valueOf(scores.get(num));
        return sumGrade;
    }
    //結果の出力
    void printResult() throws IOException{
        for (Integer i = 0; i < gradelist.size(); i++) {//１行目の出力
            System.out.print("," + gradelist.get(i));
        }
        System.out.println();
        for (String number: map.keySet()) {//問題番号
            System.out.print(number);//問題番号の表示
            for (Integer i = 0; i < gradelist.size(); i++) {//各点数
                printRatio(i);
            }
            System.out.println();
        }
    }
    //スコアの割合の出力
    void printRatio(Integer score) throws IOException{
        //点数を取った人がいなかった場合
        if (scores.get(gradelist.get(score)) == null) {
            System.out.print(",");
        }else{
            Double examineeCount = CountPeople();//全体人数
            Double numScore = GradeNum(gradelist.get(score));//その得点を取った人数
            Double ratio = numScore / examineeCount * 100;
            System.out.printf(",%2.3f", ratio);
        }
    }
    public static void main(String[] args) throws IOException{
        ScoreAnalyzer2ryuusei result = new ScoreAnalyzer2ryuusei();
        result.run(args);
    }
}
