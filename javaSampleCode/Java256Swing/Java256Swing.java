/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Java256Swing"
 * Java256Swing.java 「JPanelに色を指定して文字を描画する」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Java256Swing.java
 *     >java Java256Swing
 * 【キーワード】
 *     コンテンツ区画(content pane), Look & Feel, オーバーライド(override:上書き) *     コンポーネント(component:部品), コンテナ(container:入れ物)
 * 【試してみよう】
 *     setDynamicLayoutをコメントアウトし、どう挙動が変化するか調べる。 *     （特に、ウィンドウのサイズを変更したときに注意） *     文字だけではなく、図形も描画する。 *     JPanelではなく、JLabelを使って赤い文字を表示する。
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.lang.String;
import java.lang.System;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Java256Swing extends JFrame {
    public Java256Swing() {
        add(new DrawPanel());
    }

    static public void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);

        JFrame L00 = new Java256Swing();
        L00.setTitle("文字を表示");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.setSize(300, 100);
        L00.setVisible(true);
    }
}

class DrawPanel extends JPanel {
    public DrawPanel() {
        setBackground(Color.white);
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);
        A00.setColor(Color.red);
        A00.drawString("燃える男の赤いJava256、それがお前だぜ。", 10, 30);
    }
}

/* ■ クラスの外でちょっと一言 ■
Swingプログラミングでは、JFrame（いわゆるウィンドウ）などの土台となる入
れ物(コンテナ)に、様々な部品(コンポーネント)を追加していくことで、機能を
組み込んでいきます。

このサンプルでは、色つきの文字を表示するのに、JPanelを拡張し、文字表示機
能を持たせたDrawPanelクラスを作り、そこで、描画メソッドである
paintComponentを上書き(オーバーライド)することで、文字を表示する処理を実
装しました。

このプログラムを作るまで、Swingに対して、「中身を表示しながら、ウィンド
ウのサイズも変えられないのかよ、このタコ！」とか、「いちいち背景を塗りな
おすから遅いんだよ、もうイヤンバカン！」とか、文句ばかりを言ってたんです
よ。でも実は、僕が制御の方法を知らないだけのことでした。Swingさんゴメン
なさい。
 */
