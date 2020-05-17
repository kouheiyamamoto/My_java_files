/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Category"
 * DataManager.java 「Setを使ったカテゴリー分類」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java Category
 * 【キーワード】
 *     ジェネリックス(generics), 拡張forループ, Set(集合), List(リスト),  *     equalsによる文字列の比較 *     
 * 【試してみよう】
 *     Category.javaを参照。
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DataManager {
    static final String C00 = "comic_char.csv";
    List<ComicChar> I00 = new ArrayList<ComicChar>();

    public DataManager() {
        // CSVファイルからデータを読み込んでリストに追加
        try {
            BufferedReader L00 = new BufferedReader(new FileReader(C00));
            String L01;
            while( (L01 = L00.readLine()) != null ) {
                String[] L02 = L01.split(",");
                I00.add(new ComicChar(L02[0], L02[1]));
            }
            L00.close();
        } catch(FileNotFoundException L03) {
            System.out.println(C00 + "が見つかりませでした。");
        } catch(IOException L04) {
            System.out.println(C00 + "を読み込めませんでした。");
        }
    }
    
    // カテゴリーの配列を返す
    public String[] M00() {
        Set<String> L00 = new LinkedHashSet<String>();
        
        for (ComicChar L01 : I00) {
            L00.add(L01.I00);
        }

        return L00.toArray(new String[0]);
    }

    // カテゴリーを指定して検索
    public List<ComicChar> M01(String A00) {
        List<ComicChar> L00 = new ArrayList<ComicChar>();

        for (ComicChar L01 : I00) {
            if (L01.I00.equals(A00)) {
                L00.add(L01);
            }
        }

        return L00;
    }
}

/* ■ クラスの外でちょっと一言 ■
データの管理を担当するこのクラスには3つの機能が備わってます。

まずは、コンストラクタで外部ファイルからデータを読み込む機能。読み込まれ
たデータは1件ごとインスタンス化されて、Listに追加されます。以降、この
Listから、随時必要なデータを取り出すことになります。コンストラクタなん
で、ファイルの読み込みは最初の１回だけですね。

次は、カテゴリーを集計する機能。読み込んだListから、カテゴリーを取り出し
てますが、ポイントは、重複を省く必要があるということ。そこでコレクション
フレームワークのSetの登場です。Setは、数学でいうところの「集合」で、重複
要素を持たないという性質があります。こういう集計にはぴったりですね。

Setから配列への変換にtoArrayメソッドを使ってますが、その引数にString[0]
と、長さ0の配列を渡してます。このメソッドは、「配列のサイズが十分でない
場合は、同じ実行時の型で新しい配列が格納用として割り当てられる」そうなの
で、配列の長さは0でOK。大事なのは配列の型だけです。

最後に、指定されたカテゴリーのデータだけを取り出す機能。元のListから該当
するデータを選んで、別のListに追加しています。「毎回新しいListを生成し
て、メモリは大丈夫か？」という気がしますが、Listにはインスタンスの参照が
入るだけなので、それほど資源は消費しません。

ジェネリックスのおかげで面倒な型変換がなく、拡張forループですっきりと全
要素の走査ができてます。このへんは、J2SE 5.0さまさまですね。
 */
