class Queue {

	int front, rear;
	vector<int> arr;
	int x = 0;
	int o=0;
public:
	Queue()
	{
		front = 0;
		rear = 0;
		arr.resize(100001);
		int n = 0;
		cin >> n;
		for(int i=0;i<n;i++)
		{
			cin >> o;
			if(o == 1)	{cin >> x;	enqueue(x);}
			else if(o == 2)	{dequeue();}
		}
	}

	// Enqueue (add) element 'e' at the end of the queue.
	void enqueue(int e)
	{
		// Write your code here.
		arr[rear%100001] = e;
		rear=rear+1;
	}

	// Dequeue (retrieve) the element from the front of the queue.
	int dequeue()
	{
		// Write your code here.
		if(front == rear)	return -1;
		else	{int f = front;	front++;	return arr[f%100001];}
	}
};