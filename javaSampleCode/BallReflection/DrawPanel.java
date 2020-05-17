/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "BallReflection"
 * DrawPanel.java 「ウィンドウの内側を反射するボール」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java BallReflection
 * 【キーワード】
 *     イベント駆動(event-driven)プログラム, コンポーネントの再描画(repaint),  *     コールバック(callback)メソッド, *     イベントディスパッチスレッド(event dispatch thread), 
 * 【試してみよう】
 *     ボールの数を増やして配列で管理する。
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

public class DrawPanel extends JPanel implements ActionListener {
    static final int C00 = 300;
    static final int C01 = 200;

    Ball I00 = new Ball(50);
    
    public DrawPanel() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(C00, C01));
    }

    public void actionPerformed(ActionEvent A00) {
        I00.M00();
        repaint();
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);

        Graphics2D L00 = (Graphics2D)A00;
        L00.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);
        I00.M01(L00);
    }
}

/* ■ クラスの外でちょっと一言 ■
このクラスのメソッドは、全て、初めからちゃんとした名前が付けてあります。
これは（コンストラクターを除いて）、プログラマーが直接呼び出すのではな
く、Swing側に呼び出してもらうコールバックメソッドだからです

処理の流れを理解するには、どのタイミングでメソッドが呼び出されるかを知る
のがポイントで、特に、TimerとactionPerformed()の関係、及び、repaint()と
paintComponent()の関係は重要です。

BallReflectionクラスで生成したTimerにより、定期的にActionイベントが発生
し、そのつど、actionPerformedが呼ばれます。ここに描画メソッドを書けば、
アニメーションが実現されるわけですが、実際は、ボールの座標を更新するのみ
で、描画は行わず、repaint()でパネルの「再描画要求」を出すにとどまってま
す。この「再描画要求」が出された後、paintComponent()が呼び出され、実際に
画面にボールが描画されるという仕組みになってます。

このように、GUIプログラミングでは、直接メソッドを呼び出すのではなく、イ
ベントという「仕組み」を利用してメソッドを呼び出します。これをプログラ
マーが直接やった場合には、必要なときに画面の描画がなされずに表示が崩れた
り、ウィンドウを操作しようにも反応しないなどの問題が起こる可能性がありま
す。コールバックメソッドでは、もたもたせずに、素早くシステムに処理を返す
のが、応答の素早いGUI構築のカギになります。
 */
