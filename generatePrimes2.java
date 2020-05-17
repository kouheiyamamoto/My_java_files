import java.util.ArrayList;

public class generatePrimes2 {
    void run(String[] args) {

        ArrayList<Integer> printList = new ArrayList<>();

        for (Integer i = 0; i <= 200; i++) {
            // リストに加える
            printList.add(i);
            if (printList.get(i) % 2 == 0) {
                continue;
            }
            // get関数で数値を得る
            System.out.printf("%3d  ", printList.get(i));
            // 10個表示したら改行する処理
            if (i % 10 == 9) {
                System.out.println();
            }
        }
    }
    
    public static void main(String[] args) {
        generatePrimes2 printer = new generatePrimes2();
        printer.run(args);
    }
}

