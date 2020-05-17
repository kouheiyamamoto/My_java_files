
// 小テスト 3-2
public class Echo_854030 {
    void run(String[] args) {
        String h = "-h";
        String n = "-n";

        if (args[0].equals("-n")) {
            for (Integer i = 1; i < args.length; i++) {
                System.out.print(args[i]);
            }
        } else {
            for (Integer i = 1; i < args.length; i++) {
                System.out.print(args[i]);
                if (i == args.length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public static void main(String[] args) {
        Echo_854030 printer = new Echo_854030();
        printer.run(args);
    }
}