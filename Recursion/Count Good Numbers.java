class Solution {
    long p = 1000000007;
    public long power(long x,long y){
        long res = 1;
        //variable
        if(x==0){
            return 0;
        }
        while(y>0){
            if((y&1)==1){
                res = (res*x)%p;
            }
            y = y>>1;
            x = (x*x)%p;
        }
        return  res;
    }
    public int countGoodNumbers(long n) {
        long count_4 = n/2;
        long count_5 = n - count_4;
        long ans = (((power(4, count_4) % p)  * (power(5, count_5) % p) % p));
       
        return (int) ans;
    }
}