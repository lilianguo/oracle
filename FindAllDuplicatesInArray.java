/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?
*/
// 442
class FindAllDuplicatesInArray {
    public List<Integer> findDuplicates(int[] nums) { 
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
                continue;
            }
            list.add(nums[i]);
        }
        return list;
    }

    // no extra space, do not understand
    //https://www.jiuzhang.com/solution/find-all-duplicates-in-an-array/
    public List<Integer> findDuplicatesII(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return res;
    }
}