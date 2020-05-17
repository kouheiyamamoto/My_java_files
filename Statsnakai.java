public class Stats{
    Integer max = 0;
    Integer min = Integer.MAX_VALUE;
    Integer sum = 0;
    Integer count = 0;
   
    void put(Integer score){
        if(max<score) max = score;
        if(min>score) min = score;
        sum += score;
        count++;
    }
    Integer max(){
        return max;
    }
    Integer min(){
        return min;
    }
    Double average(){
        return 1.0 * sum / count;
    }
}
