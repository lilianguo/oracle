/*
47. Permutations
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
class Permutations {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), visited, res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> curr, boolean[] visited, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && visited[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }
            curr.add(nums[i]);
            visited[i] = true;
            dfs(nums, curr, visited, res);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
        return;
    }
}