// コマンドライン引数で与えられた郵便番号に対する住所を表示するプログラム
import java.util.HashMap;
import java.io.*;

public class ZipCode {
    HashMap<String, String> map; // キーがInteger(住所番号)型, バリューがString(具体的な住所)型を持つmap型

    void run(String[] args) throws IOException {
        this.initialize(); // このメソッドでmapのメソッドに追加できた。
        for (String arg : args) { // mapの場合のループはこの書き方が普通
            this.searchAndPrint(arg); // searchAndPrintメソッドに飛ぶ
        }
    }

    // mapにデータを代入するメソッド．
    void initialize() throws IOException {

        // 読み込んだファイルを1行ずつ処理する
        BufferedReader in = new BufferedReader(new FileReader("./zipcode.csv")); // zipcodeファイルを1行ずつ読み込む
        this.map = new HashMap<>(); // とりあえずHashMapの実体を作成
        String line;
        // csvファイルを１行ずつ読み込む
        while((line = in.readLine()) != null){
            String[] items = line.split(","); // ","で区切る
            map.put(this.stripQuote(items[2]), this.stripQuote(items[6] + items[7] + items[8])); // mapに値を代入している
        }
        in.close();
    }
    
    // 与えられた住所番号からその住所が存在するかを確かめて
    // なおかつその住所が含まれているかどうかを出力するプログラム
    void searchAndPrint(String addressNumber) {
        // お弁当の料金を検索する．
        String place = this.map.get(addressNumber); // 与えられたコマンドライン引数の郵便番号に対する住所を代入する。
        if (place == null) { // お弁当が見つからなかった．
            // ここに見つからなかった旨を出力する処理を書く．
            System.out.printf("%s: 見つかりませんでした%n", addressNumber);
        } else {
            // お弁当の料金を出力する．
            System.out.printf("%s: %s%n", addressNumber, place);
        }
    }

    // ,で区切るためのメソッド
    String stripQuote(String item) {
        if (item.matches("\".*\"")) {
            return item.substring(1, item.length() - 1);
        }
        return item;
    }
    public static void main(String[] args) throws IOException {
        ZipCode zip = new ZipCode();
        zip.run(args);
    }
}

