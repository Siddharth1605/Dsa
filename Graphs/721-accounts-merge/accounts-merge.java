class Disjointset {
    List<Integer> parent;
    List<Integer> size;
    public Disjointset(int n) {
        parent = new ArrayList<>();
        size = new ArrayList<>();
        for(int i=0;i<n;i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int u) {
        if(u == parent.get(u))
            return u; 
        parent.set(u, findParent(parent.get(u)));
        return parent.get(u);
    }

    public void unionBySize(int u, int v) {
        int upU = findParent(u);
        int upV = findParent(v);
        if(upU == upV)
            return;
        if(size.get(upU) < size.get(upV)) {
            size.set(upV, size.get(upV) + size.get(upU));
            parent.set(upU, upV);
        } else {
            size.set(upU, size.get(upU) + size.get(upV));
            parent.set(upV, upU);
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> mailNodes = new HashMap<>();
        int n = accounts.size();
        Disjointset ds = new Disjointset(n);
        for(int i=0;i<n;i++) {
            for(int j=1;j<accounts.get(i).size();j++) {
                if(mailNodes.containsKey(accounts.get(i).get(j))) {
                    ds.unionBySize(i, mailNodes.get(accounts.get(i).get(j)));
                } else {
                    mailNodes.put(accounts.get(i).get(j), i);
                }
            }
        }

        List<List<String>> mergedMails = new ArrayList<>();
        for(int i=0;i<n;i++)
            mergedMails.add(new ArrayList<>());
        for(Map.Entry<String, Integer> entry : mailNodes.entrySet()) {
            String mail = entry.getKey();
            int node = ds.findParent(entry.getValue());
            mergedMails.get(node).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(mergedMails.get(i).size() == 0)
                continue;
            Collections.sort(mergedMails.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it : mergedMails.get(i)) {
                temp.add(it);
            }
            ans.add(temp);
        }

        return ans;
    }
}