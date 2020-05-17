/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Gachoooon"
 * Gachoooon.java 「JScrollBarで画像を拡大縮小」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Gachoooon.java
 *     >java Gachoooon
 * 【キーワード】
 *     最大値(maximum), 最小値(minimum), 現在値(current value), 範囲(extent),  *     方向(orientation), 垂直(vertical), 水平(horizontal), 谷啓
 * 【試してみよう】
 *     横スクロールバーで「ガチョーン」。 *     JScrollBarの最大値、最小値、ツマミの長さを変えてみる。
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.lang.String;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;

public class Gachoooon extends JFrame implements AdjustmentListener {
    DrawPanel I00;

    public Gachoooon() {
        JScrollBar L00 = new JScrollBar(JScrollBar.VERTICAL);
        L00.addAdjustmentListener(this);
        add(L00, BorderLayout.EAST);

        I00 = new DrawPanel(L00.getMaximum() - L00.getVisibleAmount());
        add(I00, BorderLayout.CENTER);
    }
    
    public void adjustmentValueChanged(AdjustmentEvent A00) {
        I00.M00(A00.getValue());
        I00.repaint();
    }

    public static void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);

        Gachoooon L00 = new Gachoooon();
        L00.setTitle("谷啓になったつもりで！");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.pack();
        L00.setVisible(true);
    }
}

class DrawPanel extends JPanel {
    static final String C00 = "image/gachoooon.gif";
    private Image I00;
    private int I01;    // 幅
    private int I02;    // 高さ
    private int I03;    // 最大値
    private int I04;    // 現在値

    public DrawPanel(int A00) {
        this.I03 = A00;

        setBackground(Color.white);

        I00 = new ImageIcon(C00).getImage();
        I01 = I00.getWidth(this);
        I02 = I00.getHeight(this);

        setPreferredSize(new Dimension(I01, I02));
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);

        int L00 = I01 * I04 / I03;
        int L01 = I02 * I04 / I03;

        A00.drawImage(I00,(getWidth() - L00) / 2, (getHeight() - L01) / 2,
                L00, L01, this);
    }

    public void M00(int A00) {
        this.I04 = A00;
    }
}

/* ■ クラスの外でちょっと一言 ■
JScrollBarを構成する要素は、最小値、最大値、現在値、表示範囲(=ツマミの長
さ)の４つ。ツマミを動かせばAdjustmentEventが発生し、そのイベントでツマミ
の位置を取得することができます。

デフォルトでは、最小値=0、最大値=100、現在地=0、ツマミの長さ=10のスク
ロールバーが生成されます。では、そのデフォルトのスクロールバーが返す最大
の値はいくつになるでしょう？　答えは、最大値(100)－ツマミの長さ(10)の90
です。

そもそもスクロールバーとは、広い領域の一部分を表示するためにあるもの。ツ
マミの長さは表示する範囲を表します。ですので、この例でいえば、90の位置か
ら10の分量を表示すれば、全体の100を表示することが可能で、スクロールバー
の機能としてはこれで充分なわけです。

そういう観点からすると、画像の拡大縮小にスクロールバーを使うのは邪道で、
スライダー(JSlider)の方が適切と思われます。でも今回は、ウィンドウの右側
にある見慣れたスクロールバーで「ガチョーン」をするのが面白さなんで、ご勘
弁を。

最後に、近頃の若いもんに忠告。ただズルッとスクロールバーを下げるなんて野
暮なマネはしないように。下の方で細かく上下に動かして「ガチョーン」のカメ
ラワークを再現するんだぞ。頼むからな。
 */
