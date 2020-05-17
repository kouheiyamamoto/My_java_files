public class EvenPrinter {
    public static void main(String[] args) {
        for (Integer i = 1; i < 100; i++) { // Integerで整数を宣言
            if (i % 2 == 1) // もしも偶数やったら処理を飛ばす
                continue;
            System.out.printf(" %d", i);
        }
    }
}