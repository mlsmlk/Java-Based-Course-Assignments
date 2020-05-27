package fileSort;

public class bTree {

	bNode root = null;
	Stack ms = null;

	public void addNode(String data) {
		root = rNode(root, data);
	}

	private bNode rNode(bNode root, String data) {
		if (root == null) {
			bNode node = new bNode();
			node.data = data;
			node.left = null;
			node.right = null;
			root = node;
			return root;
		} else if (data.compareTo(root.data) < 0) {
			root.left = rNode(root.left, data);
		} else
			root.right = rNode(root.right, data);
		return root;
	}

	public void inorder() {
		traverse_inorder(root);
	}

	private void traverse_inorder(bNode root) {
		if (root.left != null)
			traverse_inorder(root.left);
		System.out.println(root.data);
		ms.push(root.data);
		if (root.right != null)
			traverse_inorder(root.right);
	}

}
