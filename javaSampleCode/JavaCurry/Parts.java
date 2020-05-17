/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "JavaCurry"
 * Parts.java 「カレーのパッケージをオブジェクト指向で表現」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac *.java
 *     >java JavaCurry
 * 【キーワード】
 *     インターフェース(interface)
 * 【試してみよう】
 *     JavaCurry.java参照。
 */
import java.awt.Graphics;

public interface Parts {
    public void M00(Graphics A00);
}

/* ■ クラスの外でちょっと一言 ■
インターフェースとは、クラスの「振る舞い方」のみを定義するものです。この
Partsインターフェースは、「Graphicsオブジェクトを受け取って、描画する」
という動作を定義していますので、M00には「いかにも描画しそう」な名前をつ
けてあげてください。
具体的にどのように描画するかは、このインターフェースを実装している、Box,
Circle, Textの各クラスでそれぞれ記述してます。

JavaCurryでは、このPartsインターフェースが、ピリッと効いたスパイスになっ
てますので、DrawPanel.javaにて、このインターフェースがどのように利用され
てるのか、その風味をじっくりご賞味ください。
 */
