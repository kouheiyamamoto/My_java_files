import java.io.File;

public class MakeDirectory {

    void run(String[] args) {
        for (String arg : args){
            File dir = new File(arg); // 現在のディレクトリを作成する。
            makeDirectory(dir);
        }
    }

    void makeDirectory(File dir) {
        if (!dir.mkdir()){
            System.out.printf("%s: could not make directory.%n", dir.getPath());
        }
    }

    public static void main(String[] args) {
        MakeDirectory printer = new MakeDirectory();
        printer.run(args);
    }

}
