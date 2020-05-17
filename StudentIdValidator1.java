/* 山本昂平　854030 練習問題2　*/

public class StudentIdValidator1 {

    void run(String[] args) {
        Integer[] num = new Integer[args.length];
        for (Integer i = 0; i < args.length; i++) {
            num[i] = validate(args[i]); // argsを使ってvalidateメソッドに渡
            validateId(num[i]); // numを使って計算結果を出力
        }
    }

    Integer validate(String array) {
        if (array.length() != 6) { // 文字列の長さが６でない時
            System.out.printf("%s: not student id", array);
            System.exit(1);
        } else {
            return Integer.parseInt(array); // ここでint型に変換
        }
    }

    void validateId(Integer a) { // 数字をaで受け取りましたという意味
        if (a % 10 == 0) {
            System.out.printf("%s: valid", a);
        } else {
            System.out.printf("%s: invalid", a);
        }
    }

    // mainメソッド
    public static void main(String[] args) {
        StudentIdValidator1 printer = new StudentIdValidator1();
        printer.run(args);
    }
}

// void run(String[] args) {
// // for (Integer i = 0; i < args.length; i++) {
// // Integer n = args[i].length();
// // if (n != 6) {
// // validate(args);
// // } else {
// // Integer number = Integer.valueOf(args[i]); // String型の配列をInteger型に変換する
// // validateId(number);
// // }
// // }
// // }

// for (Integer i = 0; i < array.length; i++) {
// // System.out.printf("%s: not student Id", args[i]);
// // }