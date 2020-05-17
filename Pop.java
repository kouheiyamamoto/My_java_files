import java.util.Stack;

public class Pop{

    void run(String[] args){
        if (args.length == 0) {
            System.out.println("please input some id");
        } else {
            for (Integer i = 0; i < args.length; i++) {
                reversePorland(args[i]);
            }
        }
    }

    void reversePorland(String st) {
        String parts[] = st.split(" "); // スペースで区切っていく

        // 後に入れたものを先に抜き出す（いわゆるLIFO）
        Stack<Integer> que = new Stack<Integer>();
        int a = 0;
        int b = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("+")) {
                a = que.pop();
                b = que.pop();
                que.add(b + a);
                continue;
            }
            if (parts[i].equals("-")) {
                a = que.pop();
                b = que.pop();
                que.add(b - a);
                continue;
            }
            if (parts[i].equals("*")) {
                a = que.pop();
                b = que.pop();
                que.add(b * a);
                continue;
            }
            if (parts[i].equals("/")) {
                a = que.pop();
                b = que.pop();
                que.add(b / a);
                continue;
            }
            // 演算子以外はstackに登録する
            que.push(Integer.parseInt(parts[i]));
        }
        System.out.printf("%d (%s)%n",que.pop(), st);
    }
    
    public static void main(String[] args) {
        Pop p = new Pop();
        p.run(args);
    }
}