import java.io.File;
import java.util.Date;

public class FileInfo {
    void run(String[] args) {
        for (String arg : args) {
            File thisFile = new File(arg); // argを元に, File型の変数を作成する。
            this.showFileInfo(thisFile);
        }
    }

    void showFileInfo(File target) {
        if (target.exists()) { // ファイルが存在する場合
            this.showInfo(target);
        } else {
            // 指定されたファイル名は存在しない旨を出力する
            System.out.printf("FileInfo: %s: No such file or directory%n", target.getName());
        }
    }

    void showInfo(File target) {
        System.out.printf("%s %d %s %s (%s) %s%n", getMode(target), target.length(), new Date(target.lastModified()),
                target.getPath(), target.getAbsolutePath(), getHidden(target));
    }

    String getHidden(File file) {
        if (file.isHidden()) {
            return "隠しファイル";
        }
        return "";
    }

    String getMode(File file) {
        String rwx = "";
        // 読み込み権限があるか確認する。
        if (file.canRead())
            rwx = rwx + "r";
        else
            rwx = rwx + "-";
        // 書き込み権限があるか確認する。
        if (file.canWrite())
            rwx = rwx + "w";
        rwx = rwx + "-";
        // 実行権限があるか確認する
        if (file.canExecute())
            rwx = rwx + "x";
        else
            rwx = rwx + "-";

        return rwx;
    }

    public static void main(String[] args) {
        FileInfo info = new FileInfo();
        info.run(args);
    }
}