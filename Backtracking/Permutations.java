
/*
46. Permutations
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/
class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), visited, res);
        return res;
    }

    private void dfs(int[] nums, List<Integer> curr, boolean[] visited, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
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