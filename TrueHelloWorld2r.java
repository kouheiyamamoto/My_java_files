public class TrueHelloWorld2r {
    void run(String[] args) {
        if (args.length == 0) {
            this.greet("World");
        } else {
            this.greet(args[0]);
        }
    }

    void greet(String args) {
        System.out.printf("Hello, %s%n", args);
    }

    public static void main(String[] args) {
        TrueHelloWorld2r hello = new TrueHelloWorld2r();
        hello.run(args);
    }
}