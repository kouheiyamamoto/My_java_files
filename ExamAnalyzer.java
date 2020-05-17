
// 山本昂平 854030 第4講 練習問題4

import java.util.Random;

public class ExamAnalyzer {

    void run() {
        
    }

    ExamScore createRandomScore(String name) {
        Random random = new Random();
        Integer math = random.nextInt(101);
        Integer physics = random.nextInt(101);
        Integer english = random.nextInt(101);
        return this.createExamScore(math, physics, english, name);
    }

    ExamScore createExamScore(Integer m, Integer p, Integer e, Integer n){
        ExamScore examScore = new ExamScore();
        
    }

    public static void main(String[] args) {
        Factorizer printer = new Factorizer();
        printer.run(args);
    }
}