
public class Main {
	public static void main(String[] args) {
		BTree root;
		BTree LeftTemp;
		BTree RightTemp;
		
		BTree LeftSubroot;
		BTree RightSubroot;
		
		BTree empty = new BTree();
		
		LeftTemp = new BTree(empty,'A',empty);
		RightTemp = new BTree(empty,'B',empty);
		
		LeftSubroot = new BTree(LeftTemp,'+',RightTemp);
		
		LeftTemp = new BTree(empty,'C',empty);
		RightTemp = new BTree(empty,'D',empty);
		
		RightSubroot = new BTree(LeftTemp,'/',RightTemp);
		
		root = new BTree(LeftSubroot,'*',RightSubroot);
		
		root.show();
		
		System.out.println("[INFO] 순환 중위 순회(inorder) ");
		root.InOrder();
		System.out.println("\n[INFO] 순환 전위 순회(preorder) ");
		root.PreOrder();
		System.out.println("\n[INFO] 순환 후위 순회(postorder) ");
		root.PostOrder();
		
		System.out.println("\n[INFO] 비순환 중위 순회(inorder) ");
		root.iterInorder();
		System.out.println("\n[INFO] 비순환 전위 순회(preorder) ");
		root.iterPreorder();
		
		BTree copytree = root.copy();
		
		if(root.equals(copytree)) {
			System.out.println("\nroot and copy are the same ^^");
		}else {
			System.out.println("\nroot and copy are not the same ㅠㅠ");
		}
		
	}
}
