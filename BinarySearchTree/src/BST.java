
class TreeNode {
	public int item;
	public TreeNode left;
	public TreeNode right;
}

public class BST {
	private TreeNode root = new TreeNode();
	
	public BST() {
		this.root = null;
	}
	
	public void search(int item) {
		if(searchBST(this.root, item) == null) {
			System.out.println("[INFO] " + item + " Not Existing");
		}else {
			System.out.println("[INFO] " + item + " Existing");
		}
	}
	
	private TreeNode searchBST(TreeNode B, int item) {
		TreeNode p = B;
		if(p == null) return null;
		else if(item == p.item) return p;
		else if(item < p.item) return searchBST(B.left,item);
		else return searchBST(B.right,item);
	}
	
	
	public void insert(int item) {
		TreeNode p = this.root;
		TreeNode q = new TreeNode();
		
		while(p != null) {
			if(item == p.item) return;
			q = p;
			if(item < p.item) {
				p = p.left;
			}else {
				p = p.right;
			}
		}
		
		TreeNode newNode = new TreeNode();
		newNode.item = item;
		newNode.right = null;
		newNode.left = null;
		
		if(this.root == null) this.root = newNode;
		else if(item < q.item) q.left = newNode;
		else q.right = newNode;
	}

	//삭제
	public void delete(int item) {
		deleteBST(this.root, item);
	}
	private void deleteBST(TreeNode root, int item) {
		TreeNode p = root;
		TreeNode parent = p;
		TreeNode q = null;
		
		while(p!=null && p.item != item) {	//일단 값을찾자
			if(item == p.item) break;
			parent = p;					
			if(p.item > item) p = p.left;	
			else p = p.right;			
			
		}
		
		if(p == null) return;
		
		if(p.left == null && p.right == null) { //차수가 0인 노드를 제거
			if(p == root) this.root = null;
			else if(parent.left == p) parent.left = null; 
			else parent.right = null;				 
		}
		else if(p.left == null || p.right == null) { //차수가 1인 노드를 제거
			if(p == root) {
				if(p.left != null) this.root = p.left;
				else this.root = p.right;
			}
			else if(p.left != null) {
				if(parent.left == p) parent.left = p.left;
				else parent.right = p.left;
			}else {
				if(parent.left == p) parent.left = p.right;
				else parent.right = p.right;
			}
		}
		else if(p.left != null && p.right != null) { 
			q = maxNode(p.left);
			p.item = q.item;
			if(p.left == q) p.left = p.left.left;
			else deleteBST(p.left,q.item);
			
		}
		return;
	}
	//최대키값 탐색
	private TreeNode maxNode(TreeNode m) {
		TreeNode p = m;
		
		if(p==null) return p;
		else if(p.right == null) return p;
		else {
			while(p.right != null) {
				p = p.right;
			}
			return p;
		}
	}
	

	public void split(BST bBST, BST cBST,int x) {
		TreeNode Small = new TreeNode();
		TreeNode Large = new TreeNode();
		TreeNode S = Small;
		TreeNode L = Large;
		TreeNode p = this.root;
		
		while(p != null) {
			if(p.item == x) {//같은 값이 나오면
				S.right = p.left;	//왼쪽 작은값을 스몰에 넣어준다
				L.left = p.right;	//오른쪽 큰값을 라지에 넣어준다
				
				bBST.root = Small.right;	//이제 만들어진 트리를 넣어준다
				cBST.root = Large.left;		
				
				return;
			}
			else if(p.item > x) {		//찾는 값보다 더 크다면
				L.left = p;				//라지의 포인터를 옮긴다
				L = p;					//더 작은값을 찾기 위함
				p = p.left;
			}
			else {						//찾는 값보다 작다면
				S.right = p;			//스몰의 포인터를 옮긴다
				S = p;					
				p = p.right;
			}
			S.right = null;
			L.left = null;
			bBST.root = Small.right;	
			cBST.root = Large.left;		
		}
		return;
	}
	
	public void show() {
		showBST(this.root);
		System.out.println();
	}
	private void showBST(TreeNode B) {
		if(B != null) {
			System.out.print("[");
			showBST(B.left);
			System.out.print(B.item);
			showBST(B.right);
			System.out.print("]");
		}
	}
}
