class Pair {
    int value;
    int nexttime;
    public Pair(int value, int nexttime) {
        this.value = value;
        this.nexttime = nexttime;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Character, Integer> freq = new HashMap<>();
        for(char c : tasks)
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        for(Map.Entry<Character, Integer> entry : freq.entrySet())
            maxHeap.add(entry.getValue());
        int time = 0;
        Queue<Pair> queue = new LinkedList<>();
        while(!maxHeap.isEmpty() || !queue.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int highFrequency = maxHeap.remove() - 1;
                if(highFrequency != 0)
                    queue.add(new Pair(highFrequency, time + n));
            }
            if(!queue.isEmpty() && queue.peek().nexttime <= time) {
                maxHeap.add(queue.poll().value);
            }
        }
        return time;
    }
}