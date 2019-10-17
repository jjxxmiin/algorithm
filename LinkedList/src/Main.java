
public class Main {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode temp = new ListNode();
		
		list.addLastNode("A");
		list.addLastNode("B");
		list.addLastNode("C");
		list.addLastNode("E");
		list.addLastNode("F");
		list.addLastNode("G");
		list.show();
		
		temp = list.search("A"); // find 
		list.insert(temp, "D");  // insert
		list.show();
		
		list.delete("A");
		list.delete("G");
		list.show();
		
		list.deleteLastNode();
		list.deleteLastNode();
		list.deleteLastNode();
		list.show();
	}
}
