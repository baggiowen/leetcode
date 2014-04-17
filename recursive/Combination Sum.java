import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        getResult(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void getResult(int[] candidates, int target, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(path);
            res.add(temp);
        }
        else {
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            getResult(candidates, target - candidates[i], i, path, res);
            path.remove(path.size() - 1);
        }
        }
    }
}

//dfs
