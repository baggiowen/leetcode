//iterative
public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>());
        ArrayList<ArrayList<Integer>> cur = null;
        for (int i = 0; i < num.length; i++) {
            cur = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> list : res) {
                for (int j = 0; j <= list.size(); j++) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(list);
                    temp.add(j, num[i]);
                    cur.add(temp);
                }
            }
            res = new ArrayList<ArrayList<Integer>>(cur);
        }
        return res;
    }
}

//recursive
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
