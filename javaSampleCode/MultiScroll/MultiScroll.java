/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "MultiScroll"
 * MultiScroll.java 「透過GIFを利用して、背景を多重スクロール」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java MultiScroll
 * 【キーワード】
 *     フレームレート(frame rate)
 * 【試してみよう】
 *     GIF画像の透明処理を確認する。 *     各背景のスクロールスピードを変えてみる。 *     車を前に進めたり、小刻みに上下に動かしたりする。
 */
import java.lang.String;
import javax.swing.JFrame;
import javax.swing.Timer;

public class MultiScroll extends JFrame {

    final static int C00 = 33;    // １秒あたりの描画回数

    public MultiScroll() {
        DrawPanel L00 = new DrawPanel();
        setContentPane(L00);

        new Timer(1000 / C00, L00).start();
    }

    public static void main(String[] A00) {
        MultiScroll L00 = new MultiScroll();
        L00.setTitle("背景の多重スクロール");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setResizable(false);
        L00.pack();
        L00.setVisible(true);
    }
}

/* ■ クラスの外でちょっと一言 ■
背景を多重スクロールさせるサンプルです。MultiScroll、DrawPanel、
Backgroundの3つのクラスから構成されています。

このMultiScrollクラスはmainメソッドを持ったエントリーで、フレーム、描画
パネル、タイマーの生成を行ってます。DrawPanelクラスは描画用のパネル。タ
イマーイベントはこのパネルに通知されます。Backgroundクラスは、1枚の背景
を管理するクラス。背景の枚数分、このクラスのインスタンスが生成されます。

ちなみに、車はFiat500（チンクチェント）。『カリオストロの城』でルパン三
世が乗っていたやつですね。
 */
