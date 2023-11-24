class MyCircularQueue {
    int front =  -1;
    int rear = -1;
    int[] queue;
    int n;
    public MyCircularQueue(int k) {
        n = k;
        queue  = new  int[n];
    }
    
    public boolean enQueue(int value) {
        if(front == -1 && front == rear)
        {
            front = rear = 0;
            queue[rear] = value;
        }
        else if((rear + 1)%n == front)  return false;
        else
        {
            rear = (rear + 1)%n;
            queue[rear] = value;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(front == rear && front == -1)    return false;
        else if(front == rear)
            front = rear = -1;
        else
            front = (front + 1) % n;
        return true;    
    }
    
    public int Front() {
        if(front == -1) return -1;
        return queue[front];
    }
    
    public int Rear() {
        if(rear == -1) return -1;
        return queue[rear];
    }
    
    public boolean isEmpty() {
        return (front == -1) ? true : false;
    }
    
    public boolean isFull() {
        return ((rear+1)%n == front) ? true : false;
    }
}

 