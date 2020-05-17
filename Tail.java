import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Tail {

    void run(String[] args) throws IOException {
        Integer commandNum = Integer.parseInt(args[0]); // コマンドライン引数の1つめを数値に変換
        BufferedReader in = new BufferedReader(new FileReader(args[1])); // コマンドライン引数の2つめのファイルを読み込む
        tail(commandNum, in);
    }

    // 読み込んだファイルの内容の中身から最後の数行のみを表示する
    void tail(Integer cn, BufferedReader id) throws IOException{
        String line; // 1行を読み込むための変数
        ArrayList<String> list = new ArrayList<>(); // とりあえず1行ずつ読み込んだ文字列を保存するためのリスト
        // csvファイルを１行ずつ読み込む
        while ((line = id.readLine()) != null) {
            list.add(line); // ここでファイルの内容が全部1行ずつlistに代入される。
        }
        id.close();

        for(Integer i = list.size()-cn; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    public static void main(String[] args) throws IOException {
        Tail last = new Tail();
        last.run(args);
    }
}