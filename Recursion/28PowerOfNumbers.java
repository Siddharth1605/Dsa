class Solution {
    public static double powerx(double x,int n){
    if(n==0)
    return 1;
    else if(n%2==0){
        double y=powerx(x,n/2);
        return y*y;
    }
    else{
        double y=powerx(x,n/2);
        return y*y*x;
    }
    
}
    public double myPow(double x, int n) {
        return (n>=0) ?  powerx(x, n) : 1 / powerx(x, n);
    }
}