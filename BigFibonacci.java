public class BigFibonacci {

    void run(String[] args) {

        if (args.length == 0) {
            Integer number = 10;
            this.print(number, this.fibonacci(number));
        } else {
            for (Integer i = 0; i < args.length; i++) {
                Integer number = Integer.valueOf(args[i]);
                this.print(number, this.fibonacci(number));
            }
        }
    }

    // 再帰呼び出しでFibonacciを計算するメドッド
    Integer fibonacci(Integer n) {
        return n-2 + n-1;
    }

    void print(Integer n, Integer result) {
        System.out.printf("fibonacci(%d) = %d%n", n, result);
    }

    // mainメソッド
    public static void main(String[] args) {
        BigFibonacci printer = new BigFibonacci();
        printer.run(args);
    }
}
