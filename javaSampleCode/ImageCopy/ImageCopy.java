/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "ImageCopy"
 * ImageCopy.java 「画像をスムーズに拡大縮小」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac ImageCopy.java
 *     >java ImageCopy
 * 【キーワード】
 *     スケーリング(scaling:拡大縮小), 非同期(asynchronous), 
 * 【試してみよう】
 *     縮小してみる。 *     SCALE_SMOOTHと他のスケーリングアルゴリズムを比較する。
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.lang.String;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageCopy extends JFrame {

    public ImageCopy() {
        add(new DrawPanel());
    }

    public static void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);

        JFrame L00 = new ImageCopy();
        L00.setTitle("イメージを拡大コピー");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setSize(400, 400);
        L00.setVisible(true);
    }
}

class DrawPanel extends JPanel {
    static final String C00 = "image/image.gif";
    static final int C01 = 130;        // スケール率(%)
    Image I00;
    int I01;
    int I02;
    Image I03;

    public DrawPanel() {
        setBackground(Color.white);

        I00 = new ImageIcon(C00).getImage();
        I01 = I00.getWidth(this);
        I02 = I00.getHeight(this);

        I03 = I00.getScaledInstance(I01 * C01 / 100, -1, Image.SCALE_SMOOTH);

        MediaTracker L00 = new MediaTracker(this);
        L00.addImage(I03, 1);
        try {
            L00.waitForAll();
        } catch (InterruptedException L01) {
        }
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);

        A00.drawString("原寸", 10, 20);
        A00.drawImage(I00, 10, 25, this);

        A00.drawString("単純に拡大(" + C01 + "%)", 10, 180);
        A00.drawImage(I00, 10, 185, I01 * C01 / 100, I02 * C01 / 100, this);

        A00.drawString("スムーズに拡大(" + C01 + "%)", 200, 180);
        A00.drawImage(I03, 200, 185, this);
    }
}
/* ■ クラスの外でちょっと一言 ■
画像の拡大表示といえば、java.awt.GraphicsのdrawImageで、幅と高さを指定す
る方法が有名ですが、画質はあまり良くありません。特に元画像がイラストタッ
チの輪郭のくっきりした絵だと、そのアラは目立ちます。Graphics2Dでアンチエ
イリアスを指定しても、図形や線の描画にしか適用されませんので対処不可能。

そこで登場するのがjava.awt.ImageのgetScaledInstanceメソッド。これは、元
の画像を拡大縮小した新たなImageオブジェクトを作ってくれます。その際に
「画質優先」「速度優先」などアルゴリズムを指定することができます。

このサンプルで指定した「SCALE_SMOOTH」はもっとも滑らかな画質で拡大縮小す
るもの。その分、処理は遅くなってます。今回は、コンストラクターで１度生成
するだけですが、paintComponentなどで頻繁に行う可能性がある場合は、画質を
落として処理速度を優先する選択肢も考慮してください。

getScaledInstanceメソッドで、高さに-1を指定してるのは、「width と height
のどちらかが負の数値の場合、元のイメージ寸法の縦横比を維持する(APIドキュ
メントより)」からです。

このメソッドで気をつけなければいけないのは、非同期にイメージをロードする
ということ。つまり、MediaTrackerを使ってロードの終了を待つ必要がありま
す。Javaでは、非同期に画像を読み込むことが多いので、この対処方法を覚えて
おいてください。
 */
