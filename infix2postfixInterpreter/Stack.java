package infix2postfixInterpreter;

public class Stack {

	listNode top;

	public void push(String given_value) {

		listNode newTop = new listNode(given_value);

		newTop.next = top;
		top = newTop;
	}

	public listNode pop() {
		if (top == null) {

			return null;
		} else {
			listNode oldtop = top;
			top = top.next;
			return oldtop;
		}
	}

	public void print_pop() {
		while (top != null) {
			listNode poppedNode = this.pop();
			System.out.print(poppedNode.value + " ");
		}
	}
}
