class Solution {
    public String makeGood(String s) {
        List<Character> lt = new ArrayList<>();
        int n = s.length();
        lt.add(s.charAt(0));
        for(int i=1;i<n;i++)
        {
            if(lt.size() != 0 && Math.abs(lt.get(lt.size() - 1) - s.charAt(i)) == 32)
                lt.remove(lt.size() - 1);
            else
                lt.add(s.charAt(i));
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<lt.size();i++)
                ans.append(lt.get(i));
        return ans.toString();
    }
}