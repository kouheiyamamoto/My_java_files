// 山本昂平　854030 第3講　練習問題5

public class TrapezoidalRulePi {
    void run(String[] args) {

        // もしも何も入力されなかったらデフォルトで0.001
        // ということはデフォルトは１０００回ループで回す。
        if (args.length == 0) {

            // 変数宣言たち
            Double defolt = 0.001;
            Double y;
            Double yy;
            Double trapezoids = 0.0; // 台形の面積の合計値
            Double c;

            // デフォルトの回数ループを繰り返す
            for (Double i = 0.0; i < 1.0; i += defolt) {

                y = Math.sqrt(1.0 - Math.pow(i, 2)); // 台形の高さを計算する

                yy = Math.sqrt(1.0 - Math.pow(i - defolt, 2)); // 台形の高さを計算する

                trapezoids += (defolt * (y + yy)) / 2.0; // 台形の面積の合計値を計算する

                // System.out.printf("i = %f : trapezoids = %f%n", i, trapezoids);
            }
            c = trapezoids * 4.0; // πの近似値
            System.out.printf("pi = %f%n", c);
        
        // コマンドライン引数になにか値が代入された時            
        } else { 
            
            // 変数宣言たち
            Double dr = Double.valueOf(args[0]); // コマンドライン引数をDouble型の変数に変換する
            Double y;
            Double yy;
            Double trapezoids = 0.0; // 台形の面積の合計値
            Double ck;

            // デフォルトの回数ループを繰り返す
            for (Double i = 0.0; i < 1.0; i += dr) {

                y = Math.sqrt(1.0 - Math.pow(i, 2)); // 台形の高さを計算する

                yy = Math.sqrt(1.0 - Math.pow(i - dr, 2)); // 台形の高さを計算する

                trapezoids += (dr * (y + yy)) / 2.0; // 台形の面積の合計値を計算する

                // System.out.printf("i = %f : trapezoids = %f%n", i, trapezoids);
            }
            ck = trapezoids * 4.0; // πの近似値
            System.out.printf("pi = %f%n", ck);
        }
    }

    // mainメソッド
    public static void main(String[] args) {
        TrapezoidalRulePi printer = new TrapezoidalRulePi();
        printer.run(args);
    }
}