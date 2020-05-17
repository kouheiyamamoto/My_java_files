import java.io.*;

public class CaesarCipher{

    // runMethod
    void run(String[] args) throws IOException {
        if ( args.length == 0){
            System.out.println("何かを入力してください");
        }else{
            for ( Integer i = 0; i < args.length; i++){
                Integer keyNum = Integer.parseInt(args[0]);
                FileInputStream in = new FileInputStream(args[1]);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(args[2]));
                caesar(keyNum, in, out);
            }
        }
    }

    // なんたらMethod
    void caesar (Integer key, FileInputStream in, BufferedOutputStream out ) throws IOException {
        String line;
        // 1行ずつ読み取っていく
        while ((line = out.readLine()) != null) {

            System.out.printf("%s%n", line);
            in.println(line);
        }
        in.close();
    }

    // mainメソッドは省略．
    public static void main(String[] args) throws IOException {
        CaesarCipher Caesar = new CaesarCipher();
        Caesar.run(args);
    }
}