class Solution {
    public int[][] insert(int[][] arr, int[] interval) {
        List<int[]> ans = new ArrayList<>();
        int n = arr.length;
        boolean flag = false;
        int i = 0;
        for(i=0;i<n;i++)
        {
            if(interval[1] < arr[i][0])
            {
                ans.add(interval);
                flag = true;
                break;
            }
            else if(interval[0] > arr[i][1])
            {
                ans.add(arr[i]);
            }
            else
            {
                interval[0] = Math.min(interval[0], arr[i][0]);
                interval[1] = Math.max(interval[1], arr[i][1]);
            }
        }
        if(flag == true)
            for(i=i;i<n;i++)
                ans.add(arr[i]);
        else
            ans.add(interval);
        int[][] lt = new int[ans.size()][2];
        for(i=0;i<ans.size();i++)
            lt[i] = ans.get(i);
        return lt;
    }
}