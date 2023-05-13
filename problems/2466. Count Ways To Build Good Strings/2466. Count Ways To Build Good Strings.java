class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
    int dp[] = new int[high+1],ans=0,mod = (int)1e9+7;
    Arrays.fill(dp,-1);
    dp[0]=1;
    for(int i=low;i<=high;i++){
        ans+=rec(i,zero,one,mod,dp);
        ans%=mod;
    } return ans;
}
int rec(int ind,int zero,int one,int mod,int dp[]){
    if(dp[ind]!=-1) return dp[ind];
    int cnt=0;
    if(ind>=zero) cnt+=rec(ind-zero,zero,one,mod,dp);
    if(ind>=one) cnt+=rec(ind-one,zero,one,mod,dp);
    return dp[ind]=(cnt%mod);
}
}