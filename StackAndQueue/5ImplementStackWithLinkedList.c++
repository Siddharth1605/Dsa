/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
            int data;
            Node *next;
            Node()
            {
                this->data = 0;
                next = NULL;
            }
            Node(int data)
            {
                this->data = data;
                this->next = NULL;
            }
            Node(int data, Node* next)
            {
                this->data = data;
                this->next = next;
            }
        };


*****************************************************************/

class Stack
{
    //Write your code here
    Node *list = new Node(0);
    Node *top = list;
    int x = 0;
    int s = 0;
    int o = 0;
public:
    Stack()
    {
        int n = 0;
        cin >> n;
        for(int i=0;i<n;i++)
        {
            cin >> o;
            if(o == 1)  getSize();
            else if(o == 2) isEmpty();
            else if(o == 3) {cin >> x;  push(x);}
            else if(o == 4) pop();
            else if(o == 5) getTop();
        }
        //Write your code here
    }

    int getSize()
    {
        return s;
        //Write your code here
    }

    bool isEmpty()
    {
        //Write your code here
        return s==0;
    }

    void push(int data)
    {
        //Write your code here
        Node *newnode = new Node(data);
        newnode->next = top;
        top = newnode;
        s+=1;
    }

    void pop()
    {
        //Write your code here
        if(top != NULL)
        {top =top->next; s-=1;}
    }

    int getTop()
    {
        //Write your code here
        if(top != NULL) return top->data;
        else return -1;
    }
};