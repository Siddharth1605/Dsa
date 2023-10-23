class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int lastfruit = -1;
        int secondlastfruit = -1;
        int lastfruitcount = 0;
        int ans = 0;
        int currentmax = 0;

        for(auto fruit : fruits)
        {

            if(fruit == lastfruit || fruit == secondlastfruit)
                currentmax += 1;
            else
                currentmax = lastfruitcount + 1;
            
            if(fruit == lastfruit)
                lastfruitcount += 1;
            else    
                lastfruitcount = 1;
            
            if(fruit != lastfruit)
            {
                secondlastfruit = lastfruit;
                lastfruit = fruit;
            }
            ans = max(ans, currentmax);
        }
        return ans;
    }
};