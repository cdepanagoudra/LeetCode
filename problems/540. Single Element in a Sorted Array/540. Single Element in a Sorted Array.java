class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start =0;
        int end=nums.length-1;
        int n=nums.length;
        
        while(start < end){
            int mid = start + (end-start)/2;
            if(mid%2==0 && mid+1<n && nums[mid] == nums[mid+1] || mid%2==1 && mid -1 >=0 && nums[mid] == nums[mid-1]  ){
                start = mid +1;
            }
            else {
                end = mid;
            }
            if(mid -1 >= 0 && mid + 1<n && nums[mid]!=nums[mid-1] && nums[mid] != nums[mid+1]) return nums[mid];
        }
        return nums[start];
    }
}