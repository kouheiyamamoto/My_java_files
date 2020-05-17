import java.math.BigInteger;

public class BigFactorial {
    void run(String[] args) {
        for (String arg : args) {
            this.printFactorial(Integer.valueOf(arg));
        }
    }

    void printFactorial(Integer to) {
        BigInteger answer = BigInteger.ONE;
        for (Integer i = 1; i <= to; i++) {
            // Integer 型を BigInteger 型に変換するには，
            // BigInteger.valueOf(value);
            BigInteger value = BigInteger.valueOf(i);
            // BigIntegerのかけ算は * ではダメ．
            // multiply メソッドを呼び出さないといけない．
            answer = answer.multiply(value);
        }
        System.out.printf("%d! = %s%n", to, answer);
    }

    // mainMethod
    public static void main(String[] args) {
        BigFactorial printer = new BigFactorial();
        printer.run(args);
    }
}