
// 練習問題12
import java.util.ArrayList;

public class StringSimilarities {

    // runMethod(いうたらmainMethod)
    void run(String[] args) {
        if (args.length == 0) { // もしも引数に何もなかったら
            System.out.println("input your some id");
        } else {
            ArrayList<Character> list1 = getList(args[0]); // 文字列1つ目
            ArrayList<Character> list2 = getList(args[1]); // 文字列2つ目
            ArrayList<Character> list3 = getPraneList(args[0]);
            ArrayList<Character> list4 = getPraneList(args[1]);
            ArrayList<Character> list5 = getList(args[0] + args[1]); // 2つの文字列を合わせたやつを重複しないようにリストに入れる
            System.out.printf("simpson(%s, %s)=%f%n", args[0], args[1], simpson(list1, list2));
            System.out.printf("jaccard(%s, %s)=%f%n", args[0], args[1], jaccard(list1, list2));
            System.out.printf("Dice(%s, %s)=%f%n", args[0], args[1], dice(list1, list2));
            System.out.printf("cosine(%s, %s)=%f%n", args[0], args[1], cosine(list3, list4, list5));
            System.out.printf("edit_distance(%s, %s)=%d%n", args[0], args[1], edit_distance(args[0], args[1]));
        }
    }

    // simpsonメソッド
    Double simpson(ArrayList<Character> id1, ArrayList<Character> id2) {
        return getProductSet(id1, id2).doubleValue() / getMin(id1.size(), id2.size()).doubleValue();
    }

    // jaccardMethod
    Double jaccard(ArrayList<Character> id1, ArrayList<Character> id2) {
        Integer union = id1.size() + id2.size() - getProductSet(id1, id2); // 和集合の値を代入する。
        return getProductSet(id1, id2).doubleValue() / union.doubleValue();
    }

    // diceメソッド
    Double dice(ArrayList<Character> id1, ArrayList<Character> id2) {
        return ((2.0 * getProductSet(id1, id2).doubleValue()) / ((double) id1.size() + (double) id2.size()));
    }

    // cosineMethod
    Double cosine(ArrayList<Character> id1, ArrayList<Character> id2, ArrayList<Character> id3) {
        // cosを求める時分子は積集合、分母はルートの長さ同士の積
        Integer length1 = lengthVectol(makeVectol(id1, id3));
        Integer length2 = lengthVectol(makeVectol(id2, id3));
        Integer product = productVectol(makeVectol(id1, id3), makeVectol(id2, id3));
        return product.doubleValue() / (Math.sqrt(length1.doubleValue()) * Math.sqrt(length2.doubleValue())); // cosine類似度の計算結果を返す。
    }

    Integer edit_distance(String id1, String id2) {
        Table<Integer> table = initTable(id1, id2); // tableに列と行の数字を代入
        for(Integer i = 1; i <= id1.length(); i++){
            for(Integer j = 1; j <= id2.length(); j++){
                Integer cost = 1;
                if(id1.charAt(i-1) == id2.charAt(j-1)){
                    cost = 0;
                }
                Integer d1 = table.get(i - 1, j ) + 1;
                Integer d2 = table.get(i, j - 1) + 1;
                Integer d3 = table.get(i - 1, j - 1) + cost;
                table.set(getMinimum(d1, d2, d3), i, j);
            }
        }
        // for debug.
        // table.print();
        return table.get(id1.length(), id2.length());
    }

    // 重複してない文字の集合を取得するためのメソッド
    ArrayList<Character> getList(String item) {
        ArrayList<Character> list = new ArrayList<Character>();
        for (Integer i = 0; i < item.length(); i++) {
            Character c = item.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
            }
        }
        return list;
    }

    // 取得した文字列の重複を無視したやつを返すメソッド
    ArrayList<Character> getPraneList(String id) {
        ArrayList<Character> rlist = new ArrayList<>();
        for (Integer i = 0; i < id.length(); i++) {
            rlist.add(id.charAt(i));
        }
        return rlist;
    }

    ArrayList<String> getStringList(String id){
        ArrayList<String> slist = new ArrayList<>();
        String[] idArray = id.split("");
        for(Integer i = 0; i < idArray.length; i++){
            slist.add(idArray[i]);
        }
        return slist;
    }

    // ２つの数を比べて小さい方の値をminに代入して返すメソッド
    Integer getMin(Integer count1, Integer count2) {
        if (count1 < count2) {
            return count1;
        } else {
            return count2;
        }
    }

    Integer getMinimum(Integer d1, Integer d2, Integer d3) {
        Integer min = d1;
        if (min > d2) {
            min = d2;
        }
        if (min > d3) {
            min = d3;
        }
        return min;
    }

    // 2つの文字列を比べて被ってる文字の個数を返すメソッド
    Integer getProductSet(ArrayList<Character> list1, ArrayList<Character> list2) {
        Integer productSet = 0;
        for (Integer i = 0; i < list1.size(); i++) {
            if (list1.contains(list2.get(i))) {
                productSet++;
            }
        }
        return productSet;
    }

    // 引数の一つ目と和集合のリストを比べて文字数のベクトルを作る
    ArrayList<Integer> makeVectol(ArrayList<Character> list, ArrayList<Character> list3) {
        ArrayList<Integer> vectol = new ArrayList<>(); // 数字を代入するためのリストを作成
        Integer count = 0;
        // 全部の文字列を比較して個数を数える
        for (Integer i = 0; i < list3.size(); i++) {
            count = 0;
            for (Integer j = 0; j < list.size(); j++) {
                if (list3.get(i).equals(list.get(j))) {
                    count++;
                }
            }
            vectol.add(count);
        }
        return vectol;
    }

    // 得られたベクトルから平方根のベクトルの長さを求める
    Integer lengthVectol(ArrayList<Integer> vectol) {
        Integer sum = 0;
        for (Integer i = 0; i < vectol.size(); i++) {
            sum += (vectol.get(i)) * (vectol.get(i));
        }
        return sum;
    }

    // 得られた2つのベクトルからそれぞれの積を得るメソッド
    Integer productVectol(ArrayList<Integer> vectol1, ArrayList<Integer> vectol2) {
        Integer product = 0;
        for (Integer i = 0; i < vectol1.size(); i++) {
            product += vectol1.get(i) * vectol2.get(i);
        }
        return product;
    }

    // tableの0行め, 0列めに数字を代入するメソッド
    Table<Integer> initTable(String item1, String item2){
        Table<Integer> td = new Table<Integer>(item1.length()+1, item2.length()+1);
        // 引数の2コメを0行めに代入する。
        for (Integer i = 0; i <= item2.length(); i++) {
            td.set(i, 0, i);
        }
        // 引数の1こめを0列めに代入する。
        for (Integer i = 0; i <= item1.length(); i++) {
            td.set(i, i, 0);
        }
        return td;
    }

    public static void main(String[] args) {
        StringSimilarities distance = new StringSimilarities();
        distance.run(args);
    }
}