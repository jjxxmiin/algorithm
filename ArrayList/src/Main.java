public class Main {
   public static void main(String[] args) {
      ArrayList AList = new ArrayList();
      
      AList.addLast(10);
      AList.addLast(20);
      AList.addLast(30);
      AList.addLast(40);
      AList.addLast(50);
      AList.addLast(60);
      
      AList.show();
      
      AList.add(3, 11);
      
      AList.show();
      
      AList.delete(5);
      
      AList.show();
   }
}