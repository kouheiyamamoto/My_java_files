// 山本昂平　854030 第4講　練習問題2
import java.util.ArrayList;
import java.util.Random;
import javax.sound.midi.SysexMessage;
import com.sun.jdi.IntegerValue;
import java.util.Collections;

// 寺子屋で聞きたこと倍数を除外する一番感じなところ
// 一個だけ出てるエラーの対処法
// なぜ全部出てくるのか

public class generatePrimes {
    void run(String[] args) {

        ArrayList<Boolean> tfList = new ArrayList<>();

        // もしもコマンドライン引数になにも入力がなかったら200までの素数を判定
        if (args.length == 0) {
            tfList = generatePrimes(200);
            // listの表示用ループ
            for (Integer i = 0; i < 199; i++) {
                Integer primesList = tfList.get(i);
                System.out.printf("%3d ", primesList);
                // 10個表示したら改行する処理
                if (i % 10 == 9) {
                    System.out.println();
                }
            }

        } else {
            Integer commandNumber = Integer.parseInt(args[0]); // コマンドライン引数をint型に変換
            tfList = generatePrimes(commandNumber);
            // listの表示用ループ
            for (Integer i = 0; i < commandNumber - 1; i++) {
                Integer primesList = tfList.get(i);
                System.out.printf("%3d ", primesList);
                // 10個表示したら改行する処理
                if (i % 10 == 9) {
                    System.out.println();
                }
            }
        }
    }

    // 素数じゃない数値を除外するメソッド
    ArrayList<Boolean> generatePrimes(Integer max) {
        ArrayList<Boolean> primes = new ArrayList<>();
        for (Integer i = 0; i <= max; i++) {
            primes.add(true); // 仮に全てのiが素数であるとする．
        }
        primes.set(0, false); // 0は素数ではない．
        primes.set(1, false); // 1は素数ではない．

        for (Integer i = 2; i < primes.size(); i++) {
            for (Integer j = i * 2; j < primes.size(); j += i) {
                if (j % i == 0) {
                    primes.add(false);
                } 
                if (!primes.get(i)) { // iが素数ではなかったら何も行わない．
                    continue; // continueは間を飛ばす処理
                }
                // j = i * 2 から始めて j += i のインデックスを false にする．
            }
        }
        return primesList(primes); // もしも素数やったらprimeListメソッドに送る
    }

    // 素数のみを収めるlist
    ArrayList<Integer> primesList(ArrayList<Boolean> primes) {
        ArrayList<Integer> returnList = new ArrayList<>();
        for (Integer i = 2; i < primes.size(); i++) {
            if (primes.get(i)) { // 素数なら returnList に追加する．
                returnList.add(i);
            }
        }
        return returnList;
    }

    public static void main(String[] args) {
        generatePrimes printer = new generatePrimes();
        printer.run(args);
    }
}
