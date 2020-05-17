// 山本昂平　854030 第3講　練習問題3
public class QuadraticEquation {
    void run(String[] args) {

        // コマンドライン引数をDouble型に変換する
        Double a = Double.valueOf(args[0]);
        Double b = Double.valueOf(args[1]);
        Double c = Double.valueOf(args[2]);

        // 実部、虚部、判別式の変数
        Double plusCompN, minusCompN, realN, D;

        // Dは判別式
        D = discriminant(a, b, c);

        // Dを判別する
        if (D > 0) {
            Double sqrtOfD = Math.sqrt(D); // Dを平方根かしている
            plusCompN = (-b + sqrtOfD) / (2 * a);
            minusCompN = (-b - sqrtOfD) / (2 * a);
            System.out.printf("answer = %f, %f%n", plusCompN, minusCompN);
        
        } else if (D == 0) {
            realN = -b / (2 * a);
            System.out.printf("answer = %f%n", realN);
        
        } else {
            Double sqrtOfD = Math.sqrt(-D); // Dを平方根かしている
            System.out.println(0/0);
            realN = -b / (2 * a);
            plusCompN = sqrtOfD / (2 * a);
            minusCompN = -(sqrtOfD / (2 * a));
            System.out.printf("answer = %f + %f i, %f - %f i%n", realN, plusCompN, realN, minusCompN);
        } 
    }

    // 判別式の値を返すメソッド
    Double discriminant(Double id0, Double id1, Double id2) {
        return id1 * id1 - 4 * id0 * id2; // 判別式の結果を返している
    }

    // mainメソッド
    public static void main(String[] args) {
        QuadraticEquation printer = new QuadraticEquation();
        printer.run(args);
    }
}