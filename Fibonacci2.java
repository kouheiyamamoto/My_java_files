public class Fibonacci2{
    
    void run(String[] args){

        if ( args.length == 0) {
            Integer number = 10;
            this.print(number, this.fibonacci(number));
        }else{
            for ( Integer i = 0; i < args.length; i++ ) {
                Integer number = Integer.valueOf(args[i]);
                this.print(number, this.fibonacci(number));
            }
        }
    }

    // 再帰呼び出しでFibonacciを計算するメドッド
    Integer fibonacci(Integer n){
    
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    void print(Integer n, Integer result){
        System.out.printf("fibonacci(%d) = %d%n", n, result);
    }
    
    // mainメソッド
    public static void main(String[] args) {
        Fibonacci2 printer = new Fibonacci2();
        printer.run(args);
    }
}

