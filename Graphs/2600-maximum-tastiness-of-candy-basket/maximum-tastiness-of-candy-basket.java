class Solution {

    public static boolean isValid(int distance, int[] position, int m) {
        int lastBucket = position[0];
        m--;
        for(int i=1;i<position.length;i++) {
            if(position[i] - lastBucket >= distance) {
                lastBucket = position[i];
                m--;
            }
            if(m == 0)
                return true;
        }
        return false;
    }
    public int maximumTastiness(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int left = 1;
        int right = position[n-1] - position[0];
        int ans = 0;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(isValid(mid, position, m)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}