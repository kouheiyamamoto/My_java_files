import java.awt.Color;
import java.awt.Point;

public class SierpinskiGasket {

    void run(String[] args) {

        EZ.initialize(400, 400); // 背景を描画する

        // はじめの三角形の座標たち
        Double x1 = 10.0;
        Double y1 = 380.0;
        Double x2 = 390.0;
        Double y2 = 380.0;
        Double x3 = 200.0;
        Double y3 = 400 - 190 * Math.sqrt(2); // Double型のときのy座標

        // Double型だった座標をintに直してPoint型の変数に代入する
        Point point1 = doubletoint(x1, y1);
        Point point2 = doubletoint(x2, y2);
        Point point3 = doubletoint(x3, y3);
        // 上に入ったやつは全部int型

        // はじめの三角形を表示する
        EZLine line1to2 = EZ.addLine(point1.x, point1.y, point2.x, point2.y, Color.BLACK);
        EZLine line2to3 = EZ.addLine(point2.x, point2.y, point3.x, point3.y, Color.BLACK);
        EZLine line3to1 = EZ.addLine(point3.x, point3.y, point1.x, point1.y, Color.BLACK);

        Integer n; // コマンドライン引数に与えられた数を代入する変数
        if (args.length == 0) { // もしコマンドライン引数が何もなかった場合
            n = 3; // デフォルト値を3にする
            drawGasket(n, point1, point2, point3);
        } else {
            n = Integer.parseInt(args[0]); // コマンドライン引数に入力された値を入力する
            drawGasket(n, point1, point2, point3);
        }
    }

    // double型の変数2つをintに変換するためのメソッド
    Point doubletoint(Double x, Double y) {
        Point intPoint = new Point();
        intPoint.x = x.intValue();
        intPoint.y = y.intValue();
        return intPoint;
    }

    // // double型の変数2つをintに変換するためのメソッド
    // Point doubletoint2(Double x2, Double y2) {
    //     Point intPoint2 = new Point();
    //     intPoint2.x = x2.intValue();
    //     intPoint2.y = y2.intValue();
    //     return intPoint2;
    // }

    // // あとでdouble型の変数2つをintに変換するためのメソッド
    // Point doubletoint3(Double x3, Double y3) {
    //     Point intPoint3 = new Point();
    //     intPoint3.x = x3.intValue();
    //     intPoint3.y = y3.intValue();
    //     return intPoint3;
    // }

    void drawGasket(Integer num, Point p1, Point p2, Point p3) {
        if (num == 0) { // もしも数値が0だったらなにもしない
            return;
        } else { // コマンドライン引数0以外だった時
            String numtext = String.valueOf(num); // int型のnumをstring型に変換
            // 3箇所の真ん中の座標を返すメソッドをmp変数に代入する
            Point mp1 = midpoint(p1, p2);
            Point mp2 = midpoint(p2, p3);
            Point mp3 = midpoint(p3, p1);

            // 中点同士を結んだ三角形を表示する
            EZLine mline1to2 = EZ.addLine(mp1.x, mp1.y, mp2.x, mp2.y, Color.RED);
            EZLine mline2to3 = EZ.addLine(mp2.x, mp2.y, mp3.x, mp3.y, Color.RED);
            EZLine mline3to1 = EZ.addLine(mp3.x, mp3.y, mp1.x, mp1.y, Color.RED);

            // ? この再帰呼び出しなんでできたんかなぞ(笑)
            drawGasket(num - 1, p1, mp1, mp3);
            drawGasket(num - 1, mp1, p2, mp2);
            drawGasket(num - 1, mp3, mp2, p3);
        }
    }

    // p1からp2の距離の中心の座標を返すメソッド
    Point midpoint(Point p1, Point p2) {
        Point mp = new Point();
        mp.x = (p1.x + p2.x) / 2;
        mp.y = (p1.y + p2.y) / 2;
        return mp;
    }

    // // p2からp3の距離の中心の座標を返すメソッド
    // Point midpoint2(Point p2, Point p3) {
    //     Point mp2 = new Point();
    //     mp2.x = (p2.x + p3.x) / 2;
    //     mp2.y = (p2.y + p3.y) / 2;
    //     return mp2;
    // }

    // // p3からp1の距離の中心の座標を返すメソッド
    // Point midpoint3(Point p3, Point p1) {
    //     Point mp3 = new Point();
    //     mp3.x = (p3.x + p1.x) / 2;
    //     mp3.y = (p3.y + p1.y) / 2;
    //     return mp3;
    // }

    public static void main(String[] args) {
        SierpinskiGasket biscuit = new SierpinskiGasket();
        biscuit.run(args);
    }
}