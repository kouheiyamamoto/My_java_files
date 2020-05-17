public class Fibonacci { // クラスをここで宣言
    void run(String[] args) {
        // numberに値が代入されている
        // 上でargs[0]を数字に変える
        Integer f1 = 0; // 初期値
        Integer f2 = 1;
        Integer fn; // 最終的な値を格納する変数
        Integer i;
        if (args.length == 0) {
            System.out.printf("%d%n",f1+f2);
            for (i = 1; i < 20; i++) {
                fn = f1 + f2;
                System.out.printf("%d ",fn);
                f1 = f2;
                f2 = fn;
            }
        } else {
            Integer number = Integer.valueOf(args[0]); // コマンドライン引数で入力された引数を整数型に変える処理
            System.out.printf("%d%n",f1+f2);
            for (i = 1; i < number; i++) {
                fn = f1 + f2;
                System.out.printf("%d%n",fn);
                f1 = f2;
                f2 = fn;
            }
        }
    }

    public static void main(String[] args) {
        Fibonacci printer = new Fibonacci(); // このクラスに呼び込まなあかんからこうするのは当たりまえ
        printer.run(args); // 関数に飛ぶ！
    }
}