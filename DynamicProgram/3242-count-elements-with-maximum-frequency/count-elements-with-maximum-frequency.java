class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int maxi = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            maxi = Math.max(mp.get(nums[i]), maxi);
        }
        int sum = 0;
        for(Map.Entry<Integer, Integer> entry : mp.entrySet())
            if(entry.getValue() == maxi)
                sum += maxi;
         return sum;
    }
}