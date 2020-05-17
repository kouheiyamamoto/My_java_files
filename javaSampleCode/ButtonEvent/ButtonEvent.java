/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "ButtonEvent"
 * ButtonEvent.java 「ボタンイベントでJTextAreaに文字を追加」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac ButtonEvent.java
 *     >java ButtonEvent
 * 【キーワード】
 *     イベント駆動(event driven)プログラム, Delegation(代理人)イベントモデル, *     インターフェース(interface), implements(実装), キーワードthis
 * 【試してみよう】
 *     actionPerformedをわざと別の名前に変え、どんなコンパイルエラーが出るか確かめる。 *     JButtonのgetActionCommandメソッドを使って、二つのボタンを区別してみる。
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;
import java.lang.System;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ButtonEvent extends JFrame implements ActionListener {
    JTextArea I00;
    JButton I01;
    JButton I02;
    int I03 = 0;

    public ButtonEvent() {
        I00 = new JTextArea();
        JScrollPane L00 = new JScrollPane(I00, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(L00, BorderLayout.CENTER);

        JPanel L01 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        I01 = new JButton("ノック");
        I02 = new JButton("クリア");
        L01.add(I01);
        L01.add(I02);
        add(L01, BorderLayout.SOUTH);

        I01.addActionListener(this);
        I02.addActionListener(this);
    }

    static public void main(String[] A00) {
        Toolkit.getDefaultToolkit().setDynamicLayout(true);

        JFrame L00 = new ButtonEvent();
        L00.setTitle("ボタンを押してちょんまげ");
        L00.setDefaultCloseOperation(EXIT_ON_CLOSE);
        L00.setBackground(Color.white);
        L00.setSize(320, 240);
        L00.setVisible(true);
    }

    public void actionPerformed(ActionEvent A00) {
        if (I01 == A00.getSource()) {
            String L00 = String.format("愛のノック%d本目だ～！%n", ++I03);
            I00.append(L00);
            I00.setCaretPosition(I00.getText().length());
        } else if (I02 == A00.getSource()){
            I00.setText("たるんどーる！　最初っからだ！！\n");
            I03 = 0;
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
Javaのイベント処理にはいくつかの手法がありますが、まずはこの、～Listener
をimplementsするやり方から覚えるといいでしょう。Javaのイベントモデルを理
解するには、以下の３つのポイントを押さえることが重要です。

その１．ボタンが押された場合は、java.awt.event.ActionEventが発生する
その２．ActionEventはあらかじめ「登録された人」に通知される
その３．ActionEventが通知されると、actionPerformedメソッドが呼ばれる

このうちプログラマーが記述するのは、その２とその３で、サンプルでも
addActionListener(this)で、それぞれのボタンのイベントの通知先に、自分自
身への参照=thisを登録しています。これが、何でも登録できるってわけじゃな
くて、インターフェースActionListenerを実装(implements)したものだけが登録
できる仕組みになってます。

actionPerformedメソッドには、ボタンが押されたときの処理を記述します。こ
のサンプルでは、どっちのボタンが押されても同じメソッドが呼ばれるので、ど
ちらのボタンが発生させたイベントかを判別する処理を入れてます。「試してみ
よう」にも書いてますが、getActionCommandで、ボタンのラベルの文字列を取得
して判定する方法もありますので、調べてみてください。
 */
