import java.io.IOException;
import java.util.HashMap; // HashMapを使うためのimport
import java.util.Objects; // オブジェクトを操作するためのimportファイル

// 名前と電話番後のペアを管理する電話帳を作成する。
public class PhoneBook_methodDivide {

    // runMethod
    void run(String[] args) throws IOException {

        HashMap<String, String> read = new HashMap<>(); // 標準入力を読み込んでいくためのHashmap型の配列
        console(read);
    }

    void console(HashMap<String, String> read) throws IOException{

        while (true) {
            System.out.print("> ");
            // 標準文字列から1行ずつ読み込み
            SimpleConsole console = new SimpleConsole(); // 標準入力を読み込む
            String line = console.readLine(); // 1行読み込んだやつをlineに代入する。
            String[] items = line.split(" "); // 読み込んだlineに入ってる標準入力を" "(空白)で区切る

            // read.put(this.stripQuote(items[0]), this.stripQuote(items[1]));

            // コマンドにlistが入力された時
            if (items[0].equals("list")) {
                // mapの中身を全て表示するためのループ
                for (HashMap.Entry<String, String> entry : read.entrySet()) {
                    System.out.println(entry.getKey() + " " + entry.getValue());
                }
            }

            // コマンドにfindが入力された時
            if (items[0].equals("find")) {
                if (read.containsKey(items[1])) { // もしもreadのキーのなかに標準入力された文字が含まれていたら
                    // mapの中身を全て表示するためのループ
                    for (HashMap.Entry<String, String> entry : read.entrySet()) {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    }
                }
            }

            // コマンドにaddが入力された時
            if (items[0].equals("add")) {
                read.put(this.stripQuote(items[1]), this.stripQuote(items[2]));
            }

            // コマンドにremoveが入力された時
            if (items[0].equals("remove")) { // 実体の参照をするときの.equals
                if (read.containsKey(items[1])) {
                    read.remove(this.stripQuote(items[1]));
                }
            }

            // コマンドにexitが入力された時
            if (items[0].equals("exit")) {
                break;
            }
        }
    }

    // " "空白で区切るためのメソッド
    String stripQuote(String item) {
        if (item.matches("\".*\"")) {
            return item.substring(1, item.length() - 1);
        }
        return item;
    }

    public static void main(String[] args) throws IOException {
        PhoneBook_methodDivide search = new PhoneBook_methodDivide();
        search.run(args);
    }
}