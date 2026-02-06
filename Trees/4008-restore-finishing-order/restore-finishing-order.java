class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = order.length;
        for(int i=1;i<=n;i++)
            map.put(i, 0);
        for(int i=0;i<friends.length;i++)
            map.put(friends[i], 1);
        int[] ans = new int[friends.length];
        int j = 0;
        for(int i=0;i<n;i++){
            if(map.get(order[i]) == 1){
                ans[j] = order[i];
                j++;
            }
        }
        return ans;

    }
}