class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] arr = new int[m][n];
        for(int i=0;i<n;i++)
            arr[0][i] = Character.getNumericValue(matrix[0][i]);     

        for(int i=1;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                arr[i][j] = (matrix[i][j] == '1') ? arr[i - 1][j] + 1 : 0;
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int ans = 0;
        for(int j=0;j<m;j++)
        {
            int area = 0;
            int x = 0;


            Stack<Integer> prev = new Stack<>();
            Stack<Integer> next = new Stack<>();

            int[] left = new int[n];
            int[] right = new int[n];

            for(int i=0;i<n;i++)
            {
                while(!prev.isEmpty() && arr[j][i] <= arr[j][prev.peek()])
                    prev.pop();
                
                if(prev.isEmpty())
                    left[i] = -1;
                else
                    left[i] = prev.peek();
                prev.push(i);
            }

            for(int i=n-1;i>=0;i--)
            {
                while(!next.isEmpty() && arr[j][i] <= arr[j][next.peek()])
                    next.pop();
                
                if(next.isEmpty())
                    right[i] = n;
                else
                    right[i] = next.peek();
                next.push(i);
            }

            for(int i=0;i<n;i++)
            {
                x = (right[i] - left[i] - 1) * arr[j][i];
                area = Math.max(area, x);
            }

            ans = Math.max(ans, area);
        }

        return ans;
    }
}