public class LeapYear {
    public static void main(String[] args) {
        Integer year = 2015;
        Boolean leapYear = false;
        if ( year % 4 == 0) {
            if ( year % 100 != 0) {
                leapYear = true; // この２つの条件に当てはまったらフラグを立てる
            } else {
                if ( year % 400 == 0 ) {
                    leapYear = true;
                }
            }
        }

        if (leapYear == true) { // leapYearがtrueの場合．
            System.out.printf("%d年はうるう年です．%n", year);
        } else {
            System.out.printf("%d年はうるう年ではありません．%n", year);
        }
    }
}