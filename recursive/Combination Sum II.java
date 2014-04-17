public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        getResult(num, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void getResult(int[] num, int target, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(path);
            if (!result.contains(temp)) {
                result.add(temp);
            }
        }
        else {
            for (int i = start; i < num.length; i++) {
                path.add(num[i]);
                getResult(num, target - num[i], i + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}

//similar to Combination Sum
