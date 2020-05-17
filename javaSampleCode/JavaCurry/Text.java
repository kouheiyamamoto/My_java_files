/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "JavaCurry"
 * Text.java 「カレーのパッケージをオブジェクト指向で表現」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java JavaCurry
 * 【キーワード】
 *     論理(logical)フォントと物理(physical)フォント
 * 【試してみよう】
 *     JavaCurry.java参照
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.lang.String;

public class Text implements Parts {
    String I00;
    int I01;
    int I02;
    Color I03;
    int I04;

    Text(String A00, int A01, int A02, Color A03, int A04) {
        this.I00 = A00;
        this.I01 = A01;
        this.I02 = A02;
        this.I03 = A03;
        this.I04 = A04;
    }

    public void M00(Graphics A00) {
        A00.setColor(I03);
        A00.setFont(new Font("SansSerif", Font.BOLD, I04));
        A00.drawString(I00, I01, I02);
    }
}

/* ■ クラスの外でちょっと一言 ■
福岡ローカルの話になって申し訳ないんですが、天神西通りのケンタッキーの上
に、「ツナパハ」というカレー屋さんがあります。そこの「ドライカリー」は
（少なくとも自分にとっては）かなり辛いんですが、とっても美味しいです。デ
ジハリ福岡校が大名にあった頃、ランチでよく食べましたね。

その店に、辛さの指定で「デビルレッド」という項目があります。いかにも辛そ
うな名前で、実際にすごく辛いです。あと、昔、親不孝通りにあった「タージ」
という店には「青酸カリー」というメニューがありました。死ぬほど辛いんで
しょうね。で、これも今はなくなった店ですが、天神ビル地下の「サムソン」に
は、「Ｗ死に辛」という辛さ指定がありました。もちろん、どれも食べたことは
ありません。
 */
