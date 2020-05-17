import java.io.*;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;

public class Sorter {

    void run(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(args[0])); // zipcodeファイルを1行ずつ読み込む
        sort_and_printArray(in); // ? ほんとはsortとprintArrayメソッドを分けたい！
    }

    // ファイルから読み込んだ行を1行ずつリストに格納するためのメソッド
    // ? 順番入れ替えたリストを上のメソッドに返すにはどうすればいいか
    // ? そんで入れ替えたリストを上に返してprintMethodで表示したい
    void sort_and_printArray(BufferedReader in)throws IOException{
        ArrayList<String> list = new ArrayList<>(); // 文字列を格納していくためのリスト
        String line;
        // csvファイルを１行ずつ読み込む
        while ((line = in.readLine()) != null) {
             list.add(line); // 読み込んだ文字列を1行ずつlistに格納していく
        }
        in.close();
        Collections.sort(list);

        // 順番入れ替えたリストを逆順表示
        for(Integer i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        
    }
    public static void main(String[] args) throws IOException{
        Sorter sort = new Sorter();
        sort.run(args);
    }
}

// プログラミングで詰まったらネットで調べる