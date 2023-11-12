class Stack {
    
public:
       
        int* arr;
        // Write your code here.
        int c = 0;
        int n = 0;
        int x = 0; 
        int t = -1;
        int capacity = 0;
    Stack(int cap) {
        capacity = cap;
        arr = new int[cap];
        cin >> n;
        for(int i=0;i<n;i++)
        {
            int o = 0;
            cin >> o;
            if(o == 1)  {cin >>x;   push(x);}
            else if(o == 2) pop();
            else if(o == 3) top();
            else if(o == 4) isEmpty();
            else if(o == 5) isFull();
        }
        

    }

    void push(int num) {
        // Write your code here.
        if(c < capacity)  {t++; arr[t] = num; c++;}
    }

    int pop() {
        // Write your code here.
        if(c != 0)  {int y = t; t--;    c--;return arr[y];}
        return -1;
    }
    
    int top() {
        // Write your code here.
        if(c != 0) return arr[t];
        return -1;
    }
    
    int isEmpty() {
        // Write your code here.
        if(t == -1)   return 1;
        return 0;
    }
    
    int isFull() {
        // Write your code here.
        if(c != capacity)   return 0;
        return 1;
    }
    
};