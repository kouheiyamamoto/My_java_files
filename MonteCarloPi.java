// 山本昂平　854030 第3講　練習問題4

public class MonteCarloPi {
    void run(String[] args) {

        // もしも何も入力されなかったらデフォルトで1000
        if (args.length == 0) {
            
            // 変数宣言たち
            Double rd[] = new Double[1000];
            Double xd[] = new Double[1000];
            Double yd[] = new Double[1000];
            Double sqrtOfrd[] = new Double[1000];
            Double hd = 0.0;
            Double countd = 0.0;
            Double md = 0.0;

            // コマンドライン引数を受けなかった時はデフォルトとして1000回ループする
            for (Integer i = 0; i < 1000; i++) {
                
                // 乱数を受け取る
                xd[i] = Math.random();
                yd[i] = Math.random();

                // 距離を計算する
                rd[i] = xd[i] * xd[i] + yd[i] * yd[i];
                sqrtOfrd[i] = Math.sqrt(rd[i]); // 平方根の計算
                
                // もしも距離が1以内だったら
                if (sqrtOfrd[i] < 1) {
                    hd++; // ヒットした回数を増やす
                }
                countd++; // 総合的にループが回った回数を表示する
            }
            md = hd / countd; 
            System.out.printf("pi = %.5f%n",md*4);
        }else{
            // コマンドライン引数になにか値が入力があった場合
            Integer dr = Integer.valueOf(args[0]);
            Double r[] = new Double[dr];
            Double x[] = new Double[dr];
            Double y[] = new Double[dr];
            Double sqrtOfr[] = new Double[dr];
            Double h = 0.0;
            Double count = 0.0;
            Double m = 0.0;
            
            for ( Integer i = 0; i < dr; i++ ) {
                // 乱数を受け取る
                x[i] = Math.random();
                y[i] = Math.random();

                r[i] = x[i] * x[i] + y[i] * y[i];
                sqrtOfr[i] = Math.sqrt(r[i]); // 平方根の計算
                if (sqrtOfr[i] < 1) {
                    h++;
                }
                count++;
            }
            m = h / count;
            System.out.printf("pi = %.5f%n", m * 4);
        }
    }

    // mainメソッド
    public static void main(String[] args) {
        MonteCarloPi printer = new MonteCarloPi();
        printer.run(args);
    }
}