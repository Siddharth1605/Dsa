void immediateSmaller(vector<int>& a)
{
	// Write your code here.
	int i=0;
	for(i=0;i<a.size()-1;i++)
	{
		if(a[i]>a[i+1]) 	a[i] = a[i+1];
		else	a[i] = -1;
	}
	a[i] = -1;

}
