import java.io.File;

public class ListFiles{

    void run(String[] args){
        for (String arg: args){
            File thisFile = new File(arg);
            // argを元に, File型の変数を作成する
            this.listFile(thisFile);
        }
        if(args.length == 0){
            File currentDirectory = new File(".");
            // カレントディレクトリ(".")を表す File型の実体を作成する。
            this.listFile(currentDirectory);
        }
    }

    void listFile(File target){
        if (this.isExist(target)){
            if(target.isDirectory()){
                this.listFilesInDirectory(target);
            }else{
                System.out.printf("%s%n", target.getName());
            }
        }
    }

    void listFilesInDirectory(File dir){
        File[] files = dir.listFiles();
        // for文で files を繰り返す。
        for (File file: files){
            System.out.printf("%s%n", file.getName());
            // 配列の各要素であるファイルの名前を出力する。
        }
    }
    Boolean isExist(File target){
        if(!target.exists()){
            // 指定されたファイル名は存在しない旨を出力する。
            System.out.printf("ListFiles: %s: No such file or directorv%n", target.getName());
        }
        return target.exists();
    }
    public static void main(String[] args){
        ListFiles printer = new ListFiles();
        printer.run(args);
    }
}