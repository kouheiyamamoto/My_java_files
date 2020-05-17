// 山本昂平　854030 第3講　練習問題2 

public class StudentIdValidator {
    void run(String[] args) {
        int[] num = new int[5];
        for ( Integer i = 0; i < args.length; i++) {
            num[i] = validate(args[i]);
            validateId(num[i]);
        }
    }

    // 与えらえれた数が６桁かどうかを確認するメソッド
    Integer validate(String id) {
        if (id.length() != 6) {
            System.out.printf("%s: not student Id\n", id);
            return 0; // 一旦処理を終了する
        }
        Integer num = Integer.valueOf(id); // String型の配列をInteger型に変換する
        return num;
    }

    // ６桁の整数を１０で割り切れるか確かめるメソッド
    void validateId(Integer a) { 
        int sum = 0;
        // 学籍番号の６桁をすべて足すループ
        for (Integer i = 1; i < 10000000; i *= 10) {
            sum += (a / i) % 10;
        }
        if (sum % 10 == 0) {
            System.out.printf("%s: valid\n", a);
        } else {
            System.out.printf("%s: invalid\n", a);
        }
    }

    public static void main(String[] args) {
        StudentIdValidator printer = new StudentIdValidator();
        printer.run(args);
    }
}