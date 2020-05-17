public class ArgsReverser{

    void run(String[] args){
        if(args.length == 0){ // 入力がなかったら
            System.out.println("何かを入力してください");
        }else{
            for(Integer i = 0; i < args.length; i++ ){
                StringBuffer sb = new StringBuffer(args[i]); // reverseメソッドを使うためにStringBuffer型に代入
                System.out.printf("%s, %s%n",args[i], sb.reverse()); 
            }
        }
    }
    // // 引数の順番を入れ替えるためのメソッド
    // void reverse(String id){
    //     System.out.print()
    // }
    public static void main (String[] args){
        ArgsReverser reverse = new ArgsReverser();
        reverse.run(args);
    }
}