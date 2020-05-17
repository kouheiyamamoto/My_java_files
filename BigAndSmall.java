// 山本昂平　854030 第1講　練習問題1 
public class BigAndSmall {
    public static void main(String[] args) {
        Double value = Math.random();
        // valueには0から1の乱数が代入されている．
        System.out.printf("value: %f: ", value); // 少数を受け取るときは%fになる
        if (value >= 0.5) {
            System.out.println("Big");
        }
        else {
            System.out.println("Small");
        }
    }
}
