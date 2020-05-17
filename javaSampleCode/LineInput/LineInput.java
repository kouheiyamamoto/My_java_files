/**
 * 愛のJava256本ノック for Java 5.0
 * Javaサンプルソース ver0.2C "LineInput"
 * LineInput.java 「コマンドラインから文字を入力」
 *
 * 2005/09/23 制作：安永ノリカズ
 *
 * 【コンパイル＆実行方法】
 *     >javac LineInput.java
 *     >java LineInput
 * 【キーワード】
 *     標準入力(standard input), 標準出力(standard output),  *     入出力(io:input/output), ストリーム(stream:流れ),  *     java.io.InputStreamReader
 * 【試してみよう】
 *     連続して入力を受け付ける。 *     入力された内容をファイルに書き出す。
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.String;
import java.lang.System;

public class LineInput {
    public static void main(String[] A00) {
        BufferedReader L00 = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            System.out.print("文字列を入力してください：");
            String L01 = L00.readLine();
            System.out.printf("入力 = %s%n長さ = %d文字%n", L01, L01.length());
        } catch(IOException L02) {
            System.out.println("入力エラー");
        }
    }
}

/* ■ クラスの外でちょっと一言 ■
java.ioパッケージには、入出力のためのクラスがたくさんあります。最初は、
どれがどんな機能なのか、うまく整理できないことでしょう。実は、このパッ
ケージを読み解くにはコツがあって、最初に4つの基礎的なクラスを押さえる必
要があります。

Javaでは読み書きするデータの流れをストリームといいます。そのストリームに
は、データを数値として処理する「バイトストリーム」と、文字として処理する
「文字ストリーム」の2種類があります。その入力と出力が基礎的な4つのクラス
で表されていて、バイト入力="InputStream"、バイト出力="OutputStream"、文
字入力="Reader"、文字出力="Writer"となっています。

この4つのクラスが理解できれば、あとは簡単。多くのストリームクラスは、こ
れらを継承していますので、クラス名を見ただけで、大まかな機能が推測できま
す。「DataInputStream」は「データをバイトで読み込む」、「FileWriter」は
「ファイルに文字を書き出す」と解釈すればいいです。

また、ストリームクラスの多くは、コンストラクターで他のクラスを受け取っ
て、連結して使用することが可能です。

今回の例でいえば、System.inで標準入力に指定されているのはInputStream。こ
のままでは、バイトデータしか取得できませんので、「バイトデータ→文字」の
変換を行うInputStreamReaderと、「文字→1行の文字列」の変換を行う
BufferedReaderをつなぎ合わせて、標準入力から1行の文字列を読み込む機能を
実現しています。

「ファイルにバイトを書き出す」とか、「Webサーバーから1行読み込む」とか、
場合によっていろいろな入出力の形式があると思いますが、すべてこれらのクラ
スをつなぎ合わせて対応することになります。
 */
