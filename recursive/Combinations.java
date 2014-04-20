public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (n == 0 || k == 0) {
            return res;
        }
        getResult(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }
    
    public void getResult(int n, int k, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (k == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(path);
            res.add(temp);
        }
        else {
            for (int i = start; i <= n; i++) {
                path.add(i);
                getResult(n, k - 1, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }
}
