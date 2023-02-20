class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            // mid = start + (end-start)/2 , here start + because we will get a min value and that we have to add with start , we will get correct mid
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid-1;
            else start = mid + 1;
        }

        return start;
    }
}