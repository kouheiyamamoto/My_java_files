import java.util.HashMap;
import java.util.Map;

public class HashMapSample {
    // runMethod
    void run(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String arg : args) {
            this.putValueToMap(map, arg);
        }
        this.printMap(map);
    }

    // putValueToMapMethod
    void putValueToMap(HashMap<String, Integer> map, String string) {
        // , で文字列を区切っている．
        String[] items = string.split(",");
        Integer value = Integer.valueOf(items[1]);
        map.put(items[0], value);
    }

    // printMapMethod
    void printMap(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    // mainメソッドは省略．
    public static void main(String[] args){
        HashMapSample map = new HashMapSample();
        map.run(args);
    }
}