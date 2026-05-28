import java.util.Scanner;

class Heap {
	private int[] data;
	private int size;
	private int maxheap;
	final int front = 1;
	public Heap(int maxheap) {
		this.maxheap = maxheap;
		this.size = 0;
		this.data = new int[this.maxheap+1];
		data[0] = Integer.MIN_VALUE;
	}
	
	private int getParentPosition(int position) {
		return position / 2;
		}
	
	private int getLeftChildPosition(int position) {
		return (2 * position);
		}
	
	private int getRightChildPosition(int position) {
		return (2 * position) + 1;
		}
	
	private boolean checkLeaf(int position) {
		if (position >= (size / 2) && position <= size) {
		return true;
		}
		return false;
		}
	
	
	private void swap(int firstNode, int secondNode) {
		int temp;
		temp = data[firstNode];
		data[firstNode] = data[secondNode];
		data[secondNode] = temp;
		}
	
	
	
	private void minHeapify(int position) {
		//check whether the given node is non-leaf and greater than its right and left child
		if (!checkLeaf(position)) {
		if (data[position] >data[getLeftChildPosition(position)] || data[position] >data[getRightChildPosition(position)]) {
		// swap with left child and then heapify the left child
		if (data[getLeftChildPosition(position)] <data[getRightChildPosition(position)]) {
		swap(position, getLeftChildPosition(position));
		minHeapify(getLeftChildPosition(position));
		}
		// Swap with the right child and heapify the right child
		else {
		swap(position, getRightChildPosition(position));
		minHeapify(getRightChildPosition(position));
		}
		}
		}
		}
	
	
	
	public void insertNode(int Data) {
		if (size>= maxheap) {
		return;
		}
		data[++size] = Data;
		int current = size;
		while (current>1 && data[current] <data[getParentPosition(current)]) {
		swap(current, getParentPosition(current));
		current = getParentPosition(current);
		}
		}
	
	
	
	public void displayHeap() {
		System.out.println("PARENT NODE" + "\t" + "LEFT CHILD NODE" + "\t" + "RIGHT CHILD NODE"); for (int k = 1; k <= size / 2; k++) {
		System.out.print(" " + data[k] + "\t\t" + data[2 * k] + "\t\t" + data[2 * k + 1]);
		System.out.println();
		}
		}
	
	
	
	public void designMinHeap() { for (int position = (size / 2); position >= 1; position--) {
		minHeapify(position);
		}
		}
	
	
	
	
	public int removeRoot() {
		int popElement = data[front]; data[front] = data[size--];
		minHeapify(front);
		return popElement;
		}
		}

public class MaxHeap{
    public static void main (String[] args){
		int heapSize;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of Min Heap");
		heapSize = sc.nextInt();
		Heap heapObj = new Heap(heapSize);
		for(int i = 1; i<= heapSize; i++) {
		System.out.print("Enter "+i+" element: ");
		int data = sc.nextInt();
		heapObj.insertNode(data);
		}
		sc.close();
		heapObj.designMinHeap();
		System.out.println("The Min Heap is ");
		heapObj.displayHeap();
		System.out.println("After removing the minimum element(Root Node) "+heapObj.removeRoot()+", Min heap is:");
		heapObj.displayHeap();
	}
}