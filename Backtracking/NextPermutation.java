/*
31. Next Permutation
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

1 3 5 4 2
先把后半段降序的部分reverse成升序，变成： 1 3 2 4 5
这个时候，如果前半段不为空，
需要找到后半段比前半段最后一个数大的最小的数，也就是要找到 2 4 5中比3大的最小的数，也就是4， 然后做swap，就得到结果
因为后半段是有序的，是升序的， 所以出现的第一个比3大的就是我们需要swap的点

*/
class NextPermutation {
    public void swapItem(int[] nums, int i, int j) {
        int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	public void swapList(int[] nums, int i, int j) {
		while (i < j) {
			swapItem(nums, i, j);
			i ++; j --;
		}
	}
    public int[] nextPermutation(int[] nums) {
		int len = nums.length;
		if ( len <= 1)
			return nums;
		int i = len - 1;
		while (i > 0 && nums[i] <= nums[i - 1])
			i --;
		swapList(nums, i, len - 1);
        System.out.println("i = " + i);
		if (i != 0) {
			int j = i;
			while (nums[j] <= nums[i - 1]) j++;
			swapItem(nums, j, i-1);
		}
		return nums;
    }
}