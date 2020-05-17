import java.io.*;
import java.util.ArrayList;

public class Tac{

    void run(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("ファイルを選択してください");
        }else{
            for (Integer i = 0; i < args.length; i++){
                BufferedReader in = new BufferedReader(new FileReader(args[i])); // zipcodeファイルを1行ずつ読み込む
                sortAndPrint(in);
            }
        }
    }
    // ファイルの内容を逆順にするためのメソッド
    void sortAndPrint(BufferedReader id)throws IOException{
        ArrayList<String> list = new ArrayList<>(); // 文字列を格納していくためのリスト
        String line;
        // csvファイルを１行ずつ読み込む
        while ((line = id.readLine()) != null) {
            list.add(line); // 読み込んだ文字列を1行ずつlistに格納していく
        }
        id.close();

        for(Integer i = list.size()-1; i >= 0; i--){
            System.out.println(list.get(i));
        }
    }
    public static void main(String[] args) throws IOException {
        Tac sort = new Tac();
        sort.run(args);
    }
}