public class Stats{
    
    Integer max=0;
    Integer min=0;
    Integer sum=0;
    Integer count=0;
    
    Integer max(){
        return max;
    }

    Integer min(){
        return min;
    }

    Double average(){
        Double average = (double)sum/(double)count;
        return average;

    }
    void put(String scorenum,Integer datanum){
        
            Integer score = Integer.valueOf(scorenum);
            if(count == 0){
                max=score;
                min=score;
            }
            if(score>max){
                max = score;
            }
            if(score<min){
                min=score;
            }
            sum +=(score * datanum);
            count =count+datanum;
        
    }
}