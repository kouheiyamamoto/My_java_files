import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ArrayList;
import java.util.Collections;

public class ScoreAnalyzer2kotake {

    void run(String[] args) throws IOException {
        HashMap<String, HashMap<String, Integer>> scorepercent = new HashMap<>();
        HashMap<String, Integer> scoremap = new HashMap<>();
        ArrayList<String> scorelist = new ArrayList<>();
        File file1 = new File(args[0]);
        scorepercent = this.filescan(file1, scorepercent);
        scorelist = this.Scorelist(scorepercent, scoremap);
        this.print(scorepercent, scoremap, scorelist);
    }

    HashMap<String, HashMap<String, Integer>> filescan(File file,
        HashMap<String, HashMap<String, Integer>> scorepercent) throws IOException {
        HashMap<String, Integer> scoremap = new HashMap<>();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] items = line.split(",");
            if (scorepercent.get(items[2]) == null) { // 外側のキーから取り出して
                scoremap = new HashMap<>();
                scoremap.put(items[4], 1);
                scorepercent.put(items[2], scoremap);
            } else {
                scoremap = scorepercent.get(items[2]);
                scorepercent.put(items[2], this.scoremapset(items[4], scoremap));
            }
        }
        in.close();
        return scorepercent;
    }

    HashMap<String, Integer> scoremapset(String score, HashMap<String, Integer> scoremap) {
        Integer num = 0;
        if (scoremap.get(score) == null) {
            scoremap.put(score, 0);
        }
        num = scoremap.get(score);
        num += 1;
        scoremap.put(score, num);
        return scoremap;
    }

    Integer ExamineeCount(HashMap<String, Integer> scoremap) {
        Integer examineeCount = 0;
        for (Map.Entry<String, Integer> entry : scoremap.entrySet()) {
            if (entry.getValue() != null) {
                examineeCount += entry.getValue();
            }
        }
        return examineeCount;
    }

    ArrayList<String> Scorelist(HashMap<String, HashMap<String, Integer>> scorepercent,
            HashMap<String, Integer> scoremap) {
        ArrayList<String> scorelist = new ArrayList<String>();
        String score;
        for (Map.Entry<String, HashMap<String, Integer>> entry1 : scorepercent.entrySet()) {
            scoremap = entry1.getValue();
            for (Map.Entry<String, Integer> entry2 : scoremap.entrySet()) {
                score = entry2.getKey();
                scorelist = this.Listadd(scorelist, score);
            }
        }
        Collections.sort(scorelist);
        scorelist = this.scorelistsort(scorelist);
        return scorelist;
    }

    ArrayList<String> scorelistsort(ArrayList<String> scorelist) {
        ArrayList<Integer> newlist = new ArrayList<>();
        Integer count = 0;
        Integer num = 0;
        String score;
        if (scorelist.get(0).isEmpty()) {
            count = 1;
        }
        for (Integer i = 0; i < scorelist.size() - count; i++) {
            num = Integer.valueOf(scorelist.get(count + i));
            newlist.add(num);
        }
        Collections.sort(newlist);
        for (Integer i = 0; i < newlist.size(); i++) {
            score = String.valueOf(newlist.get(i));
            scorelist.set(i + count, score);
        }
        return scorelist;
    }

    ArrayList<String> Listadd(ArrayList<String> scorelist, String score) {
        Integer count = 0;
        if (scorelist.size() == 0) {
            scorelist.add(score);
        }
        count = scorelist.size();
        for (Integer i = 0; i < scorelist.size(); i++) {
            if (Objects.equals(scorelist.get(i), score)) {
                count--;
            }
        }
        if (count == scorelist.size()) {
            scorelist.add(score);
        }
        return scorelist;
    }

    void printvalue(String score, ArrayList<String> scorelist, HashMap<String, Integer> scoremap,
        Integer examineecount) {
        Integer value = 0;
        Double percent = 0.0;
        if (scoremap.get(score) == null) {
            System.out.print(",");
        } else {
            value = scoremap.get(score);
            percent = 100.000 / (double) examineecount * (double) value;
            System.out.printf(",");
            System.out.printf("%6.3f", percent);
        }
    }

    void print(HashMap<String, HashMap<String, Integer>> scorepercent, HashMap<String, Integer> scoremap,
            ArrayList<String> scorelist) {
        String score;
        Integer examineecount;

        for (Integer i = 0; i < scorelist.size(); i++) {
            System.out.printf(",%s", scorelist.get(i));
        }
        System.out.println();

        for (Map.Entry<String, HashMap<String, Integer>> entry1 : scorepercent.entrySet()) {
            scoremap = entry1.getValue();
            examineecount = this.ExamineeCount(scoremap);
            System.out.printf("%s", entry1.getKey());
            for (Integer i = 0; i < scorelist.size(); i++) {
                score = scorelist.get(i);

                this.printvalue(score, scorelist, scoremap, examineecount);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        ScoreAnalyzer2kotake app = new ScoreAnalyzer2kotake();
        app.run(args);

    }
}