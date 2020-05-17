public class Factorial { // クラスをここで宣言
    void run(String[] args) {
        // numberに値が代入されている
        Integer number = Integer.valueOf(args[0]); // コマンドライン引数で入力された引数を整数型に変える処理
        // 上でargs[0]を数字に変える
        Integer factorial = 1;
        for (Integer i = number; i >= 1; i--) {
            factorial *= i;
        }
        System.out.printf("%d! = %d%n", number, factorial);
    }

    public static void main(String[] args) {
        Factorial printer = new Factorial(); // このクラスに呼び込まなあかんからこうするのは当たりまえ
        printer.run(args); // 関数に飛ぶ！
    }
}