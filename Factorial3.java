public class Factorial3{
    void run(String[] args){
        for(Integer i = 0; i < args.length; i++){
            Integer number = Integer.valueOf(args[i]);
            this.print(number, this.factorial(number));
        }
    }
    Integer factorial(Integer number){
        if(number == 1){
            return 1;
        }
        return number * this.factorial(number - 1);
    }
    void print(Integer number, Integer result){
        System.out.printf("%d! = %d%n", number, result);
        System.out.printf("factorial(%d)%n", number);
    }
    // mainメソッド
    public static void main(String[] args){
        Factorial3 printer = new Factorial3();
        printer.run(args);
    }
}