package tree;

/* Class containing left and right child of current
node and key value*/
public  class Node {
	int key;
	Node left, right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}
