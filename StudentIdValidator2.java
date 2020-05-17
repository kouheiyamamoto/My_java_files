//import sun.security.util.Length;

/* 山本昂平　854030 練習問題2　*/

public class StudentIdValidator2 {
    void run(String[] args) {
        validateId(validate(args[0]));
    }

    Integer validate(String id) {
        
        if (id.length() != 6) {
            System.out.printf("%s: not student Id\n", id);
            return 0; // 一旦処理を終了する
        }
        Integer num = Integer.valueOf(id); // String型の配列をInteger型に変換する
        return num; 
    }

    void validateId(Integer a) { // 数字をaで受け取りましたという意味
        int sum = 0;

        for (Integer i = 1; i < 10000000; i *= 10) {
            sum += (a / i) % 10;
            //System.out.println(sum);
        }
        //System.out.println(sum);
        if (sum % 10 == 0) {
            System.out.printf("%s: valid\n", a);
        } else {
            System.out.printf("%s: invalid\n", a);
        }
    }

    // mainメソッド
    public static void main(String[] args) {
        StudentIdValidator2 printer = new StudentIdValidator2();
        printer.run(args);
    }
}