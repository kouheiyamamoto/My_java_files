import java.util.HashMap;

// * 1人の学生の成績をまとめる型
public class StudentScore{
    HashMap<String, Integer> studentScoreMap = new HashMap<>();
    Stats stats = new Stats(); // Stats型をオブジェクトとして使う

    Integer max (){
        return stats.calculateMax();
    }

    Integer min(){
        return stats.calculateMin();
    }

    Double average(){
        return stats.calculateAverage();
    }

    void put(){

    }

}