import java.math.BigDecimal;
import java.util.ArrayList;

public class ReversePolishNotationCalculator {

    void run(String[] args) {
        if (args.length == 0) {
            System.out.println("please input some id");
        } else {
            for (Integer i = 0; i < args.length; i++) {
                reversePorland(args[i]); // 入力された文字列をメソッドへ送る
            }
        }
    }

    // 逆ポーランド記法で計算するためのメソッド
    void reversePorland(String snake) {
        // ? このリストはString型？ それともDouble型？
        ArrayList<Double> list = new ArrayList<>();
        String items[] = snake.split(" "); // スペースで区切っていく

        // 数値のみをlistに代入していく
        for (String item : items) {
            // ? ここのループの時点で区切った一個一個の文字列たちを全部Double型に変換していいのか
            if (isNum(item)) { // もしもitemの中身が数値だったら
                
                list.add(item);
            } else { // もしもitemの中身が演算子だったら
                // この時点でリストの中身は空になった
                if (item.equals("+")) { // 足し算の場合
                    
                    String firstNumber = list.get(list.size() - 2); // ArrayListの後ろから一つ目の中身を取り出す
                    String secondNumber = list.get(list.size() - 1); // ArrayListの後ろから二つ目の中身を取り出す

                    Double firstNumberOfdouble = Double.parseDouble(firstNumber); // 文字列をdouble型に変換して変数に代入する
                    Double secondNumberOfdouble = Double.parseDouble(secondNumber); // 文字列をdouble型に変換して変数に代入する

                    list.remove(list.size() - 1);
                    list.remove(list.size() - 2);

                    Double sum = firstNumberOfdouble + secondNumberOfdouble;
                    System.out.printf("%f (%s)", sum, snake); // 計算結果を表示
                }
                if (item.equals("-")) { // 引き算の場合

                    String firstNumber = list.get(list.size() - 2); // ArrayListの後ろから一つ目の中身を取り出す
                    String secondNumber = list.get(list.size() - 1); // ArrayListの後ろから二つ目の中身を取り出す

                    Double firstNumberOfdouble = Double.parseDouble(firstNumber); // 文字列をdouble型に変換して変数に代入する
                    Double secondNumberOfdouble = Double.parseDouble(secondNumber); // 文字列をdouble型に変換して変数に代入する

                    list.remove(list.size() - 1);
                    list.remove(list.size() - 2);

                    Double substract = firstNumberOfdouble - secondNumberOfdouble;
                    System.out.printf("%f (%s)", substract, snake); // 計算結果を表示
                }
                if (item.equals("*")) { // 掛け算の場合

                    String firstNumber = list.get(list.size() - 2); // ArrayListの後ろから一つ目の中身を取り出す
                    String secondNumber = list.get(list.size() - 1); // ArrayListの後ろから二つ目の中身を取り出す

                    Double firstNumberOfdouble = Double.parseDouble(firstNumber); // 文字列をdouble型に変換して変数に代入する
                    Double secondNumberOfdouble = Double.parseDouble(secondNumber); // 文字列をdouble型に変換して変数に代入する

                    list.remove(list.size() - 1);
                    list.remove(list.size() - 2);

                    Double multiple = firstNumberOfdouble * secondNumberOfdouble;
                    System.out.printf("%f (%s)", multiple, snake); // 計算結果を表示
                }
                if (item.equals("/")) { // 割り算の場合

                    String firstNumber = list.get(list.size() - 2); // ArrayListの後ろから一つ目の中身を取り出す
                    String secondNumber = list.get(list.size() - 1); // ArrayListの後ろから二つ目の中身を取り出す

                    Double firstNumberOfdouble = Double.parseDouble(firstNumber); // 文字列をdouble型に変換して変数に代入する
                    Double secondNumberOfdouble = Double.parseDouble(secondNumber); // 文字列をdouble型に変換して変数に代入する

                    list.remove(list.size() - 1);
                    list.remove(list.size() - 2);

                    Double division = firstNumberOfdouble / secondNumberOfdouble;
                    System.out.printf("%f (%s)", division, snake); // 計算結果を表示
                }

            }
        }
        // リストの中身を全て表示するループ
        for (Integer i = 0; i < list.size() - 1; i++) {
            System.out.print(list.get(i));
        }
    }

    public boolean isNum(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ,で区切るためのメソッド
    String stripQuote(String item) {
        if (item.matches("\".*\"")) {
            return item.substring(1, item.length() - 1);
        }
        return item;
    }

    public static void main(String[] args) {
        ReversePolishNotationCalculator porland = new ReversePolishNotationCalculator();
        porland.run(args);
    }
}