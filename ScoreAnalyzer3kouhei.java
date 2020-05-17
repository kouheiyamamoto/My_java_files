// 学籍番号 854030 
// 山本昂平

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

// 基本はコメントアウト！勝手に消したりしない！
public class ScoreAnalyzer3kouhei {
    // StudentScore studentScore = new StudentScore();
    ArrayList<String> studentIDList = new ArrayList<>(); // ソートする前のstudentIDを呼び込んでいるやつ
    ArrayList<String> nonRepetionList = new ArrayList<>(); // ソートする前のstudentIDを呼び込んでいるやつ
    ArrayList<String> subjectNumList = new ArrayList<>(); // ソートする前の問題番号を代入するためのリスト
    ArrayList<String> sortSubjectNumList = new ArrayList<>(); //
    ArrayList<String> nonSortSubjectNumList = new ArrayList<>();
    ArrayList<StudentScore> studentScoreList = new ArrayList<>();
    ArrayList<String> scores = new ArrayList<>();
    HashMap<String, HashMap<String, String>> table = new HashMap<>();
    HashMap<String, String> scoreMap = new HashMap<>();

    void run(String[] args) throws IOException {
        BufferedReader loadFile = new BufferedReader(new FileReader(args[0]));
        analyze3(loadFile);
    }

    void analyze3(BufferedReader file) throws IOException {
        String line;
        // ファイルを1行ずつ読み込む
        while ((line = file.readLine()) != null) {
            String[] items = line.split(",");
            // table = this.putTable(items[2], items[4]);
            // scores = this.putScores(table, scoreMap);
            // studentScoreList = this.putStudentScoreList(items[3], items[2], items[4]);
            studentIDList = this.putStudentID(items[3]); // これで重複しないように学生のIDをまとめることができた。
            // subjectNumList = this.putSubjectNumList(items[2]);
            subjectNumList = this.putSubjectNum(items[2]); // これで問題番号たちをリストにまとめることができた。
            // table = this.putTable(items[3], items[2], items[4]);
            //scoreMap = this.putScoreMap2(items[2], items[4]);
            scoreMap = this.putScoreMap(studentIDList, subjectNumList, items[3], items[2], items[4]);
            // //this.putSubjectNumScore(line);
            // //this.put_id_score_others_table(line);
        }

        //this.printStudentID(studentIDList);
        //this.printSubjectNum(subjectNumList);
        //this.printscoreMap(scoreMap);
        System.out.print(scoreMap);
        // this.printTable(table);
        this.printAll(studentIDList, scoreMap);
        file.close();
    }

    // private HashMap<String, String> putScoreMap(ArrayList<String> studentIDList2, ArrayList<String> subjectNumList2,
    //         String string, String string2, String string3) {
    //     return null;
    // }

    // 学生証番号を代入していくリストを作る
    ArrayList<String> putStudentID(String studentID) {
        if (!studentIDList.contains(studentID))
            nonRepetionList.add(studentID);
        return nonRepetionList;
    }

    // 問題番号を代入していくリストを作る
    ArrayList<String> putSubjectNum(String subNum) {
        // if (!subjectNumList.contains(subNum));
        subjectNumList.add(subNum);
        sortSubjectNumList = new ArrayList<String>(new HashSet<>(subjectNumList));
        // Collections.sort(sortSubjectNumList);
        return sortSubjectNumList;
    }

    HashMap<String, String> putScoreMap(ArrayList<String> idList, ArrayList<String> subNumList, String stuId, String subNum, String score){
        for (Integer i = 0; i < idList.size(); i++) {
            for (Integer j = 0; j < subNumList.size(); j++) {
                if (idList.get(i).equals(stuId) && subNumList.get(j).equals(subNum)) {
                    System.out.println(idList.get(i));
                    scoreMap.put(subNum, score);
                }
            }
        }
        return scoreMap;
    }

    HashMap<String, String> putScoreMap2(String subNum, String scoreNum){
        if (table.get(subNum) == null) {
            scoreMap = new HashMap<String, String>();
            scoreMap.put(scoreNum, "");
            table.put(subNum, scoreMap);
        }
        scoreMap = table.get(subNum);
        return scoreMap;
    }

    HashMap<String, HashMap<String, String>> putTable(String stuId, String subNum, String score) {
        if (table.get(stuId) == null) {
            table.put(stuId, new HashMap<String, String>());
            table.get(stuId).put(subNum, score);// 生徒番号、問題番号、スコア
        } else {
            table.get(stuId).put(subNum, score);// 生徒番号、問題番号、スコア
        }
        // if(table.get(subNum==null){
        // scoreMap = new HashMap<>();
        // scoreMap.put(score,1);
        // table.put(subNum, scoreMap);
        // }else{
        // scoreMap=table.get(subNum);
        // table.put(subNum,this.scoreMapset(score,scoreMap));
        // }     
        // for (Integer j = 0; j < subNumList.size(); j++) {
        // if (subNumList.get(j).equals(subNum)) {
        // scoreMap.put(subNum, score);
        // }
        // }
        return table;
    }

    // HashMap<String,Integer> scoremapset(String score ,HashMap<String,Integer>
    // scoremap){
    // Integer num=0;
    // if(!score.isEmpty()){
    // if(scoremap.get(score) == null){
    // scoremap.put(score,0);
    // }
    // num = scoremap.get(score);
    // num+=1;
    // scoremap.put(score,num);
    // }
    // return scoremap;
    // }

