// リストは個数を指定しない配列
import java.util.ArrayList;

public class DoubleValuePrinter {
    void run(String[] args) {
        ArrayList<Double> list = this.buildList(args); // リスト作って
        this.printList(list); // 出力する．
    }

    ArrayList<Double> buildList(String[] args) {
        Integer count = this.parseCount(args); // 生成する個数を決める．
        ArrayList<Double> arrayList = new ArrayList<>(); // 格納するリストを生成する．
        for (Integer i = 0; i < count; i++) {
            arrayList.add(Math.random()); // 実際に格納する．
        }
        return arrayList; // リストを返す．
    }

    Integer parseCount(String[] args) {
        if (args.length == 0) { // コマンドライン引数で何も与えられなかった場合
            return 50;
        }
        return Integer.valueOf(args[0]); // コマンドライン引数で数が与えられた場合
    }

    void printList(ArrayList<Double> arrayList) {
        for (Integer i = 0; i < arrayList.size(); i++) {
            System.out.printf("%2d: %f%n", i, arrayList.get(i));
        }
    }

    public static void main(String[] args) {
        DoubleValuePrinter printer = new DoubleValuePrinter();
        printer.run(args);
    }
}