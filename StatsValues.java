//  山本昂平　854030 第4講　練習問題1
import java.util.ArrayList;
import java.util.Random;
import javax.sound.midi.SysexMessage;
import java.util.Collections;

public class StatsValues {
    void run(String[] args) {

        ArrayList<Integer> randomList = new ArrayList<>();
        Integer sum = 0;
      
        Random random = new Random();

        // listに100この乱数を代入する処理
        for (Integer i = 0; i < 100; i++) {
            Integer randomValue = random.nextInt(1000);
            randomList.add(randomValue);
            Integer randomNumber = randomList.get(i);
            sum += randomValue;
        }
        Double dsum = new Double(sum);
        Integer max = Collections.max(randomList);
        Integer min = Collections.min(randomList);
        Double ave = dsum/100.0;
        System.out.printf("合計値：%d, 最大値：%d, 最小値：%d, 平均値：%f%n", sum, max, min, ave);
        
        // listの表示用ループ
        for (Integer i = 0; i < 100; i++) {
            // Integer randomValue = random.nextInt(1000);
            // randomList.add(randomValue);
            Integer randomNumber = randomList.get(i);
            System.out.printf("%3d ",randomNumber);
            // 10個表示したら改行する処理
            if ( i % 10 == 9) {
                System.out.println();
            }
        }   
    }
    public static void main(String[] args) {
        StatsValues printer = new StatsValues();
        printer.run(args);
    }
}