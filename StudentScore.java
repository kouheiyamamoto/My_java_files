import java.util.HashMap;
public class StudentScore{
    
    String id;
    HashMap<String,Integer> studentscore = new HashMap<>();
    Stats stustats = new Stats();

    Integer max(){
        return stustats.max();
    }
    Integer min(){
        return stustats.min();
    }
    Double average(){
        return stustats.average();
    }
    void put(String stuid,String qnum,String score){
        Integer scorenum = Integer.valueOf(score);
        id = stuid;
        studentscore.put(qnum,scorenum);
        stustats.put(score,1);
    } 
}