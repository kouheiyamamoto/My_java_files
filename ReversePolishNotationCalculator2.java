import java.math.BigDecimal;
import java.util.ArrayList;

public class ReversePolishNotationCalculator2 {

    void run(String[] args) {
        if (args.length == 0) {
            System.out.println("please input some id");
        } else {
            for (Integer i = 0; i < args.length; i++) { // コマンドライン引数を全部判定するためのループ
                reversePorland(args[i]); // 入力された文字列をメソッドへ送る
            }
        }
    }

    // 逆ポーランド記法で計算するためのメソッド
    void reversePorland(String snake) {
        ArrayList<Double> list = new ArrayList<>(); // スタックをするためのリストを作成する
        String items[] = snake.split(" "); // スペースで区切っていく

        // 区切った文字列が最後になるまでループする
        for (String item : items) { 

            // もしも区切られた文字列が演算子でなかったら
            if (!(item.equals("+") || item.equals("-") || item.equals("*") || item.equals("/"))) { // もしもitemの中身が数値だったら
                Double ditem = Double.parseDouble(item); // 受け取った文字列をDouble型に変換する
                list.add(ditem);
            // もしもitemの中身が演算子だったら  
            } else { 
                // 足し算の場合
                if (item.equals("+")) { 
                    Double firstNumber = list.get(list.size() - 2); // ArrayListの後ろから一つ目の中身を取り出す
                    Double secondNumber = list.get(list.size() - 1); // ArrayListの後ろから二つ目の中身を取り出す

                    list.remove(list.size() - 2);
                    list.remove(list.size() - 1);

                    Double sum = firstNumber + secondNumber;
                    list.add(sum);
                }
                // 引き算の場合
                if (item.equals("-")) { 
                    Double firstNumber = list.get(list.size() - 2); // ArrayListの後ろから一つ目の中身を取り出す
                    Double secondNumber = list.get(list.size() - 1); // ArrayListの後ろから二つ目の中身を取り出す

                    list.remove(list.size() - 2);
                    list.remove(list.size() - 1);

                    Double subtract = firstNumber - secondNumber;
                    list.add(subtract);
                }
                // 掛け算の場合
                if (item.equals("*")) { // それが足し算の場合
                    Double firstNumber = list.get(list.size() - 2); // ArrayListの後ろから一つ目の中身を取り出す
                    Double secondNumber = list.get(list.size() - 1); // ArrayListの後ろから二つ目の中身を取り出す

                    list.remove(list.size() - 2);
                    list.remove(list.size() - 1);

                    Double multiple = firstNumber * secondNumber;
                    list.add(multiple);
                }
                // 割り算の場合
                if (item.equals("/")) { // それが足し算の場合
                    Double firstNumber = list.get(list.size() - 2); // ArrayListの後ろから一つ目の中身を取り出す
                    Double secondNumber = list.get(list.size() - 1); // ArrayListの後ろから二つ目の中身を取り出す

                    list.remove(list.size() - 2);
                    list.remove(list.size() - 1);

                    Double division = firstNumber / secondNumber;
                    list.add(division);
                }
            }
        }
        System.out.printf("%f (%s)%n", list.get(0), snake); // 計算結果を表示
    }

    // ,で区切るためのメソッド
    String stripQuote(String item) {
        if (item.matches("\".*\"")) {
            return item.substring(1, item.length() - 1);
        }
        return item;
    }

    public static void main(String[] args) {
        ReversePolishNotationCalculator2 porland = new ReversePolishNotationCalculator2();
        porland.run(args);
    }
}