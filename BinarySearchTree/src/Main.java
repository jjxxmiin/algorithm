
public class Main {
	public static void main(String args[]) {
		BST aBST = new BST();
		
		System.out.println("[INFO] Insert ===");
		
		aBST.insert(11);
		aBST.insert(9);
		aBST.insert(15);
		aBST.insert(22);
		aBST.insert(18);
		aBST.insert(15);
		aBST.insert(16);
		aBST.show();
		
		System.out.println("[INFO] Search ===");
		
		aBST.search(50);
		
		System.out.println("[INFO] Delete ===");
		aBST.delete(22);
		aBST.show();
		
		BST bBST = new BST();
		BST cBST = new BST();
		
		
		
		System.out.println("[INFO] Split ===");
		aBST.split(bBST,cBST,25);
		
		System.out.println("Left Tree");
		bBST.show();
		
		System.out.println("Right Tree");
		cBST.show();
	}
}



