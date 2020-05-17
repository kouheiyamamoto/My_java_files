/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "MousePosition"
 * MousePosition.java 「マウスイベントでカーソルの座標を取得」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac MousePosition.java
 *     >java MousePosition
 * 【キーワード】
 *     インターフェース(interface), implements(実装),  *     MouseListener, MouseMotionListener *     
 * 【試してみよう】
 *     マウスドラッグ中は文字の色を変えて座標を表示する。 *     マウスカーソルが端っこに行っても文字が画面からはみ出さないようにする。 *     MouseMotionAdapterでイベントを処理する。 *      *     
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Toolkit;
import java.lang.String;
import java.lang.System;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MousePosition extends JFrame {

    public MousePosition() {
        add(new DrawPanel());
    }

    public static void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);

        JFrame L00 = new MousePosition();
        L00.setTitle("マウスの座標を表示");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.setSize(320, 240);
        L00.setVisible(true);
    }
}

class DrawPanel extends JPanel implements MouseMotionListener {
    int I00;
    int I01;

    public DrawPanel() {
        setBackground(Color.white);
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics A00) {
        super.paintComponent(A00);
        String L00 = String.format("(%d, %d)", I00, I01);
        A00.drawString(L00, I00, I01);
    }

    public void mouseMoved(MouseEvent A00) {
        I00 = A00.getX();
        I01 = A00.getY();
        repaint();
    }

    public void mouseDragged(MouseEvent A00) {}
}

/* ■ クラスの外でちょっと一言 ■
マウスイベントのリスナーには、MouseListenerとMouseMotionListenerがありま
す。MouseListenerはマウスのボタン操作、コンポーネントへの出入りに対応
し、MouseMotionListenerはカーソルの移動、ドラッグの追跡に対応します。

このプログラムのポイントはrepaint()ですね。マウスカーソルの移動を検知し
たら、クラス変数にその座標を代入し、自分自身の再描画要求を出してます。そ
うすると、後でpaintComponentが呼ばれ、カーソルの位置に文字が描画される仕
組みです。

マウスモーションは短時間に非常にたくさん発生するのイベントですので、
mouseMovedメソッド、mouseDraggedメソッドに重い処理を記述することは避ける
べきでしょう。
 */
