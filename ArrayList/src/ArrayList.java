
public class ArrayList {
   private Object AList[] = new Object[100];
   private int size = 0;
   
   public void addLast(Object data) {
      AList[size] = data;
      size++;
   }
   
   public void add(int index, Object data) {
      if(index > size) {
         System.out.println("[INFO] Insert error : Invalid index");
         return;
      }
      
      for(int i = size-1; i >= index ;i--) {
         AList[i+1] = AList[i];
      }
      AList[index] = data;
      size++;
   }
   public void delete(int index) {
      if(index > size-1) {
         System.out.println("[INFO] Delete error : Invalid index");
         return;
      }
      for(int i = index + 1; i < size;i++) {
         AList[i-1] = AList[i];
      }
      AList[size-1] = null;
      size--;
   }
   
   public void show() {
	  System.out.println("====================================");
      for(int i = 0; i < size; i++) {
         System.out.println("[INFO] Array List [" + i + "] : " + AList[i]);
      }
	  System.out.println("====================================");
   }
}
