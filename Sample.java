public class Sample {
   public static void main(String[] args) {

      String text = "abc";      //暗号化する文字
      String data1 = "";        //暗号化後データ格納
      String data2 = "";        //複合化後データ格納
      char no = 3;         //ずらす文字数(ROT13の場合は、13に)

      //暗号化(noで指定文字数プラスする)
      for(int i=0; i<text.length(); i++){
         data1 = data1 + String.valueOf((char)(text.charAt(i) + no));
      }
      //複合化(noで指定文字数マイナスする[元に戻す])
      for(int i=0; i<text.length(); i++){
          data2 = data2 + String.valueOf((char)(data1.charAt(i) - no));
      }
         System.out.println("元のデータ：" + text);  
         System.out.println("暗号化後データ：" +data1);
         System.out.println("複合化後データ：" +data2);          
  }
}