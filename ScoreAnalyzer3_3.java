import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// * 854030 山本昂平
// ? 学生IDは取得できた
// ? 問題番号も取得できた。
// ? あとはそこからどうすればいいのか
// ? どうやって点数を代入すればいいのか

public class ScoreAnalyzer3_3 {
    // StudentScore studentScore = new StudentScore();
    HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
    HashMap<String, Integer> subjectScore = new HashMap<>();

    void run(String[] args) throws IOException {
        BufferedReader loadFile = new BufferedReader(new FileReader(args[0]));
        analyze3(loadFile);
    }

    void analyze3(BufferedReader file) throws IOException {
        String line;
        // ファイルを1行ずつ読み込む
        while ((line = file.readLine()) != null) {
            subjectScore.put(key, value);
        }
 
        file.close();
    }

    public static void main(String[] args) throws IOException {
        ScoreAnalyzer3_3 subject3 = new ScoreAnalyzer3_3();
        subject3.run(args);
    }
}