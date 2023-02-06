class Solution {
    public int[] shuffle(int[] nums, int n) {
        for(int i = 0;i<n;i++)
		{
			nums[n+i] += nums[i]*1005;
			
		}

		for(int i = 0; i<n;i++) {
			nums[2*i] = nums[n+i]/1005;
			nums[2*i+1]=nums[n+i]%1005;
		}
		return nums;
    }
}
// nums=[   .   .   . (2*1005)+3 .(5*1005)+4 .(1*1005)+7.]
//nums=[ 2 , 3, 5, 4]