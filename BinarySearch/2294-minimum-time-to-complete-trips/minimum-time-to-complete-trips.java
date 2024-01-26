class Solution {
    public long minimumTime(int[] arr, int trips) {
        long low = 1;
        long high = 100000000000000L;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (count(arr, mid, trips) >= trips) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static long count(int[] arr, long t, int trips) {
        long total = 0;
        for (int i = 0; i < arr.length; i++)
        {    
            long tmp = (long) t;
            total += t / arr[i];
            if(total >= trips){
                break;
            }
        }
        return total;
    }
}
