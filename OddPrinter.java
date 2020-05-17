// 2月11日　山本昂平　
public class OddPrinter {
    public static void main (String[] args) {
        Integer PrintedCount = 0; // 変数宣言
        for ( Integer i = 1; i < 100; i++ ) {
            if ( i % 2 == 1) {
                System.out.printf("%2d ",i);
                PrintedCount++;
                if ( PrintedCount == 20 ) {
                    System.out.println();
                    PrintedCount = 0;
                }
            }
        }
        System.out.println();
    }
}