class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        boolean flag = false;
        int i = 0;
        for(i=0;i<intervals.length;i++)
        {
            if(newInterval[1] < intervals[i][0])
            {
                ans.add(newInterval);
                flag = true;
                break;
            }
            else if(newInterval[0] > intervals[i][1])
            {
                ans.add(intervals[i]);
            }
            else
            {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

    if(flag == true)
    {
        for(i=i;i<intervals.length;i++)
            ans.add(intervals[i]);
    }
    else
        ans.add(newInterval);

    int[][] ret = new int[ans.size()][2];
    for(int k=0;k<ans.size();k++)
    {
        ret[k] = ans.get(k);
    }
    return ret;
    }
}