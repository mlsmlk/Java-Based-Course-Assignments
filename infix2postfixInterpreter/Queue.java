package infix2postfixInterpreter;

public class Queue {
	listNode front;
	listNode back;

	public void Enqueue(String value) {
		listNode newNode = new listNode(value);
		if (isEmpty()) {
			front = newNode;
			back = newNode;
		} else {
			back.next = newNode;
			back = newNode;
		}
	}

	public boolean isEmpty() {
		if (front == null)
			return true;
		else
			return false;

	}

	public String Dequeue() {

		if (isEmpty()) {
			return null;
		} else {
			String frontValue = front.value;
			front = front.next;
			return frontValue;
		}
	}
}
