public class Grandtotal2 {

    void run(String[] args) {
        if (args.length == 0) {
            Integer number = 10;
            this.print(number, this.factorial(number));
        } else {
            for (Integer i = 0; i < args.length; i++) {
                Integer number = Integer.valueOf(args[i]);
                this.print(number, this.factorial(number));
            }
        }
    }

    // 再帰呼び出しで階乗を計算するメドッド
    Integer factorial(Integer number) {
        System.out.printf("factorial(%d)%n", number);
        if (number == 1) {
            return 1;
        }
        return number + this.factorial(number - 1);
    }

    void print(Integer number, Integer result) {
        System.out.printf("1から%dまでの総和は%dです.%n", number, result);
    }

    // mainメソッド
    public static void main(String[] args) {
        Grandtotal2 printer = new Grandtotal2();
        printer.run(args);
    }
}