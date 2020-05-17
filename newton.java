// ニュートン法を用いる計算
public class SquareRoot{
  void run(String[] args){
    for(Integer i = 0; i < args.length; i++){
      Double value = new Double(args[i]);
      Double result = calculate(value);
      System.out.printf("sqrt(%f) = %f (%f)%n", 
          value, result, Math.sqrt(value));
      }
  }
  Double calculate(Double n){
    Double threshold = 0.00001;

    Double xValue = 10.0; // 初期値 x0
    // y = x^2 - n の式になる
    Double yValue = function(n, xValue);
    // ここにニュートン法のプログラムを書きましょう．

    // |yValue| < threshold ならばループを抜ける．
    // （yValue の絶対値が閾値（threshold）よりも小さい）
    while(Math.abs(yValue) < threshold){
      // xValue における放物線f(x)傾きを求める
      // 傾き(slant)は 2 * xValue で求められる．
      // f'(x)=2x であるため．
      Double slant = 2 * xValue;

      // 次は，接線が y 軸と交わる切片 b を求める（y = a x + b）．
      // (xValue, yValue) を通り 傾き a は先ほど求めた．
      // そのため，b = yValue - (slant * xValue) で求める．
      Double b = yValue - (slant * xValue);

      // 次に，接線が x 軸と交わるときの xValue の値を求める．
      xValue = -(b/slant);

      // yValue に 放物線の y の値（xValueを元に求める）を代入する．
      yValue = function(n, xValue);
    }
    return xValue;
  }
  
  // x^2 - n を計算するメソッド．
  Double function(Double n, Double x){
    return x * x - n;
  }

    public static void main(String[] args) {
        SquareRoot printer = new SquareRoot();
        printer.run(args);
    }
}