public class ToUpper {
    void run(String[] args) { // String[] argsで配列を追加する
        // args のインデックスの0番目から最後までを繰り返して，

        String original;
        String upper;
        // => original に代入されている文字が全て大文字になって，upperに代入される．Ï．
        for (Integer i = 0; i < args.length; i++) {
            original = new String(args[i]);
            upper = original.toUpperCase();
            // 何番目の要素として，何が配列の要素として格納されているかを確認しましょう．
            System.out.printf("%s -> %s%n",original,upper);
        }
    }

    public static void main(String[] args) {
        ToUpper printer = new ToUpper();
        printer.run(args);
    }
}