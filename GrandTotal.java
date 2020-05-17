// 山本昂平　854030 第1講　練習問題4
public class GrandTotal {
    public static void main (String[] args) {
        Integer result = 0; // 合計値を出力するための変数
        Integer last = 1000;
        for ( Integer i = 1; i < last+1; i++ ) {
            result += i;
        }
        System.out.printf("1~%dまでの総和は%2dです。%n",last,result);
    }
}