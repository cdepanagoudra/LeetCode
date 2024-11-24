
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // Ensure nums1 is the smaller array
    if (nums1.length > nums2.length) {
        int[] temp = nums1;
        nums1 = nums2;
        nums2 = temp;
    }

    int m = nums1.length, n = nums2.length;
    int low = 0, high = m;
    int mid = (m + n + 1) / 2;  // The partition will divide the array in half

    while (low <= high) {
        int i = (low + high) / 2;  // Partition index for nums1
        int j = mid - i;  // Partition index for nums2

        // Check if the partition is valid
        if (i < m && nums1[i] < nums2[j-1]) {
            // We need to move the partition to the right
            low = i + 1;
        } else if (i > 0 && nums1[i-1] > nums2[j]) {
            // We need to move the partition to the left
            high = i - 1;
        } else {
            // Valid partition, calculate the median
            int maxLeft = 0;
            if (i == 0) maxLeft = nums2[j-1];
            else if (j == 0) maxLeft = nums1[i-1];
            else maxLeft = Math.max(nums1[i-1], nums2[j-1]);

            if ((m + n) % 2 == 1) {
                return maxLeft;
            }

            int minRight = 0;
            if (i == m) minRight = nums2[j];
            else if (j == n) minRight = nums1[i];
            else minRight = Math.min(nums1[i], nums2[j]);

            return (maxLeft + minRight) / 2.0;
        }
    }

    return 0.0;
}

