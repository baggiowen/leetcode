//Basic idea: For each number in the array, swap it with every element after it. To avoid duplicate, need to check it first.
//swap method
//cannot use "new ArrayList<Integer>(Arrays.asList(intArray))" to convert an int array to arraylist - because the type is int, not Integer
//http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/

//spent too much on this one!!!

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        getResult(num, 0, res);
        return res;
    }
    
    private void getResult(int[] num, int start, ArrayList<ArrayList<Integer>> res) {
        if (start == num.length - 1) {
            ArrayList<Integer> item = convertArrayToList(num);
            res.add(item);
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (!checkDup(num, start, i)) {
                swap(num, start, i);
                getResult(num, start + 1, res);
                swap(num, start, i);
            }
        }
        
    }
    
    private void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    
    private ArrayList<Integer> convertArrayToList(int[] num) {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int h = 0; h < num.length; h++) {
            item.add(num[h]);
        }
        return item;
    }
    
    private boolean checkDup(int[] num, int start, int end) {
        for (int i = start; i < end; i++) {
            if (num[i] == num[end]) {
                return true;
            }
        }
        return false;
    }
}
