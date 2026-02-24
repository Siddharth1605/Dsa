class Solution {
    public String findOrder(String[] words) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Character> reverse = new HashMap<>();
        
        int index = 0;
        
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                if(!map.containsKey(ch)) {
                    map.put(ch, index);
                    reverse.put(index, ch);
                    index++;
                }
            }
        }
        int v = map.size();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<v;i++)
            adj.add(new ArrayList<>());
        int[] indegree = new int[v];
        for(int i=0;i<words.length-1;i++) {
            String str1 = words[i];
            String str2 = words[i+1];
            int len = Math.min(str1.length(), str2.length());
            boolean found = false;
            //for cases : abc, ab
            for(int j = 0; j < len; j++) {
                if(str1.charAt(j) != str2.charAt(j)) {
                    adj.get(map.get(str1.charAt(j)))
                       .add(map.get(str2.charAt(j)));
            
                    indegree[map.get(str2.charAt(j))]++;
                    found = true;
                    break;
                }
            }
            
            if(!found && str1.length() > str2.length())
                return "";
        }
        return toposort(v, adj, indegree, reverse);
    }
    public String toposort(int v, List<List<Integer>> adj, int[] indegree, Map<Integer, Character> reverse) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<v;i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }
        StringBuilder obj = new StringBuilder();
        while(!queue.isEmpty()) {
            int top = queue.poll();
            obj.append(reverse.get(top));            
            for(int it : adj.get(top)) {
                indegree[it]--;
                if(indegree[it] == 0)
                    queue.add(it);
            }
        }
        
        if(obj.length() == v)
            return new String(obj);
        return "";
    }
}
