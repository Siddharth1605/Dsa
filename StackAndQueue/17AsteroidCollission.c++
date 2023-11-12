class Solution {
public:

    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> st;
        for(int i=0;i<asteroids.size();i++)
        {
            bool flag = true;
            while(!st.empty() && st.top()>0 && asteroids[i] < 0)
            {
                if(st.top() < abs(asteroids[i])) st.pop();
                else if(st.top() == abs(asteroids[i])) {st.pop();    asteroids[i]=0;}
                else    {asteroids[i]=0;}
            }
            if(asteroids[i]!=0)
            st.push(asteroids[i]);
            
        }

        vector<int> ans;
        while(!st.empty())
        {
            ans.push_back(st.top());
            st.pop();
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};