
// 山本昂平　854030 第4講　練習問題3
import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.security.cert.CertificateParsingException;
import java.util.ArrayList; // ArrayListをimport

public class Factorizer {

    // runMethod
    void run(String[] args) {
        if (args.length == 0) {
            System.out.println("数字を入力してください。");
        } else {
            for (Integer i = 0; i < args.length; i++) {
                Integer commandNumber = Integer.parseInt(args[i]); // commandNumberに値が入る
                this.CreatePrimes(commandNumber);
            }
        }
    }

    void CreatePrimes(Integer cm) {
        // ArrayList<Integer> someList = new ArrayList<>(); // なんかに使うリスト
        Primes primes = new Primes(); // Primesをオブジェクト化
        ArrayList<Integer> list = primes.generatePrimes(100); // ArrayListの変数listに100個の素数を代入する
        System.out.printf("%d: ", cm);
        for (Integer j = 0; j < cm; j++) {
            if (cm == 1)
                break;
            for (Integer k = 0; k < list.size(); k++) {
                if (cm % list.get(j) == 0) {
                    // someList.add(list.get(j));
                    cm = cm / list.get(j);
                    System.out.printf(" %d", list.get(j));
                    if (cm != 1) {
                        System.out.printf(" x");
                    }
                }
            }
        }
        System.out.println();
    }

    // mainMethod
    public static void main(String[] args) {
        Factorizer printer = new Factorizer();
        printer.run(args);
    }
}