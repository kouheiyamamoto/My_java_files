import java.util.*;
import java.io.*;

public class Frep {

    void run(String[] args) throws IOException {
        
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        String line;
        // 読み込んだファイルの中身を
        while ((line = in.readLine()) != null) {
            String[] words = line.split(" "); // 読み取った文字列を空白で区切る
            for (String word : words) { // wordsの配列をwordごとに区切って配列に分けてループする
                if (!map.containsKey(word)) { // mapの中身に単語が1つしか含まれていなかったら
                    map.put(word, 1); // その単語は1つしかmapに代入しない
                } else { // それ以外だったらmapのvalue部分の値をプラスしていく
                    map.put(word, map.get(word).intValue() + 1);
                }
            }
        }
        // mapの中身をkeyとvalue両方とも表示する
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        Frep count = new Frep();
        count.run(args);
    }
}
