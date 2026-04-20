class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for(String operation : operations) {
            if(operation.charAt(0) == '-' || operation.charAt(2) == '-')
                val = val - 1;
            else
                val = val + 1;
        }
        return val;
    }
}