    // HashMap<String, HashMap<String, Integer>> putTable(String subNum, String
    // score){
    // HashMap<String, Integer> scoreMap = new HashMap<>();
    // if(scoreMap.get(subNum) == null){
    // scoreMap = new HashMap<>();
    // scoreMap.put(score, 1);
    // table.put(subNum, scoreMap);
    // }else{
    // scoreMap = table.get(subNum);
    // table.put(subNum, this.putScoreMap(score, scoreMap));
    // }
    // return table;
    // }

    // HashMap<String, Integer> putScoreMap(String sco, HashMap<String, Integer>
    // scoreMap){
    // Integer count = 0;
    // if(!sco.isEmpty()){
    // if(scoreMap.get(sco) == null){
    // scoreMap.put(sco, 0);
    // }
    // count = scoreMap.get(sco);
    // count += 1;
    // scoreMap.put(sco, count);
    // }
    // return scoreMap;
    // }

    // ArrayList<String> putScores(HashMap<String, HashMap<String, Integer>> table,
    // HashMap<String, Integer> scoreMap){
    // ArrayList<String> scores = new ArrayList<>();
    // String score;
    // for(HashMap.Entry<String, HashMap<String, Integer>> entry :
    // table.entrySet()){
    // scoreMap = entry.getValue();
    // for(HashMap.Entry<String, Integer> entry1 : scoreMap.entrySet()) {
    // score = entry1.getKey();
    // scores = this.putListToScores(scores, score);
    // }
    // }
    // Collections.sort(scores);
    // scores = this.sortList(scores);
    // return scores;
    // }

    // ArrayList<StudentScore> putStudentScoreList(String subNum, String id, String
    // score) {
    // ArrayList<StudentScore> studentScoreList = new ArrayList<>();
    // StudentScore studentScore = new StudentScore();
    // studentScore = this.putStudentScore(studentScoreList, id, subNum, score);
    // }

    // StudentScore putStudentScore(ArrayList<StudentScore> studentScoreList, String
    // id, String subNum, String score){
    // StudentScore studentScore = new StudentScore();
    // if(studentScoreList.size() == 0){
    // studentScore.put()
    // }
    // }

    // ArrayList<String> sortList(ArrayList<String> scores){
    // ArrayList<Integer> intScoreList = new ArrayList<>();
    // Integer count = 0;
    // Integer number = 0;
    // String score;
    // if(scores.get(0).isEmpty()){
    // count = 1;
    // }
    // for(Integer i = 0; i < scores.size() - count; i++){
    // number = Integer.parseInt(scores.get(count+i));
    // intScoreList.add(number);
    // }
    // Collections.sort(intScoreList);
    // for ( Integer i = 0; i < intScoreList.size(); i++){
    // score = String.valueOf(intScoreList.get(i));
    // scores.set(i + count, score);
    // }
    // return scores;
    // }

    // ArrayList<String> putListToScores(ArrayList<String> scores, String score){
    // Integer num = 0;
    // if(scores.size() == 0){
    // scores.add(score);
    // }
    // num = scores.size();
    // for ( Integer i = 0; i < scores.size(); i++){
    // if(Objects.equals(scores.get(i), score)){
    // num--;
    // }
    // }
    // if( num == scores.size()){
    // scores.add(score);
    // }
    // return scores;
    // }

    // // void putSubjectNumScore(String line) {
    // // String[] items = line.split(",");
    // // for(Integer i = 0; i < nonRepetionList.size(); i++){
    // // for(Integer j = 0; j < subjectNum.size(); j++){
    // // if(subjectNum.get(i) == Integer.valueOf(items[2])){
    // // subjectNumScore.add(Integer.valueOf(items[4]));
    // // }else{
    // // subjectNumScore.add(0);
    // // }
    // // }
    // // table.put(nonRepetionList.get(i), subjectNumScore);
    // // }
    // // //System.out.println(nonRepetionList);
    // // //System.out.println(subjectNumScore);
    // // }

    void printStudentID(ArrayList<String> idList) {
        for (Integer i = 0; i < idList.size(); i++) {
            System.out.printf("%s%n", idList.get(i));
        }
    }

    void printSubjectNum(ArrayList<String> subjectNum) {
        for (Integer i = 0; i < subjectNum.size(); i++) {
            System.out.printf("%s%n", subjectNum.get(i));
        }
    }

    void printscoreMap(HashMap<String, String> scomap) {
        for (HashMap.Entry<String, String> entry : scomap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    // void printTable(HashMap<String, HashMap<String, String>> table) {

    // for (HashMap.Entry<String, HashMap<String, String>> entry : table.entrySet())
    // {
    // String key = entry.getKey(); // 必要に応じて利用する．
    // System.out.printf("%s");
    // HashMap<String, String> submap = entry.getValue();
    // for (HashMap.Entry<String, String> subEntry : submap.entrySet()) {
    // System.out.printf(",%s", submap.getValue());
    // }
    // }
    // }

    void printAll(ArrayList<String> idList, HashMap<String, String> scomap) {
        for (Integer i = 0; i < idList.size(); i++) {
            System.out.printf("%s", idList.get(i));
            for (HashMap.Entry<String, String> entry : scomap.entrySet()) {
                System.out.print("," + entry.getValue());
            }
            System.out.println();
        }
    }

    // void printSubjectNumScore(HashMap<Integer, ArrayList<Integer>> table){
    // // ループ処理する
    // for (HashMap.Entry<Integer, ArrayList<Integer>> map : table.entrySet()) {
    // System.out.printf("%d ,%d%n", map.getKey(), map.getValue());
    // }
    // }

    public static void main(String[] args) throws IOException {
        ScoreAnalyzer3kouhei subject3 = new ScoreAnalyzer3kouhei();
        subject3.run(args);
    }
}