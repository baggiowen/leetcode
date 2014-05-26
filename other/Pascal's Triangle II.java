public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for(int i=1; i<=rowIndex; i++){ //rows  
            res.add(0,1); // add first element  
            for (int j=1; j<=i-1; j++){ //columns of ith row  
                res.set(j, res.get(j) + res.get(j+1));  
            }  
        }  
        return res;
    }
}
