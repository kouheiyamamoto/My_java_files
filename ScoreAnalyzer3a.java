/*
853329 小竹　悠太
ScoreAnalyzer3.java
*/
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreAnalyzer3{

    void run(String[] args)throws IOException{
        HashMap<String, Integer> scoremap = new HashMap<>();
        HashMap<String,HashMap<String,Integer>> scorepercent = new HashMap<>();
        ArrayList<String> scorelist= new ArrayList<>();
        ArrayList<String> questionlist= new ArrayList<>();
        ArrayList<StudentScore> stuscorelist = new ArrayList<>();
        File file1 = new File(args[0]);
        scorepercent = this.filescan(file1,scorepercent);
        scorelist = this.Scorelist(scorepercent,scoremap);
        stuscorelist = this.GetStuScore(file1);
        questionlist = this.Questionlist(scorepercent);

        this.stuscoreprint(stuscorelist,questionlist);

        this.print(scorepercent,scoremap,scorelist);
    }

    HashMap<String,HashMap<String,Integer>> filescan(File file,HashMap<String,HashMap<String,Integer>> scorepercent)throws IOException{
        HashMap<String, Integer> scoremap = new HashMap<>();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while((line = in.readLine()) !=null){
            String[] items = line.split(",");
            if(scorepercent.get(items[2]) ==null){
                scoremap = new HashMap<>();
                scoremap.put(items[4],1);
                scorepercent.put(items[2], scoremap);
            }else{
                scoremap=scorepercent.get(items[2]);
                scorepercent.put(items[2],this.scoremapset(items[4],scoremap));
            }
        }
        in.close();
        return scorepercent;
    }

    ArrayList<StudentScore> GetStuScore(File file)throws IOException{
        ArrayList<StudentScore> stuscorelist = new ArrayList<>();
        StudentScore stuscore = new StudentScore();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while((line = in.readLine()) !=null){
            String[] items = line.split(",");
            stuscore = this.StuScoreSet(stuscorelist,items[3],items[2],items[4]);
            stuscorelist.add(stuscore);
        }
        in.close();
        return stuscorelist;
    }

    StudentScore StuScoreSet(ArrayList<StudentScore> stuscorelist,String stuid,String qnum,String score){
        StudentScore stuscore = new StudentScore();
        if(stuscorelist.size() == 0){
            stuscore.put(stuid,qnum,score);
        }else{
            stuscore = this.StuScoreSerch(stuscorelist,stuid,qnum,score);
        }
        return stuscore;
    }

    StudentScore StuScoreSerch(ArrayList<StudentScore> stuscorelist,String stuid,String qnum,String score){
        StudentScore stuscore = new StudentScore();
        Integer check = 0;
        for(Integer i=0;i<stuscorelist.size();i++){
            if(Objects.equals(stuscorelist.get(i).id,stuid)){
                stuscore = stuscorelist.get(i);
                stuscore = this.putstuscore(stuscorelist,stuscore,stuid,qnum,score,i);
                    check = 1;
                    break;
            }
        }
        if(check == 0){
            stuscore= new StudentScore();
            if(!score.isEmpty()){
            stuscore.put(stuid,qnum,score);
            }
        }
        return stuscore;
    }

    StudentScore putstuscore(ArrayList<StudentScore> stuscorelist,StudentScore stuscore,String stuid,String qnum,String score,Integer i){
        if(Objects.equals(stuscorelist.get(i).id,stuid)){
            stuscore = stuscorelist.get(i);
            if(!score.isEmpty()){
                stuscore.put(stuid,qnum,score);
            }
        }
        return stuscore;
    }

    HashMap<String,Integer> scoremapset(String score ,HashMap<String,Integer> scoremap){
        Integer num=0;
        if(!score.isEmpty()){
            if(scoremap.get(score) == null){
                scoremap.put(score,0);
            }
            num = scoremap.get(score);
            num+=1;
            scoremap.put(score,num);
        }
        return scoremap;
    }

    Integer ExamineeCount(HashMap<String, Integer> scoremap){
        Integer examineeCount=0;
        for(Map.Entry<String,Integer> entry: scoremap.entrySet()){
            if(entry.getValue() != null){
                examineeCount+=entry.getValue();
            }
        }
        return examineeCount;
    }

    ArrayList<String> Scorelist(HashMap<String,HashMap<String,Integer>> scorepercent,HashMap<String,Integer> scoremap){
        ArrayList<String> scorelist = new ArrayList<String>();
        String score;
        for(Map.Entry<String ,HashMap<String,Integer>> entry1: scorepercent.entrySet()){
            scoremap=entry1.getValue();
            for(Map.Entry<String,Integer> entry2: scoremap.entrySet()){
                score = entry2.getKey();
                scorelist = this.Listadd(scorelist,score);
            }
        }
        Collections.sort(scorelist);
        scorelist = this.listsort(scorelist);
        return scorelist;
    }


    ArrayList<String> Questionlist(HashMap<String,HashMap<String,Integer>> scorepercent){
        ArrayList<String> questionlist = new ArrayList<String>();
        String qnum;
        for(Map.Entry<String ,HashMap<String,Integer>> entry: scorepercent.entrySet()){
            qnum = entry.getKey();
            questionlist.add(qnum);
        }
        Collections.sort(questionlist);
        return questionlist;
    }

    ArrayList<String> listsort(ArrayList<String> scorelist){
        ArrayList<Integer> newlist = new ArrayList<>();
        Integer count=0;
        Integer num = 0;
        String score;
        if(scorelist.get(0).isEmpty()){
            count =1;
        }
        for(Integer i = 0;i<scorelist.size()-count;i++){
            num = Integer.valueOf(scorelist.get(count+i));
            newlist.add(num);
        }
        Collections.sort(newlist);
        for(Integer i=0;i<newlist.size();i++){
            score=String.valueOf(newlist.get(i));
            scorelist.set(i+count,score);
        }
        return scorelist;
    }

    ArrayList<String> Listadd(ArrayList<String> scorelist, String score){
        Integer count=0;
        if(scorelist.size()==0){
            scorelist.add(score);
        }
        count = scorelist.size();
        for(Integer i=0;i<scorelist.size();i++){
            if(Objects.equals(scorelist.get(i),score)){ 
                count--;
            }
        }
        if(count ==scorelist.size()){
            scorelist.add(score);
        }
        return scorelist;
    }

    Stats StatsSet(String score,HashMap<String,Integer> scoremap,Stats scorestats){
        Integer personnumber=0;
        if(scoremap.get(score)!=null){
            personnumber = scoremap.get(score);
            if(!score.isEmpty()){
            scorestats.put(score,personnumber);
            }
        } 
        return scorestats;
    }


    void print(HashMap<String,HashMap<String,Integer>> scorepercent,HashMap<String,Integer> scoremap,ArrayList<String> scorelist){
        ArrayList<Stats> scorestatslist = new ArrayList<>();
        Stats scorestats = new Stats();
        String score;
        for(Map.Entry<String ,HashMap<String,Integer>> entry1: scorepercent.entrySet()){
            scorestats = new Stats();
            scoremap=entry1.getValue();
            for(Integer i=0;i<scorelist.size();i++){
                score = scorelist.get(i);
                scorestats = this.StatsSet(score,scoremap,scorestats);
            }
            scorestatslist.add(scorestats);
        }
        this.scorestatsprint(scorestatslist);
    }
    
    void scorestatsprint(ArrayList<Stats> scorestatslist){
        Stats scorestats = new Stats();
        Integer max=0;
        Integer min=0;
        Double average=0.0;
        for(Integer i=0;i<scorestatslist.size();i++){
            scorestats = scorestatslist.get(i);
            max=scorestats.max();
            System.out.printf(",%d",max);
        }
        System.out.println();
        for(Integer i=0;i<scorestatslist.size();i++){
            scorestats = scorestatslist.get(i);
            min=scorestats.min();
            System.out.printf(",%d",min);
        }
        System.out.println();

        for(Integer i=0;i<scorestatslist.size();i++){
            scorestats = scorestatslist.get(i);
            average=scorestats.average();
            System.out.printf(",%5.6f",average);
        }
        System.out.println();
    }

    void stuscoreprint(ArrayList<StudentScore> stuscorelist,ArrayList<String> questionlist){
        StudentScore stuscore = new StudentScore();
        HashMap<String,Integer> stuscoremap = new HashMap<>();
        for(Integer i=0;i<stuscorelist.size();i++){
            stuscore = stuscorelist.get(i);
            stuscoremap = stuscore.studentscore;
            System.out.printf("%s",stuscore.id);
            for(Integer j=0;j<questionlist.size();j++){
                this.PersonScorePrint(stuscoremap,questionlist,j);
            }
            System.out.printf(",%d,%d,%f",stuscore.max(),stuscore.min(),stuscore.average());
            System.out.println();
        }
    }

    void PersonScorePrint(HashMap<String,Integer> stuscoremap,ArrayList<String> questionlist,Integer num){
        String qnum;
        qnum =questionlist.get(num);
        if(stuscoremap.get(qnum)==null){
            System.out.print(",");
        }else{
            System.out.printf(",%d",stuscoremap.get(qnum));
        }
    }

    public static void main(String[] args)throws IOException{
        ScoreAnalyzer3 app = new ScoreAnalyzer3();
        app.run(args);
    }
}