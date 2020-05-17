import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Copy2 {
    void run(String[] args){
        if(args.length < 2){
            System.out.println("select files");
        }else{
            File to = new File(args[args.length - 1]); // 最後のファイルがディレクトリの内容
            if(to.isFile()) {
                if(args.length > 2){
                     System.out.println("cp: 複数ファイルを一つのファイルにコピーできません");
                break;
                }
            }
            else if(to.isDirectory()){
                for(Integer i = 0; i < args.length; i++){
                    File from = new File(arg[i]);
                    File toFile = new File(to, from.getName());
                    copy(from, toFile);
                }
            }
    }

    void copy(File in, File out){
        File out = 
    }

    public static void main(String[] args) {
        Copy2 copy = new Copy2();
        copy.run(args);
    }
}
