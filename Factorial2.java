public class Factorial2 {
    void run(String[] args) {
        Integer number = Integer.valueOf(args[0]);
        Integer factorial = this.factorial(number);
        // number の階乗を計算する．
        System.out.printf("%d! = %d%n", number, factorial);
    }

    Integer factorial( Integer x) { //()の中には引数の個数を書けばいい
        Integer factorial = 1;
        for (Integer i = x; i >= 1; i--) {
            factorial *= i;
        }
        return factorial;
    }
    public static void main(String[] args) {
        Factorial2 printer = new Factorial2(); // このクラスに呼び込まなあかんからこうするのは当たりまえ
        printer.run(args); // 関数に飛ぶ！
    }
}