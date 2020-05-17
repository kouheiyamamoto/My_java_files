public class HelloWorld2r {
  void run(String[] args){
    if( args.length == 0 ){
      this.greet("World");
    }
    else{
      this.greet(args[0]);
    }
  }

  void greet(String name){
    System.out.printf("Hello, %s%n", name);
  }

    public static void main(String[] args) {
        HelloWorld2r printer = new HelloWorld2r();
        printer.run(args);
    }
}