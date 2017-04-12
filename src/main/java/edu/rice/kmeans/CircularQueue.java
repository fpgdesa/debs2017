package edu.rice.kmeans;


public class CircularQueue {

	// Number of elements:
	private int windowSize = -1;

	// Size of the queue:
	private int countElements = 0;
	
	// Points:
	private Point[] points;
    private int first, next;
	
	
	// Default constructor:
	public CircularQueue(int _windowSize) {
		this.windowSize = _windowSize;
		this.countElements = 0;
		this.points = new Point[this.windowSize];
		this.first = 0;
		this.next = 0;	
	}
	

	// Check if queue is full:
	private boolean full() {
		return (countElements == windowSize);
	}
	
	// Check if queue is empty:
	public boolean empty () {
        return (countElements == 0);
    } 

	// Size of the queue:
	public int size() {
		return countElements;
	}

	// Insert a point:
	public void insert (Double value) {
		if (!full()) {
			countElements++;
			points[next] = new Point(value);
			next = (next + 1) % windowSize;
		}
		else {
			System.out.println("ERROR : Overflow Exception!");
		}
    }

	
	// Delete a point:
    public Double remove () {
		if (!empty()) {
			countElements--;
			Point result = points[first];
			first = (first + 1) % windowSize;
			return result.getX();
		}
		else {
			System.out.println("ERROR : Underflow Exception!");
			return null;
		}  
    }

	// Display the window of points:
    public void display() {
        System.out.print("[ ");
        for (int i = 0; i < countElements; i++) {
			System.out.print(String.format("%.2f", points[(first + i) % windowSize].getX()) + " ");
		}
        System.out.print("]\n");    
    }		
	
	// Get point at any index:
	public Point get(int index) {
		if (index < 0) {
			return null;
		}
		if (index < countElements) {
			return points[(first + index) % windowSize];
		}	
		return null;
	}
	
	
//	public static void main(String[] args) {
//		CircularQueue cq = new CircularQueue(10);
//		
//		for (int i = 0; i < 10; i++) {
//			cq.insert(i * 0.1);
//			System.out.println("Inserting: " + String.format("%.2f",(i * 0.1)));
//		}
//		cq.display();
//		
//		for (int i = 0; i < 10; i++) {	
//			cq.remove();
//			cq.insert(i * 0.2);
//			System.out.println("Inserting: " + String.format("%.2f",(i * 0.2)));
//			cq.display();
//			
//			System.out.println("0th index is: " + String.format("%.2f",cq.get(0).getX()));
//			System.out.println("4th index is: " + String.format("%.2f",cq.get(4).getX()));			
//		}
//	}
}