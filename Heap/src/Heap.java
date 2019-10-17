
public class Heap {
	private int nNode;		// 노드의 개수
	private int maxSize;	// Heap 크기
	private int heap[];		// Heap
	
	public Heap() {
		nNode = 0;
		maxSize = 5;
		heap = new int[maxSize];
	}
	
	
	
	public Heap(int[] tree) {
		nNode = tree.length - 1;
		maxSize = tree.length;
		heap = tree;
		
		int p,temp;
		for(int i=nNode/2;i>=1;i=i-1) {
			p = i;
			for(int j=2*p;j<=nNode;j=j*2) {
				if(j<nNode) {
					if(heap[j] < heap[j+1]) j = j+1; // 자식중에 큰것
				}
				if(heap[p]>=heap[j]) break;			 // 자식보다 루트가 클때
				temp = heap[p];						 
				heap[p] = heap[j];
				heap[j] = temp;
				p = j;
			}
		}
	}
	private void heapFull() {
		maxSize++;
		int tempHeap[] = new int[maxSize];
		
		for(int i=0;i<maxSize-1;i++) {
			tempHeap[i] = heap[i];
		}
		heap = tempHeap;
	}
	
	public void insert(int item) {
		if(nNode + 1 == maxSize) heapFull();
		
		nNode++;
		
		int i;
		for(i=nNode;;) {
			if(i == 1) break;
			if(item <= heap[i/2]) break;
			heap[i] = heap[i/2];
			i = i/2;
		}
		heap[i] = item;
	}
	
	public int delete() {
		if(nNode == 0) return -1;
		
		int item = heap[1];
		int temp = heap[nNode];
		nNode--;
		int i = 1;
		int j = 2;
		while(j <= nNode) {
			if(j < nNode) {
				if(heap[j] < heap[j+1]) j=j+1;
			}
			
			if(temp >= heap[j]) break;
			
			heap[i] = heap[j];
			i = j;
			j = j*2;
		}
		heap[i] = temp;
		return item;
	}
	
	public void show() {
		for(int i=1; i<=nNode;i++) {
			System.out.print(heap[i] + " | ");
		}
		System.out.println("");
	}
}
