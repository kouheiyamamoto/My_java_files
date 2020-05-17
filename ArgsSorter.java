/* 山本昂平　854030 練習問題１　*/

import java.util.Arrays; // ソートプログラムを作成するためのimport			

public class ArgsSorter {
	void run(String[] args) {
		// ここで，printArray を呼び出し，"before"の一行を出力する
		printArray(args);
		// argsの内容をソートするため，Arrays.sortメソッドを呼び出す．
		Arrays.sort(args); // <= args がソート済みになる．
		// ここで，printArray を呼び出し，"after"の一行を出力する．
		printArray1(args);
	}

	// printArrayメソッドをここに書く
	void printArray(String args[]) { // とりあえずbeforeを出力する
		System.out.printf("before: ");
		for (Integer i = 0; i < args.length; i++) {
			System.out.printf("%s, ", args[i]);
		}
		System.out.println();
	}

	// printArrayメソッドをここに書く
	void printArray1(String args[]) { // とりあえずbeforeを出力する
		System.out.printf("after: ");
		for (Integer i = 0; i < args.length; i++) {
			System.out.printf("%s, ", args[i]);
		}
		System.out.println();
	}

	// mainメソッド
	public static void main(String[] args) {
		ArgsSorter printer = new ArgsSorter();
		printer.run(args);
	}
}