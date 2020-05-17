import java.util.HashMap;

public class Dictionary_854030{
    HashMap<String, String> dictionary;
    void run(String[] args){
        this.initialize();
        for (String arg : args) { // mapの場合のループはこの書き方が普通
            this.searchAndPrint(arg);
        }
    }

    // 英単語辞典を格納するためのメソッド
    void initialize() {
        this.dictionary = new HashMap<>(); // とりあえずHashMapの実体を作成
        dictionary.put("english", "英語");
        // 他のお弁当の（10個程度）．
        dictionary.put("meat", "肉");
        dictionary.put("note", "ノート");
        dictionary.put("grass", "メガネ");
        dictionary.put("dictionary", "辞書");
        dictionary.put("marry", "結婚する");
        dictionary.put("meal", "食事");
        dictionary.put("money", "お金");
        dictionary.put("soccer", "サッカー");
        dictionary.put("solt", "塩");
    }

    void searchAndPrint(String english) {
        // 英単語を検索する
        String japanese = this.dictionary.get(english);
        if (japanese == null) { 
            // ここに見つからなかった旨を出力する処理を書く．
            System.out.printf("%s: 見つかりませんでした%n", english);
        } else {
            System.out.printf("%s: %s%n", english, japanese);
        }
    }

    public static void main(String[] args){
         Dictionary_854030 make = new  Dictionary_854030();
         make.run(args);
    }
}