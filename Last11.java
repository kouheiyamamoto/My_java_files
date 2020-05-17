import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
public class Last11{

    void run(String[] args)throws IOException {

        Integer selectNum = Integer.parseInt(args[0]); // 引数の1つめの数字
        BufferedReader in = new BufferedReader(new FileReader(args[1]) );
        //System.out.printf(%d: %f (%d/%d), );
    }
    public static void main (String[] args) throws IOException{
        Last11 step1 = new Last11();
        step1.run(args);
    }
}