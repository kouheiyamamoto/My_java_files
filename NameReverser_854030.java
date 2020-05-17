public class NameReverser_854030 {
    public static void main(String[] args) {
        String name; // String型変数nameを宣言しました。
        name = "KouheiYamamoto";
        System.out.println(name);
        // nameを逆順に出力する処理
        for ( Integer i = name.length()-1; i >= 0; i--) {
            System.out.print(name.charAt(i));
        } 
        System.out.println(); // 最後は改行
    }
}