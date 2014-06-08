public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, target, 0, res, new ArrayList<Integer>());
        return res;
    }
    
    public void helper(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> path) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            List<Integer> temp = new ArrayList<Integer>(path);
            res.add(temp);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, res, path);
            path.remove(path.size() - 1);
        }
    }
}

//dfs + backtracing
