import java.util.Date;
import java.util.Objects;
public class GivenClassName {
    void run() {
        // 次の処理を追加する．
        Date date1 = new Date(116, 8, 29, 9, 0); // メモリにアクセスするポインタ
        Date date2 = date1;
        // 以下のプログラムを追加する
        Date date3 = new Date(116, 8, 29, 9, 0); // newで新しいメモリを作る

        System.out.println(date1 == date2);
        System.out.println(date1 == date3);
        System.out.println(date1 == date3);
        System.out.println(Objects.equals(date1, date2));
        System.out.println(Objects.equals(date1, date3));
        System.out.println(Objects.equals(date2, date3));
    }

    public static void main(String[] args) {
        GivenClassName application = new GivenClassName();
        application.run(); // メソッドに移動
    }
}