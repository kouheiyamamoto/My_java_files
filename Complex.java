public class Complex {
    
    Double real; // 実数部分
    Double imag; // 虚数部分
 
    void print() {
        System.out.printf("%5.2f + %5.2f i", this.real, this.imag);
    }

    void println() {
        this.print();
        System.out.println();
    }

    public String toString() {
        return String.format("%5.2f + %5.2f i", this.real, this.imag);
    }

    Double absolute() {
        return Math.abs( Math.sqrt( Math.pow(this.real, 2) + Math.pow(this.imag, 2)) );
    }

    Complex conjugate() {
        Complex complex = new Complex(); // クラスを使うためのオブジェクト選択
        complex.real = this.real; // クラスの中に代入
        complex.imag = this.imag * -1;
        return complex; // complex型で返す
    }
    
    // 足し算の結果を返す
    Complex add(Complex value) {
        // this + value の結果を返す．
        Complex complex = new Complex();
        complex.real = this.real + value.real;
        complex.imag = this.imag + value.imag;
        return complex;
    }

    // 引き算の結果を返す
    Complex subtract(Complex value) {
        // this - value の結果を返す．
        Complex complex = new Complex();
        complex.real = this.real - value.real;
        complex.imag = this.imag - value.imag;
        return complex;
    }

    // 掛け算の結果を返す
    Complex multiply(Complex value) {
        // this * value の結果を返す．
        Complex complex = new Complex();
        complex.real = (this.real * value.real) - (this.imag * value.imag); 
        complex.imag = (this.real * value.imag) + (this.imag * value.real);
        return complex;
    }

    // 割り算の結果を返す
    Complex divide(Complex value) {
        // this / value の結果を返す．
        Complex complex = new Complex();
        complex.real = ( (this.real * value.real) + (this.imag * value.imag) ) / ( ( Math.pow(value.real, 2) ) + ( Math.pow(value.imag, 2) ) );
        complex.imag = ( (this.imag * value.real) - (this.real * value.imag) ) / ( ( Math.pow(value.real, 2) ) + ( Math.pow(value.imag, 2) ) );
        return complex; // 型ごと返す(クラスごと返す)
    }
}