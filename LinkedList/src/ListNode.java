
class ListNode {
	private Object data;
	private ListNode link;
	
	public ListNode() {
		this.setData(null);
		this.setLink(null);
	}
	
	public ListNode(Object data) {
		this.setData(data);
		this.setLink(null);
	}
	
	public ListNode(Object data, ListNode link) {
		this.setData(data);
		this.setLink(link);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ListNode getLink() {
		return link;
	}

	public void setLink(ListNode link) {
		this.link = link;
	}
}
