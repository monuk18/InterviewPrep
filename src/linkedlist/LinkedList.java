package linkedlist;

//Java program to detect loop in a linked list
class LinkedList {
	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}


	/* Appends a new node at the end.  This method is
       defined inside LinkedList class shown above */
	public void append(int new_data)
	{
    /* 1. Allocate the Node &
       2. Put in the data
       3. Set next as null */
		Node new_node = new Node(new_data);

    /* 4. If the Linked List is empty, then make the
           new node as head */
		if (head == null)
		{
			head = new Node(new_data);
			return;
		}

    /* 4. This new node is going to be the last node, so
         make next of it as null */
		new_node.next = null;

		/* 5. Else traverse till the last node */
		Node last = head;
		while (last.next != null)
			last = last.next;

		/* 6. Change the next of last node */
		last.next = new_node;
		return;
	}

	int detectLoop() {
		Node slow_p = head, fast_p = head;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				System.out.println("Found loop");
				System.out.println(countNodesinLoop(slow_p));
				return 1;
			}
		}
		return 0;
	}

	int countNodesinLoop(Node n) {
		int res = 1;
		Node temp = n;
		while (temp.next != n) {
			res++;
			temp = temp.next;
		}
		return res;
	}

	/** Given a list, rotate the list to the right by k places, where k is non-negative.
	 *
	 * Time complexity O(min(n, k))
	 *
	 * https://leetcode.com/problems/rotate-list/*/

	public  static Node rotateRight(Node head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		Node slow = head;
		Node fast = head;
		int i = 0;
		while (i < k && fast != null) {
			fast = fast.next;
			i++;
		}

		if (fast == null) {
			return rotateRight(head, k % i);
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		Node next = slow.next;
		slow.next = null;
		fast.next = head;
		return next;
	}



	 static void printLinklist(Node head){
		while (head!=null)
		{
			System.out.print(" "+head.data);
			head=head.next;
		}
	 }

	/* Drier program to test above functions */
	public static void main(String args[]) {
		LinkedList llist = new LinkedList();

		llist.append(20);
		llist.append(4);
		llist.append(15);
		llist.append(10);
		llist.append(22);
		llist.append(44);
		llist.append(11);
		llist.append(33);

		printLinklist(llist.head);
		System.out.println();
		printLinklist(rotateRight(llist.head,9));
		/* Create loop for testing
		llist.head.next.next.next.next = llist.head;
		llist.detectLoop();*/
	}
}