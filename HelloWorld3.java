public class HelloWorld3 {
    void run(String[] args) { // String[] argsで配列を追加する
        // args のインデックスの0番目から最後までを繰り返して，
        // args の各要素を出力してみましょう．
        if (args.length == 0) {
            System.out.println("Hello, World");
        } else {
            for (Integer i = 0; i < args.length; i++) {
                // 何番目の要素として，何が配列の要素として格納されているかを確認しましょう．
                // System.out.printf("Hello, %s%n", args[i]);

                if (args[0].equals("World")) {
                    System.out.println("Hi, World");
                } else {
                    System.out.printf("Hello, %s%n", args[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        HelloWorld3 printer = new HelloWorld3(); // このクラスに呼び込まなあかんからこうするのは当たりまえ
        printer.run(args); // 関数に飛ぶ！
    }
}