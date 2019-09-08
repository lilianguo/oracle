class CountofSmallestNumbersAfterSelf {
    // time: O(n^2)
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> count = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    curr++;
                }
            }
            count.add(curr);
        }
        return count;
    }

    
}