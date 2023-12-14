import java.util.* ;
import java.io.*; 
/*************************************************************

Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static Node addNode(Node head) {
		// Write your code here.99
		Node rev = reverse(head);
		Node temp = rev;

		int c = 1;
		while(temp != null && c!=0)
		{
			int x = temp.data + 1;
			if(x < 10)
			{
				c = 0;
				temp.data = x;
			}
			else
			{
				c = 1;
				temp.data= 0;
			}
			temp = temp.next;
		}

		Node ans = reverse(rev);
		if(c == 1)
		{
			Node newnode = new Node(1);
			newnode.next = ans;
			ans = newnode;
		}
		return ans;
	}
	public static Node reverse(Node head)
	{
		Node cur = head;
		Node prev = null;
		Node nex = head;

		while(nex != null)
		{
			nex = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nex;
		}
		return prev;
	}
}