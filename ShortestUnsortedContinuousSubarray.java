/*
Given an integer array, you need to find one continuous subarray that 
if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
*/

// [2,1] 

class ShortestUnsortedContinuousSubarray {
    // 581. Shortest Unsorted Continuous Subarray
    // nlogn using sort
    public int findUnsortedSubarrayII(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    /*

    下面这种方法很叼啊，是O(n)的时间复杂度加上O(1)的空间复杂度，
    博主觉得这实际上是对上面的那种方法进行空间上的优化的结果，用两个变量mx和mn来代替上面的有序数组，
    我们仔细来分析发现，最小值mn初始化为数组的最后一个数字，最大值mx初始化为了第一个数字，
    然后我们从第二个数字开始遍历，
    mx和nums[i]之间取较大值赋值给mx，然后比较此时mx和nums[i]之间的大小关系，如果mx大于nums[i]，就把i赋值给end，
    那么我们想如果第一个数字小于第二个，mx就会赋值为第二个数字，这时候mx和nums[i]就相等了，不进行任何操作，这make sense，因为说明此时是有序的。
    mn和nums[n-1-i]之间取较小值赋给mn，然后比较此时mn和nums[n-1-i]之间的大小关系，如果mn小于nums[n-1-i]，就把n-1-i赋值给start，
    那么什么时候会进行赋值呢，是当倒数第二个数字大于最后一个数字，这样mn还是最后一个数字，而nums[n-1-i]就会大于mn，这样我们更新start。
    我们可以看出start是不断往前走的，end是不断往后走的，整个遍历完成后，start和end就分别指向了最短无序连续子数组的起始和结束位置，参见代码如下：

    

    解法三：

    class Solution {
    public:
        int findUnsortedSubarray(vector<int>& nums) {
            int n = nums.size(), start = -1, end = -2;
            int mn = nums[n - 1], mx = nums[0];
            for (int i = 1; i < n; ++i) {
                mx = max(mx, nums[i]);
                mn = min(mn, nums[n - 1 - i]);
                if (mx > nums[i]) end = i;
                if (mn < nums[n - 1 - i]) start = n - 1 - i;
            }
            return end - start + 1;
        }
    };

*/
}