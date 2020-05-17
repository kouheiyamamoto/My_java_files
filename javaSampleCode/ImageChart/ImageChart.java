/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "ImageChart"
 * ImageChart.java 「JLabelのHTML表示機能で棒グラフを簡単に表示」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac ImageChart.java
 *     >java ImageChart
 * 【キーワード】
 *     HTML(HyperText Markup Language), tableタグ, imgタグ,  *     URL(Uniform Resource Locator)
 * 【試してみよう】
 *     JLabelの内容をSystem.out.printlnで表示して、画像ファイルのURLを確認する。 *     tableタグのborder属性で表に枠をつける。 *     項目ごとの数値も表示する。
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.lang.String;
import java.lang.StringBuffer;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageChart extends JFrame {

    public ImageChart() {
        Item[] L00 = {
            new Item("Ａ社", "image/bar01.gif", 48),
            new Item("Ｂ社", "image/bar02.gif", 159),
            new Item("Ｃ社", "image/bar03.gif", 106),
            new Item("Ｄ社", "image/bar04.gif", 89), 
        };

        StringBuffer L01 = new StringBuffer();

        L01.append("<html><table cellpadding='4' cellspacing='4'>");
        for (Item L02 : L00) {
            L01.append(String.format("<tr><td>%s</td><td>%s</td></tr>", L02.M00(), L02.M01()));
        }
        L01.append("</table></html>");

        add(new JLabel(L01.toString()), BorderLayout.CENTER);
    }

    public static void main(String[] A00) {
        JFrame L00 = new ImageChart();
        L00.setTitle("画像を使ったグラフ");
        L00.getContentPane().setBackground(Color.white);
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.pack();
        L00.setResizable(false);
        L00.setVisible(true);
    }
}

class Item {
    private String I00;
    private String I01;
    private int I02;

    Item(String A00, String A01, int A02) {
        this.I00 = A00;
        this.I01 = A01;
        this.I02 = A02;
    }

    public String M00() {
        return I00;
    }

    public String M01() {
        String L00 = "";
        try {
            URL L01 = new File(I01).toURL();
            L00 = String.format("<img src='%s' width='%d'>", L01, I02);
        } catch (MalformedURLException e) {
            System.out.println("画像ファイルの指定に誤りがあります。");
        }

        return L00;
    }
}

/* ■ クラスの外でちょっと一言 ■
Swingで画像表示というと、JPanelに直接描画するのを思い浮かべるかもしれま
せんが、JLabelにHTMLで表示するというアプローチもあります。今回は、画像と
文字のみで構成されるグラフですので、HTMLのtableタグを利用して、JLabelで
レイアウトすることにしました。

棒グラフの元画像は、どの色も幅8ドット。それをimgタグのwidth属性に値を設
定することで、横の長さを変えています。Webアプリケーションでよく使う手法
ですね。

imgタグにローカルのファイル名を指定する場合は、URLに変換する必要がありま
す。<img src="image/fish00.gif">のように相対パスで指定しても表示されませ
んので注意してください。相対パス→URLの変換は、java.io.Fileオブジェクト
を作って、toURLメソッドを呼べばOK。

JLabelに設定するHTMLタグの連結には、StringBufferを使ってます。Stringを+
で連結するのに比べ、メモリに無駄がありません。「文字を頻繁に連結するとき
はStringBuffer」と覚えておいてください。
 */
