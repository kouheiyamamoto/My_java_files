//853563 nakai kota//
import java.util.HashMap;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
public class ScoreAnalyzer3{
    ArrayList<Integer> number;
    HashMap<Integer, Integer> max;
    HashMap<Integer, Integer> min;
    HashMap<Integer, Double> average;
    HashMap<Integer, Integer> scores;
    Stats stats;
    StudentScore studentscore;
    void run(String[] args)throws IOException{
        if(args.length==0){
            System.out.println("引数が入力されていない");
        }
        else if(args.length != 0){
            this.initialize();
            this.analyzer(new File(args[0]));
            print();
        }
    }
    void initialize(){
       
        number = new ArrayList<>();
        max = new HashMap<>();
        min = new HashMap<>();
        average = new HashMap<>();
        stats = new Stats();
        studentscore = new StudentScore();
        scores = new HashMap<>();
    }
    void analyzer(File file)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));//読み込む
        String line;
        while((line = br.readLine()) != null){
            String[] items = line.split(",");//","で分割
            String score = items[4];
            String id = items[3];
            Integer num = Integer.parseInt(items[2]);
            if(score.equals("")){
                stats.count++;
            }
            else if(!items[4].equals("")){
               
                if(number.isEmpty()){
                    number.add(num);
                }
                else if(!number.isEmpty()&&!number.contains(num)){      
                    max.put(num,stats.max());
                    min.put(num,stats.min());
                    average.put(num,stats.average());
                    number.add(num);
                    stats.max = 0;
                    stats.min = Integer.MAX_VALUE;
                    stats.sum = 0;
                    stats.count = 0;
                }
                studentscore.put(id,num,Integer.parseInt(score));
            }
            max.put(number.get(number.size()-1),stats.max());
            min.put(number.get(number.size()-1),stats.min());
            average.put(number.get(number.size()-1),stats.average());
        }
        br.close();
        sort();
    }
    void sort(){
        Object[] maxkey = max.keySet().toArray();
        Arrays.sort(maxkey);
        Object[] minkey = min.keySet().toArray();
        Arrays.sort(minkey);
        Object[] averagekey = average.keySet().toArray();
        Arrays.sort(averagekey);
    }
    void print(){
        for(HashMap.Entry<String,HashMap<Integer,Integer>> entry : studentscore.studentscore.entrySet()){
            System.out.print(entry.getKey());
            System.out.print(",");
            HashMap<Integer, Integer> scores = entry.getValue();
            for(Integer key : scores.keySet()){
                System.out.print(scores.get(key));
                System.out.print(",");
            }
            System.out.println();
        }
        for(Integer maxkey : max.keySet()){
            System.out.print(",");
            System.out.print(max.get(maxkey));
        }
        System.out.println();
        for(Integer minkey : min.keySet()){
            System.out.print(",");
            System.out.print(min.get(minkey));
        }
        System.out.println();
        for(Integer avekey : average.keySet()){
            System.out.print(",");
            System.out.printf("%2.6f",average.get(avekey));
        }
        System.out.println();
    }
    public static void main(String[] args)throws IOException{
        ScoreAnalyzer3 ana = new ScoreAnalyzer3();
        ana.run(args);
    }
}
