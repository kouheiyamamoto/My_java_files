import java.util.*;
import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Integer> tm = new TreeMap<String, Integer>();
        String line;
        while ((line = br.readLine()) != null) {
            // １：ファイルから文字列を読み込む

            String[] words = line.split(" ");
            // ２：文字列から単語を抽出する

            for (String word : words) {
                if (!tm.containsKey(word)) {
                    tm.put(word, 1);
                } else {
                    tm.put(word, tm.get(word).intValue() + 1);
                }
            }
        }
        for (String word : tm.keySet()) {
            System.out.println(word + tm.get(word));
        }
    }
}
