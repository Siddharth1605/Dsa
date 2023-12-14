/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.child = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.child = null;
     }
     Node(int data, Node next, Node child)
     {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }

 *****************************************************************/

 public class Solution {
    public static Node merge(Node a, Node b)
    {
        Node result = new Node();
        Node temp = result;
        while(a != null && b != null)
        {
            if(a.data <= b.data)
            {
                temp.child = a;
                a = a.child;
            }
            else
            {
                temp.child = b;
                b = b.child;
            }
            temp = temp.child;
        }
        if(a != null)
            temp.child = a;
        if(b != null)
            temp.child = b;
        
        return result.child;

    }
    public static Node flatten(Node root)
    {
        if(root == null || root.next == null )
            return root;
        
        root.next = flatten(root.next);

        root = merge(root, root.next);

        return root;
    }
    public static Node flattenLinkedList(Node head) {
        //Write your code here
        return flatten(head);
    }
}