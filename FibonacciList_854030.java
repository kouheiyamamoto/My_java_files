import java.util.ArrayList;

// 第4講　小テスト　２問目　プログラム作成
public class FibonacciList_854030 {
    Integer f1 = 1; // 初期値
    Integer f2 = 1;
    Integer fn; // 最終的な値を格納する変数
    void run(String[] args) {

        Integer maxIndex;

        if (args.length == 0) {
            maxIndex = 10;
            ArrayList<Integer> list = getFibonacciList1(maxIndex);
            System.out.println(list);
        } else {
            Integer commandNumber = Integer.parseInt(args[0]); // commandNumberに値が入る
            maxIndex = commandNumber;// 何項目まで求めるか．
            ArrayList<Integer> list = getFibonacciList2(maxIndex);
            System.out.println(list);
        }
    }

    // getFibonacciListメソッドを作成する．
    ArrayList<Integer> getFibonacciList1(Integer maxIndex) {
        ArrayList<Integer> FibonacciList = new ArrayList<>(); // フィボナッチ数を格納するリスト
        //System.out.printf("%d%n", f1 + f2);
        FibonacciList.add(f2);
        FibonacciList.add(f2);
        for (Integer i = 1; i < maxIndex; i++) {
            //fn = FibonacciList.get(0) + FibonacciList.get(1);
            fn = f1 + f2;
            FibonacciList.add(fn);
            //System.out.printf("%d%n", fn);
            // FibonacciList.set(0, FibonacciList.get(1));
            // FibonacciList.set(1, fn);
            f1 = f2;
            f2 = fn;
        }
        return FibonacciList;
    }
    // getFibonacciListメソッドを作成する．
    ArrayList<Integer> getFibonacciList2(Integer maxIndex) {
        ArrayList<Integer> FibonacciList = new ArrayList<>(); // フィボナッチ数を格納するリスト
        // System.out.printf("%d%n", f1 + f2);
        FibonacciList.add(f2);
        FibonacciList.add(f2);
        for (Integer i = 1; i < maxIndex; i++) {
            // fn = FibonacciList.get(0) + FibonacciList.get(1);
            fn = f1 + f2;
            FibonacciList.add(fn);
            // System.out.printf("%d%n", fn);
            // FibonacciList.set(0, FibonacciList.get(1));
            // FibonacciList.set(1, fn);
            f1 = f2;
            f2 = fn;
        }
        return FibonacciList;
    }
    // mainメソッドを作成する．
    public static void main(String[] args) {
        FibonacciList_854030 printer = new FibonacciList_854030();
        printer.run(args);
    }
}