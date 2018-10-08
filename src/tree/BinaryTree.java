package tree;

import java.util.*;

// Java program for different tree traversals

class BinaryTree {
	// Root of Binary Tree
	Node root;

	BinaryTree() {
		root = null;
	}

	/*
	 * Given a binary tree, print its nodes according to the "bottom-up"
	 * postorder traversal.
	 */
	void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	/* Given a binary tree, print its nodes in inorder */
	void printInorder(Node node) {
		
		if (node == null) {  //System.out.println("-----return child -----");
			return;
		}System.out.println("-----call -----"+node.key);
		 //System.out.println("-----left child "+node.key+"-----");
		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		//System.out.println("-----right child "+node.key+"-----");
		printInorder(node.right);
	}

	// printInorder Iterative
	static ArrayList<Integer> printInorderIterative(Node node) {
		Stack<Node> stack = new Stack<>();
		ArrayList<Integer> arrlst = new ArrayList<>();
		Node currNode = node;
		boolean done = false;
		while (!done) {
			if (currNode != null) {
				stack.push(currNode);
				currNode = currNode.left;
			} else {
				if (stack.isEmpty()) {
					done = true;
				} else {
					currNode = stack.peek();
					System.out.print(currNode.key + " ");
					arrlst.add(currNode.key);
					stack.pop();
					currNode = currNode.right;

				}
			}
		}

		return arrlst;
	}

	/* Given a binary tree, print its nodes in preorder */
	void printPreorder(Node node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");

		/* then recur on left subtree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	// Iterative printPreorder
	static void printPreorderIterative(Node node) {
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			Node currNode = stack.peek();
			System.out.print(currNode.key + " ");
			stack.pop();
			if (currNode.right != null)
				stack.push(currNode.right);
			if (currNode.left != null)
				stack.push(currNode.left);
		}

	}

	// Wrappers over above recursive functions
	void printPostorder() {
		printPostorder(root);
	}

	void printInorder() {
		printInorder(root);
	}

	void printPreorder() {
		printPreorder(root);
	}

	static int minValue(Node node) {
		if (node == null)
			return Integer.MAX_VALUE;

		int res = node.key;
		int lres = minValue(node.left);
		int rres = minValue(node.right);

		if (lres < res)
			res = lres;
		if (rres < res)
			res = rres;
		return res;
	}

	static int maxValue(Node node) {
		if (node == null)
			return Integer.MIN_VALUE;

		int res = node.key;
		int lres = maxValue(node.left);
		int rres = maxValue(node.right);

		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

	boolean checkBST(Node node) {

		if (node == null)
			return (true);

		/* false if the max of the left is > than us */
		if (node.left != null && maxValue(node.left) >= node.key)// >= for race cases were vales is same 
			return (false);

		/* false if the min of the right is <= than us */
		if (node.right != null && minValue(node.right) <= node.key)//<=  for race cases were vales is same 
			return (false);

		/* false if, recursively, the left or right is not a BST */
		if (!checkBST(node.left) || !checkBST(node.right))
			return (false);

		/* passing all that, it's a BST */
		return (true);

	}

	static void levelOrderTraversal(Node node) {
		Queue<Node> queTraversal = new LinkedList<Node>();
		if(node==null)
			return;
		queTraversal.offer(node);
		while(!queTraversal.isEmpty()){
			System.out.print(queTraversal.peek().key + " ");
		if(queTraversal.peek().left !=null)
			queTraversal.add(queTraversal.peek().left);
		if(queTraversal.peek().right !=null)
			queTraversal.add(queTraversal.peek().right);
		queTraversal.poll();
		}
	}

