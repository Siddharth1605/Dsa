class Pair {
    String word;
    int distance;
    public Pair(String word, int distance) {
        this.word = word;
        this.distance = distance;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String word : wordList)
            set.add(word);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        while(!queue.isEmpty()) {
            Pair top = queue.remove();
            int distance = top.distance;
            if(top.word.equals(endWord))
                return distance;
            for(int i=0;i<top.word.length();i++) {
                for(char j='a';j<='z';j++) {
                    char[] replaceArray = top.word.toCharArray();
                    replaceArray[i] = j;
                    String replacedWord = new String(replaceArray);
                    if(set.contains(replacedWord)) {
                        queue.add(new Pair(replacedWord, distance + 1));
                        set.remove(replacedWord);
                    }
                }
            }
        }
            return 0;

    }
}