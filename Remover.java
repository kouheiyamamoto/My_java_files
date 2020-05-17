// 山本昂平 854030 第67 練習問題4
import java.io.File;

public class Remover{

    void run(String[] args){
        for (String arg : args){
            File dir = new File(arg);
            removedirectory(dir);
        }
    }

    void removedirectory(File dir){
        if(dir.isDirectory()){
                removedirectory(dir.isFile());
        }else{
            dir.delete();
        }
    }

    public static void main (String[] args){
        Remover printer = new Remover();
        printer.run(args);
    }
}