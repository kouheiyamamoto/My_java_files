public class TrueToUpper{
    void run(String[] args){
        for(Integer i = 0; i < args.length; i++){
            String value = args[i].toUpperCase();
            System.out.printf("%s -> %s%n", args[i], value);
        }
    }
    public static void main(String[] args){
        TrueToUpper upper = new TrueToUpper();
        upper.run(args);
    }
}