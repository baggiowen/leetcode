//http://codeganker.blogspot.com/2014/04/subsets-ii-leetcode.html

public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        if (num == null || num.length == 0) {
            return res;
        }
        Arrays.sort(num);
        int start = 0;
        ArrayList<ArrayList<Integer>> cur = null;
        for (int i = 0; i < num.length; i++) {
            cur = new ArrayList<ArrayList<Integer>>();
            int size = res.size();
            for (int j = start; j < res.size(); j++) {
                cur.add(new ArrayList<Integer>(res.get(j)));
            }
            for (ArrayList<Integer> list : cur) {
                list.add(num[i]);
                res.add(list);
            }
            if (i < num.length - 1) {
                if (num[i] == num[i + 1]) {
                    start = size;
                }
                else {
                    start = 0;
                }
            }
        }
        return res;
    }
}
