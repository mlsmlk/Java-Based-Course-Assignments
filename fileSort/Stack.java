package fileSort;

public class Stack {

	listNode top = null;

	void push(String name) {
		listNode node = new listNode();
		node.data = name;
		node.next = top;
		top = node;
	}

	void pop() {
		while (top != null) {
			System.out.println(top.data);
			top = top.next;
		}

	}

}
