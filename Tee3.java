import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class Tee3{
    public void fileInOut() throws IOException{
 
        //FileInputStreamのオブジェクトを生成する
        FileInputStream fileIn = new FileInputStream("/Users/Shared/java/javaIn.txt");
 
        //FileOutputStreamのオブジェクトを生成する
        FileOutputStream fileOut = new FileOutputStream("/Users/Shared/java/javaOut.txt");
 
        // byte型の配列を宣言
        byte[] buf = new byte[256];
        int len;
 
        // ファイルの終わりまで読み込む
        while((len = fileIn.read(buf)) != -1){
            fileOut.write(buf);    
        }
 
        //ファイルに内容を書き込む
        fileOut.flush();
 
        //ファイルの終了処理
        fileOut.close();
        fileIn.close();
    }
}