/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "ImageRotation"
 * ImageRotation.java 「画像を回転させる」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac ImageRotation.java
 *     >java ImageRotation
 * 【キーワード】
 *     Java2D, java.awt.geomパッケージ, AffineTransformクラス, ラジアン(radian)
 * 【試してみよう】
 *     回転速度を上げ、「いつもより多く」回す。 *     画像の中心と回転の中心をずらし、「いつもより大きく」回す。 *     文字や図形など、「いつもと違う物」も回す。
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import static java.lang.Math.PI;

public class ImageRotation extends JFrame {
    final static int C00 = 30;

    public ImageRotation() {
        DrawPanel L00 = new DrawPanel();
        add(L00);

        new Timer(C00, L00).start();
    }

    public static void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);

        JFrame L00 = new ImageRotation();
        L00.setTitle("おめでとうございま～す！");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.setSize(320, 240);
        L00.setVisible(true);
    }
}

class DrawPanel extends JPanel implements ActionListener {
    static final String C00 = "image/rotation.gif";
    Image I00;
    int I01;
    int I02;
    int I03 = 0;

    public DrawPanel() {
        setBackground(Color.white);

        I00 = new ImageIcon(C00).getImage();
        I01 = I00.getWidth(this);
        I02 = I00.getHeight(this);
    }

    public void actionPerformed(ActionEvent A00) {
        I03 = ++I03 % 360;
        repaint();
    }

    public void paintComponent(Graphics A00) {
        Graphics2D L00 = (Graphics2D)A00;
        L00.setColor(Color.white);
        L00.fillRect(0, 0, getWidth(), getHeight());

        L00.rotate(I03 * PI / 180, getWidth() / 2.0, getHeight() / 2.0);
        L00.drawImage(I00, (getWidth() - I01) / 2, (getHeight() - I02) / 2, this);
    }
}

/* ■ クラスの外でちょっと一言 ■
画像の回転というと、元となる画像を回転させて、それから表示するという手順
を思い浮かべがちですが、ここでは、座標軸の方を回転させて、毎回同じ位置に
画像を貼り付けるという手法をとってます。

回転の中心角をパネルの中心に設定し、さらに、パネルの中心に画像を表示して
ますので、結果的に画像の中心で回転するというわけですね。

このrotateメソッドはGraphics2Dクラスのものですが、J2SE1.2以降、paintに渡
されるGraphicsオブジェクトは、Graphics2Dのサブクラスですので、そのまま
キャストすることによってGraphics2Dとして利用することが出来ます。
 */
