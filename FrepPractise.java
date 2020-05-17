import java.io.*; // ファイル読み込みのためのimport
import java.util.ArrayList;
import java.util.HashMap;

public class Frep {

    void run(String[] args) throws IOException {
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        BufferedReader in = new BufferedReader(new FileReader(args[0])); // 入力されたファイルを1行ずつ読み込む
        frep(in, result); // 同じ単語を数えるメソッド
    }

    // ファイルを読み込んで読み込んだファイル内の同じ単語の出てくる数を数えるためのメソッド
    void frep(BufferedReader id, HashMap<String, Integer> map) throws IOException {
        ArrayList<String> list = new ArrayList<>(); // 文字列を格納していくためのリスト
        String line; // 1行ずつ読み込んだ文字列を代入するための変数
        Integer count = 0;
        // ファイルを１行ずつ読み込む
        while ((line = id.readLine()) != null) {
            String[] words = line.split(" ");

            for (Integer i = 0; i < words.length; i++) {
                if (words[i].equals(words[i + 1])) {
                    count = map.get(words[i]) + 1;
                    map.put(words[i], count);
                }else{
                    map.put(words[i], 1);
                }
                System.out.println(map);
            }
        }
        id.close();
    }

    String stripQuote(String item) {
        if (item.matches("\".*\"")) {
            return item.substring(1, item.length() - 1);
        }
        return item;
    }

    public static void main(String[] args) throws IOException {
        Frep word = new Frep();
        word.run(args);
    }
}