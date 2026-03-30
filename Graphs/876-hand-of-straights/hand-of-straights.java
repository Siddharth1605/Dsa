class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<hand.length;i++) {
            if(!hashMap.containsKey(hand[i]))
                minHeap.add(hand[i]);
            hashMap.put(hand[i], hashMap.getOrDefault(hand[i], 0) + 1);
        }

        while(!minHeap.isEmpty()) {
            int min = minHeap.peek();
            for(int i=min;i<min+groupSize;i++) {
                int freq = hashMap.getOrDefault(i, 0);
                if(freq == 0)
                    return false;
                hashMap.put(i, freq-1);
                if(freq-1 == 0) {
                    if(!minHeap.isEmpty() && minHeap.peek() == i)
                        minHeap.poll();
                    else
                        return false;
                }
            }
        }
        return true;
    }
}