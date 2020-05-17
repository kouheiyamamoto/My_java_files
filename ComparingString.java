// 特定の文字列であるかどうかを確認するプログラム
public class ComparingString{

    void run(String[] args){
        // もしも入力がなけらば
        if(args.length == 0){ 
            System.out.println("数字を入力してください");
        }else{ // もしも入力があれば
            for(Integer i = 0; i < args.length; i++){
                if(args[i].equals("KSU_AP")){ // もしも文字列の中身がKSU_APだったら
                    System.out.printf("渡された文字列は\"%s\"です。%n",args[i]); // \"でダブルクォーテーションの出力
                }else{
                    System.out.printf("渡された文字列は\"KSU_AP\"ではなく\"%s\"です%n",args[i]);
                }
            }
        }

    }
    public static void main(String[] args){
        ComparingString compare = new ComparingString();
        compare.run(args);
    }
}