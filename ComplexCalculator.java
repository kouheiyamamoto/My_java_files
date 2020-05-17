public class ComplexCalculator {
    void run() {
        Complex c1 = this.createComplex(5.0, -6.0);
        Complex c2 = this.createComplex(3.0, 2.0);
     
        System.out.printf("absolute(%s) = %f%n", c1, c1.absolute());
        System.out.printf("conjugate(%s) = %s%n", c1, c1.conjugate());

        System.out.printf("%s + %s = %s%n",c1,c2,c1.add(c2)); // 独自型同士の変数の足し算
        System.out.printf("%s - %s = %s%n",c1,c2,c1.subtract(c2));
        System.out.printf("%s * %s = %s%n",c1,c2,c1.multiply(c2));
        System.out.printf("%s / %s = %s%n",c1,c2,c1.divide(c2));

    }

    Complex createComplex(Double realValue, Double imagValue) {
        Complex c = new Complex(); // クラスの中の変数に代入するためにオブジェクトを持ってくる
        c.real = realValue; // クラスの中の変数に代入
        c.imag = imagValue;
        return c; // 新しく作成したComplex型で返す
    }

    public static void main(String[] args) {
        ComplexCalculator printer = new ComplexCalculator();
        printer.run();
    }
}