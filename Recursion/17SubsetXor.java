class Solution {
    public static int fun(int i, int[] nums, int sum, int xor)
    {
        if(i == nums.length)
        {
            sum += xor;
            return sum;
        }

        xor = xor ^ nums[i];
        int pick = fun(i+1, nums, sum, xor);
        
        //backtracking
        xor = xor ^ nums[i];
        int npick = fun(i+1, nums, sum, xor);

        return pick + npick;
    }
    public int subsetXORSum(int[] nums) {


        return fun(0, nums, 0, 0);
    }
}