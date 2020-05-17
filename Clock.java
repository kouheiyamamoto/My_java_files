import java.awt.Color;
import java.util.Date; // Date型を使うためのAPI

public class Clock {

    void run(String[] args) throws InterruptedException {
        EZ.initialize(400,400); // 背景を描画する
        EZCircle clockCircle = EZ.addCircle(200, 200, 400, 400, Color.BLACK, false); // 時計の円を表示
        clock(clockCircle);
    }

    // アナログ時計を描画するメソッド
    void clock(EZCircle circle) throws InterruptedException {
       
        EZLine lineOfSecond = EZ.addLine(200, 200, 200,200, Color.GREEN, 2); // 秒針の描画
        EZLine lineOfMinute = EZ.addLine(200, 200, 200,200, Color.BLUE, 2); // 長針の描画
        EZLine lineOfHour = EZ.addLine(200, 200, 200,200, Color.RED, 2); // 短針の描画
        
        while(true){

            Date date = new Date(); // 現在時刻を取得
            // それぞれの針の角度の計算
            Double degreeOfSeconds = date.getSeconds() * 6.0 - 90; // 秒針の両端の角度
            Double degreeOfMinutes = date.getMinutes() * 6.0 - 90; // 長針の両端の角度
            Double degreeOfHours = (date.getHours() * 5 + date.getMinutes() / 12.0) * 6.0 - 90; // 短針の両端の角度

            // 上で得た角度をラジアン(π)に直す
            Double radianOfSeconds = Math.toRadians(degreeOfSeconds); // 弧度法による角度
            Double radianOfMinutes = Math.toRadians(degreeOfMinutes); // 弧度法による角度
            Double radianOfHours = Math.toRadians(degreeOfHours); // 弧度法による角度

            // それぞれの針の長さを代入している
            Double rOfSecond = 195.0;/*Math.sqrt((Math.pow(degreeOfSeconds, 2)) + (Math.pow(degreeOfSeconds, 2)));*/
            Double rOfMinutes = 180.0;/*Math.sqrt((Math.pow(degreeOfMinutes, 2)) + (Math.pow(degreeOfMinutes, 2)));*/
            Double rOfHours = 130.0;/*Math.sqrt((Math.pow(degreeOfHours, 2)) + (Math.pow(degreeOfHours, 2)));*/

            // それぞれの針の端の座標の計算
            Double yOfSeconds = 200 + rOfSecond * Math.sin(radianOfSeconds);
            Double xOfSeconds = 200 + rOfSecond * Math.cos(radianOfSeconds);

            Double yOfMinutes = 200 + rOfMinutes * Math.sin(radianOfMinutes);
            Double xOfMinutes = 200 + rOfMinutes * Math.cos(radianOfMinutes);

            Double yOfHours = 200 + rOfHours * Math.sin(radianOfHours);
            Double xOfHours = 200 + rOfHours * Math.cos(radianOfHours);
            
            // 時計の針の端を表示する
            lineOfSecond.setPoint2(xOfSeconds.intValue(), yOfSeconds.intValue()); 
            lineOfMinute.setPoint2(xOfMinutes.intValue(), yOfMinutes.intValue());
            lineOfHour.setPoint2(xOfHours.intValue(), yOfHours.intValue());

            EZ.refreshScreen();
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Clock analog = new Clock();
        analog.run(args);
    }
}