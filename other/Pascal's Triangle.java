public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        res.add(new ArrayList<Integer>(Arrays.asList(1)));
        int count = 1;
        while (count < numRows) {
            List<Integer> prev = res.get(count - 1);
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            int i = 0;
            while (i < prev.size() - 1) {
                cur.add(prev.get(i) + prev.get(i + 1));
                i++;
            }
            cur.add(1);
            res.add(cur);
            count++;
        }
        return res;
    }
}

//List to ArrayList
