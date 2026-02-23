class Solution {
    public int[] findOrder(int v, int[][] edges) {
        int[] indegree = new int[v];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++) {
            adj.get(edges[i][1])
                .add(edges[i][0]);
            indegree[edges[i][0]]++;
        }
        return bfs(v, indegree, adj);
        
    }
    public int[] bfs(int v, int[] indegree, List<List<Integer>> adj) 
    {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()) {
            int top = queue.poll();
            ans.add(top);
            for(int it : adj.get(top)) {
                indegree[it]--;
                if(indegree[it] == 0)
                    queue.add(it);
            }
        }
        int size = ans.size();
        if(size != v)
            return new int[0];
        int[] arr = new int[size];
        for(int i=0;i<size;i++)
            arr[i] = ans.get(i);
        return arr;
    }
    
}