
// 山本昂平　854030 第4講　練習問題2
import java.util.ArrayList;

public class Primes {
  void run(String[] args) {

    ArrayList<Integer> tfList = new ArrayList<>();

    // もしもコマンドライン引数になにも入力がなかったら200までの素数を判定
    if (args.length == 0) {
      tfList = generatePrimes(200);
      printtfList(tfList);
     
    } else {
      Integer commandNumber = Integer.parseInt(args[0]); // コマンドライン引数をint型に変換
      tfList = generatePrimes(commandNumber);
      printtfList(tfList);
    }
  }

  // 素数じゃない数値を除外するメソッド
  ArrayList<Integer> generatePrimes(Integer max) {
    ArrayList<Boolean> primes = new ArrayList<>();
    for (Integer i = 0; i <= max; i++) {
      primes.add(true); // 仮に全てのiが素数であるとする．
    }
    primes.set(0, false); // 0は素数ではない．
    primes.set(1, false); // 1は素数ではない．

    for (Integer i = 2; i < primes.size(); i++) {
      // 最小の値である2から始める．
      if (!primes.get(i)) { // iが素数ではなかったら何も行わない．
        continue;
      }
      for (Integer j = i * 2; j < primes.size(); j += i) {
        if (j % i == 0) {
          primes.set(j, false);
        }
      }
      // j = i * 2 から始めて j += i のインデックスを false にする．
    }
    return primesList(primes); // もしも素数やったらprimeListメソッドに送る
  }

  // 素数のみを収めるlist
  ArrayList<Integer> primesList(ArrayList<Boolean> prime) {
    ArrayList<Integer> returnList = new ArrayList<>();
    for (Integer i = 2; i < prime.size(); i++) {
      if (prime.get(i)) { // 素数なら returnList に追加する．
        returnList.add(i);
      }
    }
    return returnList;
  }

  void printtfList(ArrayList<Integer> tfList){
    // listの表示用ループ
    for (Integer i = 0; i < tfList.size(); i++) {
      System.out.printf("%3d ", tfList.get(i));
      // 10個表示したら改行する処理
      if (i % 10 == 9) {
        System.out.println();
      }
    }
  }

  public static void main(String[] args) {
    Primes printer = new Primes();
    printer.run(args);
  }
}
