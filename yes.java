public class Yes {
    void run(String[] args) {
        if (args.length == 0) {
            roop("y");
        } else {
            roop(args[0]); // 先頭の文字列を渡す。
        }
    }

    // 無限ループを表示するためのメソッド
    void roop(String id) {

        while (true) {
            System.out.println(id);
        }
    }
    
    public static void main(String[] args) {
        Yes roop = new Yes();
        roop.run(args);
    }
}