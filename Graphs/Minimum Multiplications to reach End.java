// User function Template for Java
class Pair {
    int node;
    int count;
    public Pair (int node, int count) {
        this.node = node;
        this.count = count;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        
        int mod = 100000;
        int[] dis = new int[mod];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));
        dis[start] = 0;
        
        while(!queue.isEmpty()) {
            Pair top = queue.remove();
            if(top.node == end)
                return dis[end];
            for(int it : arr) {
                int multiply = it * top.node;
                if(multiply >= mod)
                    multiply %= mod;
                if(dis[multiply] > top.count + 1) {
                    queue.add(new Pair(multiply, top.count + 1));
                    dis[multiply] = top.count + 1; 
                }
            }
        }
        
        return dis[end] == Integer.MAX_VALUE ? -1 : dis[end];
    }
}
