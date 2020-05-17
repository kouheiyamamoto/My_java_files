import java.sql.Date;

public class SeirekiToWarekiConverter_854030 {

    void run(String[] args) {

        // もしも何も入力されなかったらデフォルトで1000
        if (args.length == 0) {
            // year は 1900年からの経過年数．
            // month は 0 から始まる．
            Date data1 = new Date(119);

            System.out.println(data1);
        }else{
            Date date1 = new Date(getYear());
            if ( date1 < -32 ) {
                System.out.printlm(date1,"明治より前であるため判定出来ません");
            }
            if( date1 > )

        }
    }

    // }else{

    // }

    // mainメソッド
    public static void main(String[] args) {
        SeirekiToWarekiConverter_854030 printer = new SeirekiToWarekiConverter_854030();
        printer.run(args);
    }
}
