
/* ArrayListはリストの基本的な型
   import java.util.ArrayList;っていうimport分が必要
   
   ArrayList<String> listForStrings = 
    new ArrayList<String>();
　 ArrayList<Integer> listForIntegers = 
    new ArrayList<Integer>();がリスとの宣言の仕方
　 
   // listにデータを追加する 
　 String value1 = // ...
list.add(value1);
list.add("Haruaki Tamada");
// list.add(9); // => コンパイルエラーが発生する．
    // 9 は String型ではないため．
list.add("9"); // => OK．"9"は文字列．

　 // listにあるデータを取得する
　 String item1 = list.get(0);
    // => listのインデックスも配列と同じように0から始まる．
String item2 = list.get(1);
String item100 = list.get(100);
    // => 範囲を超えてアクセスしようとすると，実行時に
    // IndexOutOfBoundsException というエラーが発生する．

    指定したインデックスの要素を削除したい場合は，removeメソッドを 利用します．removeを使って削除したあと，後ろの要素は詰められます． すなわち，次のコードで全ての要素を順番に削除できます
    while(!list.isEmpty()){ // listが空じゃない間繰り返す．
    list.remove(0);     // 一番最初の要素を削除する．
}

　  for(Iterator<String> iterator = list.iterator(); 
        iterator.hasNext(); ){
    String item = iterator.next();
    // ここに繰り返しの処理を書く．
}

　  // 拡張for文
拡張for文と呼ばれる書き方．実質的には，Iteartor型を利用する方法と同じ． コンパイラがIterator型を利用する方法に変換してコンパイルする．最近はこの書き方が多い．
　  for(String item: list){
    // ここに繰り返しの処理を書く．
}
*/

import java.util.ArrayList; // ArrayListをimport

public class List {

    void run(String[] args) { // 戻り値はなく、引数を受け取った
        ArrayList<String> list = this.buildList(args); // 変数listにはargsを使って値を出したbuildlistにから値が代入される、thisは自分自身をオブジェクトとする
        this.printList(list); // 上の行で得たlistを使ってprintListメソッドに飛ぶ
    }

    // ArrayList関数
    ArrayList<String> buildList(String[] array) { // ArrayList型で値を返す、String配列型で値を受け取る
        ArrayList<String> arrayList = new ArrayList<>(); // String型のArrayListを宣言した。
        for (Integer i = 0; i < array.length; i++) { // ちなみにarray.lengthは配列の要素数を求める
            arrayList.add(array[i]);
        }
        return arrayList; // 戻り値としてarrayListを返す
    }

    void printList(ArrayList<String> arrayList) {
        for (String item : arrayList) { // itemにarrayList分ループをまわす
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        List printer = new List();
        printer.run(args); // argsを使ってrunメソッドに飛ぶ！
    }
}
