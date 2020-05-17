// 山本昂平　854030 第1講　練習問題6
public class BackSlashPrinter {
    public static void main (String[] args) {
        for ( Integer x = 0; x < 10; x++ ) { // 横ループ始まり
            for ( Integer y = 0; y < 10; y++ ) { // 縦ループ始まり
                if ( x == y ) {
                    System.out.printf("X");
                } else {
                    System.out.printf(".");
                }
            } // 横ループ終わり
            System.out.println();
        } // 縦ループ終わり
    }
}