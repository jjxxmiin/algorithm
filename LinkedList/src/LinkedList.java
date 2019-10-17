
public class LinkedList {
	private ListNode head;
	
	public void addLastNode(Object data) {
		ListNode newNode = new ListNode();
		
		newNode.setData(data);
		newNode.setLink(null);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		ListNode temp = head;
		while(temp.getLink() != null) {
			temp = temp.getLink();
		}
		temp.setLink(newNode);
	}
	
	public void deleteLastNode() {
		ListNode preNode, curNode;
		
		if(head == null) {
			System.out.println("[INFO] Delete Fail : Empty List");
			return;
		}
		if(head.getLink() == null) {
			head = null;
			return;
		}
		preNode = head;
		curNode = head.getLink();
		while(curNode.getLink() != null) {
			preNode = curNode;
			curNode = curNode.getLink();
		}
		preNode.setLink(null);
	}
	
	public void insert(ListNode preNode, Object data) {
		ListNode newNode = new ListNode(data);
		
		if(head == null) {
			System.out.println("[INFO] Insert Fail : Empty List");
			return;
		}
		if(preNode == null) {
			System.out.println("[INFO] Insert Fail : PreNode is null");
			return;
		}
		
		newNode.setLink(preNode.getLink());
		preNode.setLink(newNode);
	}
	
	public void delete(Object data) {
		ListNode preNode, curNode;
		
		if(head == null) {
			System.out.println("[INFO] Delete Fail : Empty List");
			return;
		}
		if(head.getLink() == null) {
			head = null;
			return;
		}
		preNode = head;
		curNode = head.getLink();
		
		if(data.equals(preNode.getData())) {
			head = preNode.getLink();
			preNode.setLink(null);
			return;
		}
		
		while(curNode != null) {
			if(data.equals(curNode.getData())) {
				if(curNode.getLink() == null) {
					preNode.setLink(null);
				}else {
					preNode.setLink(curNode.getLink());
					curNode.setLink(null);
				}
				return;
			}
			preNode = curNode;
			curNode = curNode.getLink();
		}
		System.out.println("[INFO] No Delete Node");
	}
	
	public ListNode search(Object data) {
		ListNode temp = head;
		
		while(temp != null) {
			if(data.equals(temp.getData())) {
				return temp;
			}
			else {
				temp = temp.getLink();
			}
		}
		
		System.out.println("[INFO] No Search Node" + data);
		return null;
	}
	
	public void show() {
		int i = 0;
		if(head == null) {
			System.out.println("[INFO] Empty List");
			return;
		}
		ListNode temp = head;
		
		System.out.println("[INFO] List show start");
		
		while(temp != null) {
			System.out.println("[INFO] List-" + i++ + " : " + temp.getData());
			temp = temp.getLink();
		}	
		
		System.out.println("[INFO] List show end");
		
	}
}
