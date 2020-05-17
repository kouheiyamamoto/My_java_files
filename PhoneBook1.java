import java.util.Map;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class PhoneBook1 {
  HashMap<String, String> book = new HashMap<>();

  void run(String[] args) throws IOException {

    SimpleConsole console = new SimpleConsole();
    for(;;){
      System.out.print("> ");
      String line = console.readLine();
      String[] items = line.split(" ");
      if(items[0].equals("list")){
        //リストの中身がある時
        for(Iterator<Map.Entry<String, String>>iterator =
                book.entrySet().iterator(); iterator.hasNext();){
          Map.Entry<String, String> entry = iterator.next();
          String key = entry.getKey();
          String PhoneNumber = this.book.get(key);

          if(key == null){
          }else{
            System.out.println(key+" "+PhoneNumber);
          }
        }
      }else if(items[0].equals("add")){
        this.book.put(items[1], items[2]);
      }else if(items[0].equals("remove")){
        this.book.remove(items[1]);
      }else if(items[0].equals("find") ){
        String PhoneNumber = this.book.get(items[1]);

        if(PhoneNumber != null){
          System.out.println(items[1]+" "+PhoneNumber);
        }
      }else if(items[0].equals("exit")){
        break;
      }
    }
  }

  public static void main(String[] args) throws IOException{
    PhoneBook1 pb = new PhoneBook1();
    pb.run(args);
  }
}
