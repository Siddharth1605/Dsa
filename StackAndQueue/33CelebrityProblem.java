 
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	Stack<Integer> st = new Stack<>();
    	for(int i=0;i<n;i++)
    	    st.push(i);
    	   
    	 while(st.size() > 1)
    	 {
    	    int a = st.pop();
    	    int b = st.pop();
    	     
    	    if(M[a][b] == 1)
    	        st.push(b);
    	   else
    	    st.push(a);
    	 
    	 }
    	 
    	 int x = st.peek();
        
        int z = 0;
        int c = 0;

        for(int i=0; i<n; i++) {
            if(M[x][i] == 0)
                z++;
            if(M[i][x] == 1)
                c++;
        }
        
        if(z!=n || c!=n-1)
            return -1;
        return x;
    }
}