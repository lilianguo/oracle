/*

// 128
For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/
class LongestConsecutiveSequence {

    // nlogn 先排序，后traverse
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        Arrays.sort(nums);
        int curr = 0;
        for (int i = 0;  i < nums.length; i++) {
            if (i == 0) {
                curr = 1;
                max = Math.max(curr, max);
                continue;
            }
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                curr++;
                max = Math.max(curr, max);
                continue;
            }
            curr = 1;
            max = Math.max(curr, max);
        }
        return max;
    }

    // O(n)
    public int longestConsecutiveII(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(nums[i]);
        }
        int max = 0;
        for (int start : numbers) {
            // it is a start of a consecutive sequence
            if (!numbers.contains(start - 1)) {
                int curr = start;
                int len = 1;
                while (numbers.contains(curr + 1)) {
                    len++;
                    curr++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}