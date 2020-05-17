/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "MultiScroll"
 * Background.java 「透過GIFを利用して、背景を多重スクロール」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java MultiScroll
 * 【キーワード】
 *     アクセサメソッド(accessor method), 
 * 【試してみよう】
 *     MultiScroll.java参照。
 */
import java.awt.Image;
import java.lang.String;
import javax.swing.ImageIcon;

public class Background {
    private Image I00;  // 画像
    private int I01;    // 幅
    private int I02;    // 表示位置
    private int I03;    // 移動速度

    public Background(String A00, int A01) {
        I00 = new ImageIcon(A00).getImage();
        I01 = I00.getWidth(null);
        I02 = 0;
        this.I03 = A01;
    }
    
    public Image M00() {
        return I00;
    }
    
    public int M01() {
        return I01;
    }

    public int M02() {
        return I02;
    }
   
    public void M03() {
        if (I00 != null) {
            I02 = (I02 + I03) % I01;
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
背景画像を管理するクラスです。フィールド変数（プロパティ）をよく見てくだ
さい。これが一枚の背景に必要な情報です。

コンストラクターで行っているのが、そのフィールドの初期化。引数で渡された
情報や固定の数値を使って、フィールド変数に初期値を代入しています。

単純にフィールド変数の値を返すだけのメソッドがいくつかありますが、これら
には、get～()という名前をつけるのが一般的。たとえば、private String name
とくれば、public String getName()てな具合ですね。今回のサンプルにはあり
ませんが、フィールドに値を設定するメソッドなら、set～()となります。

ちなみに、ここでメソッド名を変えたら、呼び出し元のDrawPanel.javaも同じよ
うに変更してくださいね。
 */
