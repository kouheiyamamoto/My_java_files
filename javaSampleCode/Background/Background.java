/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "Background"
 * Background.java 「ウインドウの背景に画像を敷き詰める」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac Background.java
 *     >java Background
 * 【キーワード】
 *     背景(background)の塗りつぶし, BorderLayout, do whileループ, *     ImageIcon
 * 【試してみよう】
 *     ボタン以外のコンポーネントを配置してみる。 *     OKボタンを押すたびに背景の画像が変わるようにする。 *     （imageフォルダに"dot.gif"という画像を用意してます）
 */
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.String;
import java.lang.System;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Background extends JFrame {

    public Background() {
        JPanel L00 = new BgPanel();
        L00.setLayout(new BorderLayout());
        JPanel L01 = new JPanel();
        L01.setOpaque(false);
        L01.add(new JButton("OK"));
        L00.add(L01, BorderLayout.SOUTH);

        setContentPane(L00);
    }

    static public void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        System.setProperty("sun.awt.noerasebackground", "true");

        JFrame L00 = new Background();
        L00.setTitle("背景に画像を敷き詰めてます");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setSize(320, 240);
        L00.setVisible(true);
    }
}

class BgPanel extends JPanel {
    static final String C00 = "image/raster.gif";
    Image I00;
    int I01;
    int I02;

    public BgPanel() {
        I00 = new ImageIcon(C00).getImage();
        I01 = I00.getWidth(this);
        I02 = I00.getHeight(this);
    }

    public void paintComponent(Graphics A00) {
        if (I01 <= 0 || I02 <= 0) {
            return;
        }

        int L00 = 0;
        do {
            int L01 = 0;
            do {
                A00.drawImage(I00, L00, L01, this);
                L01 += I02;
            } while (L01 < getHeight());
            L00 += I01;
        } while (L00 < getWidth());
    }
}

/* ■ クラスの外でちょっと一言 ■
背景の画像はImageIconクラスを使って読み込んでます。このクラスのコンスト
ラクターは、メディアトラッカー(java.awt.MediaTracker)を使って、イメージ
が完全に読み込まれるまで待機してくれるので、便利ですね。ちなみに、画像
フォーマットはGIF、JPEG、PNGに対応してます。

システムプロパティを使って、背景の塗りつぶしを抑制してます。今後も永続的
に提供されることが保証されている機能ではありませんが、5.0でも引き続き提
供されたので、しばらくは使えそうな予感です。

ボタン用のパネルは、後ろに敷いた背景用パネルが見えるように、
setOpaque(false)で透明にしてますが、この"Opaque"は「不透明な」という意味
で、「オウペイク」と発音します。でも僕は、最初これを「オパキュー」と読ん
でしまい、以来ずっと、「オバキュー→オバケのＱ太郎→透明」の連想で
「setOpaque(true)で透明だ！」という呪縛から逃れられずにいます。

ということで、Sun Microsystems様へ。ご多忙の折とは存じ上げますが、
JComponentに以下のようなメソッドを追加していただけると、僕はとっても幸せ
です。

public void setObaque(boolean isObaque) {
    setOpaque(!isObaque);
}
 */