	static void verticalOrderTraversal(Node node) {
		Queue<Node> queTraversal = new LinkedList<Node>();
		Map<Integer,Integer>  map = new HashMap<>();
		LinkedList<Integer> level = new LinkedList<Integer>();
		if(node==null)
			return;
		queTraversal.offer(node);
		map.put(0,node.key);
		int hd=0;
		while(!queTraversal.isEmpty()){
			//System.out.print(queTraversal.peek().key + " ");
			if(queTraversal.peek().left !=null)
			{	map.put(hd-1,queTraversal.peek().left.key);
				queTraversal.add(queTraversal.peek().left);
			}
			if(queTraversal.peek().right !=null)
			{
				map.put(hd+1,queTraversal.peek().right.key);
				queTraversal.add(queTraversal.peek().right);
			}
			queTraversal.poll();
		}
		System.out.print(map);

	}
	
	static int maxDepth(Node node){
		if(node == null)
			return 0;
		Queue<Node> queTraversal = new LinkedList<Node>();
		queTraversal.offer(node);
		queTraversal.offer(null);
		int count =1;
		while(!queTraversal.isEmpty()){
			Node currNode= queTraversal.poll();
			if(currNode != null){
				/*if(currNode.left==null && currNode.right ==null){
					return count;
				}*/
				if(currNode.left !=null){
					queTraversal.offer(currNode.left);
				}
				if(currNode.right !=null){
					queTraversal.offer(currNode.right);
				}
			}
			else if(queTraversal.size()==1 && currNode==null){
				return ++count;
			}
			else {
				count++;
				queTraversal.offer(null);
			}
		}
		
		return count;
	}

	static int minDepth(Node node){
		if(node == null)
			return 0;
		Queue<Node> queTraversal = new LinkedList<Node>();
		queTraversal.offer(node);
		queTraversal.offer(null);
		int count =1;
		while(!queTraversal.isEmpty()){
			Node currNode= queTraversal.poll();
			if(currNode != null){
				if(currNode.left==null && currNode.right ==null){
					return count;
				}
				if(currNode.left !=null){
					queTraversal.offer(currNode.left);
				}
				if(currNode.right !=null){
					queTraversal.offer(currNode.right);
				}
			}
			else{
				count++;
				queTraversal.offer(null);
			}
		}
		
		return count;
	}
	
	static int maxDepthRecursive(Node node){
		if(node == null)
			return 0;
		
		int leftMax= maxDepthRecursive(node.left);
		int rightMax=maxDepthRecursive(node.right);
		return (leftMax>rightMax)? leftMax+1:rightMax+1;
	}

	// This function returns pointer to LCA of two given
	// values n1 and n2. This function assumes that n1 and
	// n2 are present in Binary Tree
	static Node findLCA(Node node, int n1, int n2)
	{
		// Base case
		if (node == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (node.key == n1 || node.key == n2)
			return node;

		// Look for keys in left and right subtrees
		Node left_lca = findLCA(node.left, n1, n2);
		Node right_lca = findLCA(node.right, n1, n2);
		System.out.println("left_lca > "+left_lca+" right_lca > "+right_lca);
		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (left_lca!=null && right_lca!=null)
			return node;

		if (left_lca == null && right_lca == null)
			return null;

		// Otherwise check if left subtree or right subtree is LCA
		return (left_lca != null) ? left_lca : right_lca;
	}

	// Driver method
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.right.left = new Node(6);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.right.right = new Node(11);
		System.out.println(findLCA(tree.root,3,11).key);
		/*
		 * System.out.println("Preorder traversal of binary tree is ");
		 * tree.printPreorder(); System.out.println();
		 * System.out.println("Preorder traversal of binary tree is iterative "
		 * ); printPreorderIterative(tree.root);
		 */

		/*System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();*/
		
		/*System.out.println("Inorder traversal of binary tree is Iterative ");
		printInorderIterative(tree.root);*/

		/*
		 * System.out.println("\nPostorder traversal of binary tree is ");
		 * tree.printPostorder();
		 */
		/*System.out.println("minDepth "+minDepth(tree.root));
		System.out.println("maxDepth "+maxDepth(tree.root));
		System.out.println("maxDepthRecursive "+maxDepthRecursive(tree.root));
		verticalOrderTraversal(tree.root);*/
	}
}
