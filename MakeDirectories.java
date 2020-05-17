import java.io.File;

public class MakeDirectories {

    void run(String[] args) {
        for (String arg : args) {
            File dir = new File(arg); // 現在のディレクトリを作成する。
            makeDirectory(dir);
        }
    }

    void makeDirectory(File dir) {
        if (!dir.mkdir()) {
            System.out.printf("%s: could not make directory.%n", dir.getPath());
        }
    }

    public static void main(String[] args) {
        MakeDirectories printer = new MakeDirectories();
        printer.run(args);
    }
}
