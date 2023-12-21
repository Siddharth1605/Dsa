class Solution {
    public String findb(int i, String[] nums, String p)
    {
        if(i == nums.length)
        {
            List<String> lt = Arrays.asList(nums);
            if(!lt.contains(p))
                return p;
            else
                return "";
        }

        String one = findb(i+1, nums, p+"1");
        String zero = findb(i+1, nums, p+"0");

        return (one.length() >= 1) ? one : zero;

    }
    public String findDifferentBinaryString(String[] nums) {
        return findb(0, nums, "");
    }
}