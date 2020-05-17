// 指定した行まで表示するプログラム
import java.io.*;

public class Head{
    void run(String[] args) throws IOException{
            Integer num = Integer.parseInt(args[0]);
            File file1 = new File(args[1]);
            grep(num,file1);
    }
    void grep(Integer n, File file) throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        Integer count = 0;
        while((line = in.readLine()) != null){ 
            count++;
            if ( count <= n){ // もしも指定された行数より
                System.out.printf("%s%n",line);
            }
        }
        in.close();
    }
    public static void main(String[] args) throws IOException{
        Head cat = new Head();
        cat.run(args);
    }
}