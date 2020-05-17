/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "PieChart"
 * PieChart.java 「アンチエイリアスで円グラフをきれいに表示」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac PieChart.java
 *     >java PieChart
 * 【キーワード】
 *     弧(arc)の塗りつぶし, Java2D, アンチエイリアス(antialias), *     Mapインターフェース
 * 【試してみよう】
 *     データを追加してみる。 *     データの管理にHashMapを使うとどうなるか試してみる。 *     グラフに、値やパーセンテージも表示する。
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.String;
import java.lang.System;
import java.util.Map;
import java.util.LinkedHashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class PieChart extends JFrame {

    public PieChart() {
        add(new DrawPanel());
    }

    public static void main(String[] A00) {
        JFrame L00 = new PieChart();
        L00.setTitle("円グラフ");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.pack();
        L00.setResizable(false);
        L00.setVisible(true);
    }
}

class DrawPanel extends JPanel {
    private static final int C00 = 200;
    private static final int C01 = 200;
    private static final int C02 = 20;  // グラフの表示位置(x方向、y方向兼用)
    private static final int C03 = 5;   // 影のずらし間隔(x方向、y方向兼用)
    private static final int C04 = 150;
    private Color I00 = new Color(64, 64, 64);    // 影とふちの色

    private Map<Color, Integer> I01;
    private int I02;

    public DrawPanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(C00, C01));

        I01 = new LinkedHashMap<Color, Integer>();
        I01.put(new Color(255, 32, 32), 50);
        I01.put(new Color(64, 192, 32), 18);
        I01.put(new Color(96, 32, 255), 32);
        I01.put(new Color(255, 192, 0), 42);
        I01.put(new Color(0, 192, 255), 15);

        I02 = 0;
        for (int L01 : I01.values()) {
            I02 += L01;
        }
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);

        Graphics2D L00 = (Graphics2D)A00;
        L00.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

        L00.setColor(I00);
        L00.fillOval(C02 + C03, C02 + C03, C04, C04);

        int L01 = 90;   // 円グラフの描画開始角度
        int L02 = 0;    // 扇形の中心角
        
        for (Color L03 : I01.keySet()) {
            L02 = Math.round(360f * I01.get(L03) / I02);
            L01 -= L02;
            L00.setColor(L03);
            L00.fillArc(C02, C02, C04, C04, L01, L02);
        }
        // 四捨五入の都合で塗り残しが出た場合の対処
        L00.fillArc(C02, C02, C04, C04, -270, L02);

        L00.setColor(I00);
        L00.drawOval(C02, C02, C04, C04);
    }
}

/* ■ クラスの外でちょっと一言 ■
通常、円グラフは、真上（時計の12時）から右回りに項目を配置しますが、
fillArcメソッドでは、右方向の水平線（時計の3時）を0度として、左回りに中
心角を指定します。その都合で、このサンプルでは、90度(真上)から描画を始め
て、-270度(真上)で終わるという構造になってます。複雑ですが、ヒントを多め
に入れてますんで、頑張って解析してください。

グラフに利用するデータは、色と数値組み合わせたMapで管理しています。Mapに
は追加した順番を保持するLinkedHashMapを採用しました。ちなみに、色をキー
にしてますので、Mapの特性上、同じ色を2度使うことは出来ません。

ウィンドウサイズの指定には、ちょっとした仕掛けがあります。JFrameに対して
setSizeメソッドでサイズを指定すると、枠やタイトルバー込みのサイズになっ
てしまいますよね。今回のサンプルのように、表示領域を中心に寸法を決めたい
場合は、表示パネルに対して、setPreferredSizeメソッドで必要なサイズを指定
して、フレームのpackメソッドを呼べば、この表示領域が収まる、最適なフレー
ムサイズになってくれます。

アンチエイリアスをかけると、描画速度が遅くなりますが、今回のようなアニ
メーションを伴わない図形描画なら、問題ありませんので、見た目優先でどんど
ん利用していっていいと思います。
 */
