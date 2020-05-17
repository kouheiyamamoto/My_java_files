import java.util.Scanner;

// 山本昂平　854030 第1講　練習問題7
public class XPrinter {
    public static void main(String[] args) {
        //Integer num = 15;
        // キーボードの数字の入力から変数に代入する
        Scanner sc = new Scanner(System.in);
        Integer num = sc.nextInt();
        for ( Integer y = 0; y < num; y++ ) { // 横ループ始まり
            for ( Integer x = 0; x < num; x++ ) { // 縦ループ始まり
                if ( x == y || (x+y == num-1) ) {
                    System.out.printf("X");
                } else {
                    System.out.printf(".");
                }
            } // 横ループ終わり
            System.out.println();
        } // 縦ループ終わり
        sc.close();
    }
}