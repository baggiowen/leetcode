public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int i = 0; i < S.length; i++) {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> list : res) {
                current.add(new ArrayList<Integer>(list));
            }
            for (ArrayList<Integer> list : current) {
                list.add(S[i]);
                res.add(list);
            }
        }
        return res;
    }
}

//doesn't have to be recursive
//has to create new object for each inside item
