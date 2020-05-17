/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Category"
 * Category.java 「Setを使ったカテゴリー分類」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java Category
 * 【キーワード】
 *     クラス設計(class design), Model(処理), View(表示)
 * 【試してみよう】
 *     CSVにデータを追加し、カテゴリーが増えるのを確認する。 *     編集した内容をCSVに書き出す「保存」機能をつける。 *     
 */
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Category extends JFrame implements ActionListener {
    JComboBox I00;
    JTextArea I01;
    DataManager I02;
    
    public Category() {
        I02 = new DataManager();
        // カテゴリーのリストを取得して、コンボボックスを作成
        I00 = new JComboBox(I02.M00());
        I01 = new JTextArea();
        add(I00, BorderLayout.NORTH);
        add(I01, BorderLayout.CENTER);
        
        I00.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent A00) {
        String L00 = (String)I00.getSelectedItem();
        // 選択されたカテゴリーに含まれるデータを検索
        List<ComicChar> L01 = I02.M01(L00);

        I01.setText("");
        
        for (ComicChar L02 : L01) {
            I01.append(L02.I01 + "\n");
        }
    }

    public static void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);

        Category L00 = new Category();
        L00.setTitle("カテゴリーごとに分類");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setSize(320, 240);
        L00.setVisible(true);
    }
}

/* ■ クラスの外でちょっと一言 ■
CSVファイルからデータを読み込み、カテゴリーごとに分類して表示するプログ
ラムです。まずはプログラムを動かし、付属のCSVファイルの中身と見比べてく
ださい。

このサンプルは、Category、DataManager、ComicCharの3つのクラスで構成され
ており、それぞれで役割を分担しています。Categoryクラスは、GUIやイベント
処理などを担当。ComicCharは1件のデータを表すクラスで、そのComicCharのリ
ストをDataManagerクラスが管理する構造になってます。

クラス設計において、「画面表示」と「データ管理」を分けるのは基本中の基
本。クラス分けに悩む場合は、まずここを取っ掛かりにすればいいかと思いま
す。
 */
