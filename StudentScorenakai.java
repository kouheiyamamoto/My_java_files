import java.util.HashMap;
public class StudentScore{
    HashMap<String, HashMap<Integer, Integer>> studentscore = new HashMap<>();
    HashMap<Integer,Integer> scores = new HashMap<>();
    Stats stats = new Stats();
    Integer max(){
        return stats.max();
    }
    Integer min(){
        return stats.min();
    }
    Double average(){
        return stats.average();
    }
    void put(String id,Integer num, Integer score){ 
        stats.put(score);
        studentscore.put(id,scores);
        scores = studentscore.get(id);
        scores.put(num,score);
    }
}
