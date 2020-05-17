/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "DigitalClock"
 * DigitalClock.java 「時間を文字列に整形してデジタル時計」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac DigitalClock.java
 *     >java DigitalClock
 * 【キーワード】
 *     書式文字列(format string), ベースライン(base line:基準線),  *     アセント(ascent:上昇), ディセント(descent:下降),
 * 【試してみよう】
 *     java.text.SimpleDateFormatを使って時刻を整形する *     年月日も表示する。 *     アナログ時計を作る。
 */
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.String;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DigitalClock extends JFrame {
    final static int C00 = 1000;

    public DigitalClock() {
        DrawPanel L00 = new DrawPanel();
        add(L00);

        new Timer(C00, L00).start();
    }

    public static void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);

        DigitalClock L00 = new DigitalClock();
        L00.setTitle("デジタル時計");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.setSize(200, 100);
        L00.setVisible(true);
    }
}

class DrawPanel extends JPanel implements ActionListener {

    public DrawPanel() {
        setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent A00) {
        repaint();
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);

        String L00 = String.format("%1$tp %1$tI:%1$tM:%1$tS", new Date());

        FontMetrics L01 = A00.getFontMetrics();

        A00.drawString(L00, (getWidth() - L01.stringWidth(L00)) / 2,
                (getHeight() + L01.getAscent() - L01.getDescent()) / 2);
    }
}

/* ■ クラスの外でちょっと一言 ■
時刻をリアルタイムで表示するには、定期的に画面を更新しないといけません。
そのために利用しているのが、javax.swing.Timerクラス。1秒ごとにイベントを
発生させ、イベント処理メソッドで画面の再描画要求を出しています。

時刻の文字列を取得するには、java.text.SimpleDateFormat、もしくは
String.formatメソッドを使います。今回はJ2SE 5.0で導入された書式文字列を
使って、String.formatメソッドでフォーマットする方法を採用しました。

"%1$tp %1$tI:%1$tM:%1$tS"という書式は一見複雑ですが、その意味を知ってれ
ば恐れるに足らず。まず"%"で始まる文字列が書式の指示を表します。その後に
続く"1$"は、１番目の引数(= new Date())という意味。つまり4箇所の"%"の部分
が、Dateオブジェクトを文字列化したものに置き換えられます。

"t"という指定は、「日付/時刻」に変換するという意味。"p"は午前か午後、"I"
は12時間制の時、"M"は分、"S"は秒を表します。":"のように書式として解釈さ
れなかったものは、そのまま表示されます。これで、"午前か午後　時：分：秒"
という書式の文字列が完成。詳しくはAPIドキュメントのjava.util.Formatterに
ある、書式文字列の解説を参照してください。

時刻を画面の中心に表示するために、フォントの詳細な情報を取得してます。こ
こで重要になるのが、フォントにおける「ベースライン」という概念。学校で初
めてアルファベットを習ったときの英語のノートを思い出してください。4本線
の下から2番目が赤くなってましたよね。あれが「ベースライン」。'A'はその線
から上に、'y'や'g'は下にはみ出すように配置されます。その「ベースライン」
より上の高さを「アセント」、下の高さを「ディセント」と呼ぶので、これも覚
えておいてください。
 */
