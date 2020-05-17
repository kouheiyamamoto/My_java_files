public class FizzBuzz { // クラスをここで宣言
    void run(String[] args) {
        // numberに値が代入されている
        // 上でargs[0]を数字に変える
        Integer i;
        if ( args.length == 0 ) {
            for (i = 0; i <= 15; i++) {
                if ((i % 3 == 0) && (i % 5 == 0)) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        } else {
            Integer number = Integer.valueOf(args[0]); // コマンドライン引数で入力された引数を整数型に変える処理
            for (i = 0; i <= number; i++) {
                if ((i % 3 == 0) && (i % 5 == 0)) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz printer = new FizzBuzz(); // printerを実体化している
        printer.run(args); // printerっていう実態に関してメッソドを呼び出す方式
    }
}