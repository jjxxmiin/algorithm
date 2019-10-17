import java.util.Stack;

class TreeNode {
	public Object item;
	public TreeNode left;
	public TreeNode right;
}


public class BTree {
	private TreeNode root =  new TreeNode();
	
	public BTree() {
		this.root = null;
	}
	
	public BTree(BTree left,Object item, BTree right) {
		this.root.item = item;
		this.root.left = left.root;
		this.root.right = right.root;
	}
	
	public boolean isEmpty() {
		if(this.root == null) return true;
		return false;
	}
	
	public Object rootData() {
		if(this.isEmpty()) {
			System.out.println("[INFO] Tree is Empty");
			return null;
		}else return root.item;
	}
	
	public BTree leftSubTree() {
		if(this.root.left == null) {
			return null;
		}
		BTree left = new BTree();
		left.root = this.root.left;
		return left;
	}
	
	public BTree rightSubTree() {
		if(this.root.right == null) {
			return null;
		}
		BTree right = new BTree();
		right.root = this.root.right;
		return right;
	}
	
	
	public void show() {
		BTree right = this.rightSubTree();
		BTree left = this.leftSubTree();
		
		System.out.println("root : " + this.rootData());
		System.out.println("Left Sub Tree root : " + left.root.item);
		System.out.println("Right Sub Tree root : " + right.root.item);
	}
	
	// ========= 중위 순회 =============
	public void InOrder()
	{
		TheInOrder(this.root);
	}
	private void TheInOrder(TreeNode T) 
	{
		if(T != null)
		{
			TheInOrder(T.left);
			System.out.print(T.item + " ");
			TheInOrder(T.right);
		}
	}
	// ========= 전위 순회 =============
	public void PreOrder()
	{
		ThePreOrder(this.root);
	}
	private void ThePreOrder(TreeNode T) 
	{
		if(T != null)
		{
			System.out.print(T.item + " ");
			ThePreOrder(T.left);
			ThePreOrder(T.right);
		}
	}
	// ========= 후위 순회 =============
	public void PostOrder()
	{
		ThePostOrder(this.root);
	}
	private void ThePostOrder(TreeNode T) 
	{
		if(T != null)
		{
			ThePostOrder(T.left);
			ThePostOrder(T.right);
			System.out.print(T.item + " ");
		}
	}
	
	public void iterInorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		
		if(p != null) {
			stack.push(p);
		}
		while(stack.isEmpty() != true) {
			if(p != null) {
				p = stack.peek();
				p = p.left;
				while(p != null) {
					stack.push(p);
					p = p.left;
				}
			}
			p = stack.pop();
			System.out.print(p.item + " ");
			p = p.right;
			if(p != null) {
				stack.push(p);
			}
		}
	}
	
	public void iterPreorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		
		if(p != null) {
			stack.push(p);
		}
		while(stack.isEmpty() != true) {
			if(p != null) {
				p = stack.peek();
				System.out.print(p.item + " ");
				p = p.left;
				while(p != null) {
					stack.push(p);
					System.out.print(p.item + " ");
					p = p.left;
				}
			}
			p = stack.pop();
			p = p.right;
			if(p != null) {
				stack.push(p);
			}
		}
	}
	
	public BTree copy() {
		BTree copytree = new BTree();
		copytree.root = theCopy(this.root);
		return copytree;
	}
	private TreeNode theCopy(TreeNode T) {
		TreeNode L,R;
		TreeNode S = new TreeNode();
		if(T != null) {
			L = theCopy(T.left);
			R = theCopy(T.right);
			
			S.item = T.item;
			S.left = L;
			S.right = R;
		}
		else {
			return null;
		}
		
		return S;
	}
	
	public boolean equals(BTree S) {
		return theEquals(S.root,this.root);
	}
	private boolean theEquals(TreeNode S, TreeNode T) {
		if(S == null && T == null) {
			return true;
		}
		else if(S != null && T != null) {
			if(S.item == T.item) {
				if(theEquals(S.left,T.left)) {
					return theEquals(S.right,T.right);
				}
				return false;
			}
			else {
				return false;
			}
		}
		return false;
	}
}
