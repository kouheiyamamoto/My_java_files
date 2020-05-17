import java.math.BigInteger; // BigIntegerをインポート
public class BigOperator{

    // runMethod
    void run(String[] args){
        
        BigInteger b1 = new BigInteger("10");  // BigInteger型の実体を作成する．
        BigInteger b2 = BigInteger.valueOf(3); // Integer型からBigInteger型へ変換する．
        BigInteger b3 = new BigInteger("10");  // BigInteger型の実体を作成する．

        BigInteger result1 = b1.add(b2);       // b1 + b2
        BigInteger result2 = b1.subtract(b2);  // b1 - b2
        BigInteger result3 = b1.multiply(b2);  // b1 * b2
        BigInteger result4 = b1.divide(b2);    // b1 / b2
        BigInteger result5 = b1.remainder(b2); // b1 % b2
        BigInteger result6 = b1.negate();      // -b1

        System.out.printf("%s + %s = %s%n", b1, b2, result1);  // <= 13
        System.out.printf("%s - %s = %s%n", b1, b2, result2);  // <= 7
        System.out.printf("%s * %s = %s%n", b1, b2, result3);  // <= 30
        System.out.printf("%s / %s = %s%n", b1, b2, result4);  // <= 3
        System.out.printf("%s %% %s = %s%n", b1, b2, result5); // <= 1
        System.out.printf("-%s = %s%n", b1, result6);          // <= -10
        
        if(b1.compareTo(b2) > 0){ // b1 > b2
            System.out.println("b1 の方が b2 より大きい．");
        }
        
        if(b2.compareTo(b1) < 0){
            System.out.println("b2 の方が b1 より小さい. ");
        }
        
        if (b1.compareTo(b3) == 0){
            System.out.println("b1 も b3 同じ");
        }
    }

    // mainMethod
    public static void main (String[] args) {
        BigOperator printer = new BigOperator();
        printer.run(args);
    } 
}