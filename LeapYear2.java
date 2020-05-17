// 山本昂平　854030 第1講　練習問題3
public class LeapYear2 {
    public static void main(String[] args) {
        Integer year = 1900;
        Boolean leapYear = false;
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                leapYear = true; // この２つの条件に当てはまったらフラグを立てる
            }
        }

        if (leapYear == true) { // leapYearがtrueの場合．
            System.out.printf("%d年はうるう年です．%n", year);
        } else {
            System.out.printf("%d年はうるう年ではありません．%n", year);
        }
    }
}