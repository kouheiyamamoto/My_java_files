/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "StopWatch"
 * StopWatch.java 「処理にかかった時間を計測する」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac StopWatch.java
 *     >java StopWatch
 * 【キーワード】
 *     書式文字列(format string), 標準入力(standard input), *     java.util.Formatterクラス, 
 * 【試してみよう】
 *     他のサンプルで処理にかかった時間を計測してみる。
 */
import java.io.IOException;
import java.lang.String;
import java.lang.System;

public class StopWatch {

    public static void main(String[] A00) {
        System.out.println("彼女「もう、あなたとは別れたいの」");
        System.out.println("自分「えっ・・・」    <Enterキーを押してください>");
        
        long L00 = System.currentTimeMillis();

        try {
            System.in.read();
        } catch (IOException L01) {
        }

        long L02 = System.currentTimeMillis();
        System.out.printf("僕は、%.3f秒ほど言葉を失った。", (L02 - L00) / 1000.0);
    }
}

/* ■ クラスの外でちょっと一言 ■
プログラムの処理時間を計測する場合には、java.lang.Systemクラスのstaticメ
ソッド、currentTimeMillisが便利。このメソッドはシステムの現在の時間をミ
リ秒（0.001秒）単位返してくれますので、開始地点と終了地点の差分を取得す
れば、処理にかかった時間を計測できます。

printfの「%.3f」は「小数点第3位まで表示」という意味。たとえ5秒ちょうどで
も「5.000」と表示します。

話は突然変わりますが、自分が中学生の頃よく聞いたアルバムに、大瀧詠一の
『A LONG VACATION』があります。このプログラムを組んでると、そのアルバム
に収められた『恋するカレン』を思い出しました。このサンプルと似たシチュ
エーションの一節があるんですよね。すると、懐かしさがこみ上げてきて、その
頃の自分も思い出したりなんかして、もう大瀧詠一を聞かずにはいられない状態
に。早速CD屋さんに直行して購入した次第です。

最近、キリン生茶のCMに『君は天然色』が、SONYハンディカムのCMに『スピー
チ・バルーン』が使われているのを見るたびに、「自分と同世代が作ったんだろ
うな」と思うことしばしばです。
 */
