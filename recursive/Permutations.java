public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        return getResult(num, num.length - 1);
    }
    
    public ArrayList<ArrayList<Integer>> getResult(int[] num, int index) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (index < 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        ArrayList<ArrayList<Integer>> prev = getResult(num, index - 1);
        
        for (ArrayList<Integer> item : prev) {
            for (int i = 0; i <= item.size(); i++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(item);
                temp.add(i, num[index]);
                res.add(temp);
            }
        }
        return res;
    }
}
