/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "JavaCurry"
 * DrawPanel.java 「カレーのパッケージをオブジェクト指向で表現」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java JavaCurry
 * 【キーワード】
 *     アンチエイリアス(antialias)
 * 【試してみよう】
 *     JavaCurry.java参照。
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class DrawPanel extends JPanel {
    static final int C00 = 280;
    static final int C01 = 360;
    static final Color C02 = new Color(170, 0, 0);
    static final Color C03 = new Color(250, 190, 20);
    static final Color C04 = new Color(240, 30, 0);
    static final Color C05 = new Color(240, 70, 0);
    List<Parts> I00;

    public DrawPanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(C00, C01));

        I00 = new ArrayList<Parts>();

        I00.add(new Box(10, 10, 260, 340, C03));
        I00.add(new Text("ジャバカレー", 25, 62, C02, 36));
        I00.add(new Text("JAVA CURRY GOLD ゴールド", 30, 84, C02, 16));
        I00.add(new Text("辛さ256倍", 176, 100, Color.red, 16));
        I00.add(new Text("200g・1人分", 25, 330, Color.black, 10));
        I00.add(new Circle(30, 105, 220, C02));
        I00.add(new Circle(60, 135, 160, C04));
        I00.add(new Circle(80, 155, 120, C05));
        I00.add(new Circle(100, 175, 80, C03));
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);
        Graphics2D L00 = (Graphics2D)A00;
        L00.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

        for (Parts L01 : I00) {
            L01.M00(L00);
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
「Javaカレーゴールド」の表示は、「四角」「文字」「円」の3種類のパーツを
組み合わせて実現しています。表示されている文字は、すべてTextクラスのイン
スタンスで、同心円は、Circleクラスのインスタンスを4つ重ねたものです。

そんな具合に、違うクラスから派生したインスタンスですが、最終的にはどれも
Parts型として一括管理されています。これは、Box, Text, Circleそれぞれのク
ラスがPartsインターフェースを実装しているからこそなせるわざ。別々のクラ
スでも、共通要素をインターフェースに抽出することで「同じ種類もの」として
管理することが出来ます。

とにかく、オブジェクト指向を理解してもらうのに、こんなサンプル作るのは、
自分くらいのもんだろうと、つくづく（でもちょっぴり誇りに）思っています。
何年か後に「JavaCurryでオブジェクト指向の意味を理解しました」というプロ
グラマが現れることを、心より願ってやみません。
 */
