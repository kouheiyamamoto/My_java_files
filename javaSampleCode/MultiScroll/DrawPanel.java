/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "MultiScroll"
 * DrawPanel.java 「透過GIFを利用して、背景を多重スクロール」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java MultiScroll
 * 【キーワード】
 *     透過GIF(transparent gif), ジェネリックス(generics), 拡張forループ,  *     コレクションフレームワーク(Collections Framework),  *     
 * 【試してみよう】
 *     MultiScroll.java参照。
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

class DrawPanel extends JPanel implements ActionListener {
    List<Background> I00 = new ArrayList<Background>();

    public DrawPanel() {
        setPreferredSize(new Dimension(400, 300));

        I00.add(new Background("image/bg00.gif", 1));
        I00.add(new Background("image/bg01.gif", 2));
        I00.add(new Background("image/bg02.gif", 4));
        I00.add(new Background("image/bg03.gif", 0));
        I00.add(new Background("image/bg04.gif", 5));
    }

    public void actionPerformed(ActionEvent A00) {
        for (Background L00 : I00) {
            L00.M03();
        }

        repaint();
    }

    public void paintComponent(Graphics A00) {
        for (Background L00 : I00) {
            A00.drawImage(L00.M00(), L00.M02(), 0, this);
            A00.drawImage(L00.M00(), L00.M02() - L00.M01(), 0, this);
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
このクラスは画面表示と画像の管理を担当しています。

まず注目してもらいたいのがコンストラクター。背景オブジェクトを生成して、
Listに追加してます。背景の生成時に指定するのは、画像ファイル名とスクロー
ルのスピード。遠くをゆっくり、手前を速く動かすことで、遠近感のある多重ス
クロールが実現されます。また、リストに追加する順番も重要です。この追加順
が描画順にもなるので、奥に配置するものから順番に追加していきます。

ここで使用する画像には、いくつかの仕掛けがあります。空、雲、地面、車、草
の5枚の背景が用意してあるんですが、空以外の4枚はGIFの透明色の指定を使っ
て、その下にある画像が透けて見えるようになってます。また、右の端が左の端
につながるループ構造にもなってます。画面サイズを400x300で固定してますの
で、画像はこのサイズ以上の幅が必要。今回は全て400x300でそろえています。

表示メソッドでは、まずスクロール位置に1回描画して、画像の幅ぶん左にずら
した位置にもう1回描画してます。こうすることで、背景のループを実現してい
ます。左右がループ構造になった画像を用意したのはこのため。よく観察する
と、右で消えて行く画像が、そのまま左に表示されているのに気づくでしょう。
 */
