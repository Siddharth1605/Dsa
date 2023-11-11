public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> lt = new ArrayList<>();
        lt.add(intervals[0]);
        int n = intervals.length;

        for(int i=1;i<n;i++)
        {
            int[] last = lt.get(lt.size() - 1);

            if(intervals[i][0] <= last[1])
                last[1] = Math.max(intervals[i][1], last[1]);
            else
                lt.add(intervals[i]);
                
        }

        n = lt.size();
        int[][] ans = new int[n][2];
        for(int i=0;i<n;i++)
        {
            ans[i][0] = lt.get(i)[0];
            ans[i][1] = lt.get(i)[1];

        }
        return ans;
    }
} {
    
}
