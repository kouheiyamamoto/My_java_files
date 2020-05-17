import java.math.BigInteger;

public class MersenneNumbers_854030 {

    void run(String[] args) {
        if (args.length == 0) {
            System.out.println("数字を入力してください。");
        } else {
        //     for (Integer i = 0; i < args.length; i++) {
                Integer n = Integer.valueOf(args[0]);
        //         Double mer = powerOfTwo(n);
        //         BigInteger result = mersenne(n); // n番目のメルセンヌ数を求める．
        //         System.out.println("2");
        // }
        System.out.println("2^ %d - 1 = %d (%d)", n, m, n);
    } 

   

    Double powerOfTwo (Double to) {
        return Math.pow(2, to) - 1;
    }

    // BigInteger mersenne(Double to) {
    //     return to.pow(2) - 1;
    // }

    

    // mainメソッド
    public static void main(String[] args) {
        MersenneNumbers_854030 printer = new MersenneNumbers_854030();
        printer.run(args);
    }
}