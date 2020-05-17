/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "LoopString"
 * LoopString.java 「円周上に文字を配置する」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac LoopString.java
 *     >java LoopString
 * 【キーワード】
 *     アンチエイリアス(antialias), アフィン変換(affine transform),  *     プロポーショナルフォント(proportional font) *     
 * 【試してみよう】
 *     半円上に文字を配置する。 *     サインカーブ上に文字を配置する。
 */
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.lang.String;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static java.lang.Math.PI;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class LoopString extends JFrame {

    public LoopString() {
        DrawPanel L00 = new DrawPanel();
        add(L00);
    }

    public static void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);

        LoopString L00 = new LoopString();
        L00.setTitle("永遠に続く文章");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.setSize(320, 240);
        L00.setVisible(true);
    }
}

class DrawPanel extends JPanel {
    static final String C00 =
            "サザエさんが買い物しようと町まででかけたら財布を忘れて愉快な";

    public DrawPanel() {
        setBackground(Color.white);
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);
        Graphics2D L00 = (Graphics2D)A00;

        L00.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

        FontMetrics L01 = A00.getFontMetrics();

        for (int L02 = 0; L02 < C00.length(); L02++) {
            int L03 = L01.charWidth(C00.charAt(L02));
            // Y座標は30ドットに固定
            L00.drawString(C00.substring(L02, L02 + 1), (getWidth() - L03) / 2, 30);
            L00.rotate(2.0 * PI / C00.length(), getWidth() / 2.0, getHeight() / 2.0);
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
文字列をぐるりと配置させることで、どこから始まってどこで終わるか分からな
い文章を作ってみました。

フレーズは『サザエさん』のオープニングから引用。この『サザエさん』っての
には、一応の理由があります。『サザエさん』は30年以上続く長寿アニメ。しか
し登場人物の誰一人、歳を取りません。まるで時間が止まったかのような永遠の
世界です。その『サザエさん』に秘められた永遠性を、ループする文字列で表現
したというわけです。深いなぁ、くだらないけど。

プログラム的には、文字列から1文字抜き出して描画、その後画面を回転させて
また描画というのを繰り返してます。こだわったのは、文字を表示する位置。き
ちんと回転の中心の真上に来るよう、FontMetricsを取得して文字の幅を求めて
います。FontMetricsはフォントに関する描画情報を提供してれるクラス。文字
の表示位置を細かく指定するときに利用します。
 */
