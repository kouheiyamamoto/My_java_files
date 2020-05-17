import java.io.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;

public class Sincostan {

    void run(String[] args) throws IOException {
        Integer figure = this.makepro(new File(args[0]));
        this.kari1(new File(args[0]), figure);
    }

    Integer makepro(File file) throws IOException { // 問題番号が何番まであるのか
        Integer fig = 0;
        String line;
        BufferedReader in = new BufferedReader(new FileReader(file));
        while ((line = in.readLine()) != null) {
            String[] array = line.split(",");
            Integer mon = Integer.valueOf(array[2]);
            if (fig < mon) {
                fig = mon;
            }
 
        }
        // System.out.println();
        return fig;
    }

    void kari1(File file, Integer figure) throws IOException {
        HashMap<String, HashMap<String, Integer>> map = this.buildMap(file, figure);
        this.makescore(map, figure);
        System.out.println();
        this.printMap(map, figure);
    }

    void makescore(HashMap<String, HashMap<String, Integer>> map, Integer figure) throws IOException {// 得点を表示する
        // for(Integer i=1;i<=figure;i++){ //1個目のキーの問題番号を指定する
        String num = String.valueOf(figure);
        HashMap<String, Integer> scores = map.get(num);
        this.finalmakescore(scores);
        // }
    }

    void finalmakescore(HashMap<String, Integer> scores) throws IOException { // 得点を読み込んで出力する
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.printf(",");
            System.out.printf("%s", entry.getKey());
        }
    }

    void printMap(HashMap<String, HashMap<String, Integer>> map, Integer figure) {// 問題番号表示と割合を求める
        for (Integer i = 1; i <= figure; i++) { // 1個目のキーの問題番号を指定する
            String num = String.valueOf(i);
            HashMap<String, Integer> scores = map.get(num);
            System.out.printf("%d", i);
            this.print(scores, figure);
        }
    }

    void print(HashMap<String, Integer> scores, Integer figure) { // 割合を求めて出力する
        Integer examineeCount = 0;
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            Integer value = entry.getValue();
            examineeCount = examineeCount + value;
        }

        Double value1 = Double.valueOf(examineeCount);
        Double hyaku = 100.0;

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            Integer value = entry.getValue();
            String key = entry.getKey();
            Double doublevalue = Double.valueOf(value);
            Double pasent = hyaku / value1 * doublevalue;
            Integer anal = scores.get(key);
            if (anal == null) {
                System.out.printf(",");
            } else {
                System.out.printf(",%2.3f", pasent);
            }
        }
        System.out.println();

    }

    HashMap<String, HashMap<String, Integer>> buildMap(File file, Integer figure) throws IOException {// ファイルを読み込んでキーの問題番号ごとに得点、その人数をバリューする。

        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        for (Integer i = 0; i <= figure; i++) {
            String num = String.valueOf(i);
            map.put(num, new HashMap<String, Integer>());
        }
        String line;
        BufferedReader in = new BufferedReader(new FileReader(file));
        while ((line = in.readLine()) != null) {
            this.countFrequencies(map, line, figure);
        }
        return map;
    }

    void countFrequencies(HashMap<String, HashMap<String, Integer>> map, String line, Integer figure) {
        String[] array = line.split(",");

        // map.put(array[2],new HashMap<String,Integer>());//間違え

        HashMap<String, Integer> scores = map.get(array[2]);
        Integer count = scores.get(array[4]);

        if (count == null) {
            count = 0;
        }
        count = count + 1;
        map.get(array[2]).put(array[4], count);
    }

    public static void main(String[] args) throws IOException {
        Sincostan score = new Sincostan();
        score.run(args);
    }
}
