class FindMinimumInRotatedSortedArray {
    // O(n) solution traverse the array to get the minimum value
    // when the array contains duplicate number, worst case would reach O(n)
    public int findMinI(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = Math.min(min, nums[i]);
            }
        }
        return min;
    }

    // binary search O(logn)
    // [1,2,3]
    // [3,4,5,1,2]
    public int findMinII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0, end =  nums.length - 1;
        int target = nums[nums.length - 1];
        while(start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}