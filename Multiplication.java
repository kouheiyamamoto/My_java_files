// 山本昂平　854030 第1講　練習問題5
public class Multiplication {
    public static void main(String[] args) {
        System.out.print(" "); // まず初めに横軸の空白を入れる
        for (Integer x = 1; x < 10; x++) { // 横軸を表示する
            System.out.printf(" %2d", x);
        }
        System.out.println(); // ９まで行ったら改行する
        for (Integer i = 1; i < 10; i++) {
            System.out.print(i); // 縦を表示しつつ縦かける横を計算する
            for (Integer j = 1; j < 10; j++) {
                System.out.printf(" %2d", i * j);
            }
            System.out.println();
        }
    }
}