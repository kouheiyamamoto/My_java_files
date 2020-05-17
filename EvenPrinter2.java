public class EvenPrinter2 {
    public static void main (String[] args) {
        Integer PrintedCount = 0; //カウント用変数
        for ( Integer i = 1; i < 100; i++ ) {
            if ( i % 2 == 0 ) { // もしもiが偶数の時
                System.out.printf("%2d ",i);
                PrintedCount++;
                if (PrintedCount == 20 ) {
                    System.out.println(); //これで１行改行
                    PrintedCount = 0;
                }
            }
        }
        System.out.println();
    }
}
