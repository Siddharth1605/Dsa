import java.util.*;

class Solution {
    public static void fun(int ind, List<Integer> ds, int[] nums, Set<List<Integer>> set)
    {
        if(ds.size() > 1)
            set.add(new ArrayList<>(ds));

        if(ind == nums.length)
            return;
            
        for(int i=ind;i<nums.length;i++)
        {
            if(ds.size() == 0 || ds.get(ds.size() - 1) <= nums[i])
            {
                ds.add(nums[i]);    
                fun(i+1, ds, nums, set);
                ds.remove(ds.size() - 1);
             }
        }
     } 

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> ds = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        fun(0, ds, nums, set);
        return new ArrayList<>(set);
    }
}
