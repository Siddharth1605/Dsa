class JobComparator implements Comparator<Job>
{
    @Override
    public int compare(Job a , Job b)
    {
        if(a.profit > b.profit)
            return -1;
         else if (a.profit < b.profit)
            return 1;
        else
            return 0;
    }
}

class Solution
{
    int[] JobScheduling(Job arr[], int n)
    {
        JobComparator jobComparator = new JobComparator();
        Arrays.sort(arr, jobComparator);
        
        int maxi = 0;
        for(int i=0;i<n;i++)
        {
            maxi = (maxi > arr[i].deadline) ? maxi : arr[i].deadline;
        }
        
        int[] result = new int[maxi + 1];
        for(int i=1;i<=maxi;i++)    result[i] = -1;
        
        int countjob = 0;
        int jobprofit = 0;
        
        for(int i=0;i<n;i++)
        {
            for(int j=arr[i].deadline;j>0;j--)
            {
                if(result[j] == -1)
                {
                    result[j] = i;
                    countjob++;
                    jobprofit += arr[i].profit;
                    break;
                }
            }
        }
        
        int[] ans = new int[2];
        ans[0] = countjob;
        ans[1] = jobprofit;
        
        return ans;
    }
}
