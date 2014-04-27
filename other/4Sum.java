public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                
                int l = j + 1;
                int r = num.length - 1;
                while (l < r) {
                    int sum = num[i] + num[j] + num[l] + num[r];
                    if (sum < target) {
                        l++;
                    }
                    else if (sum > target) {
                        r--;
                    }
                    else {
                        ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[l], num[r]));
                        if (!res.contains(temp)) {
                            res.add(temp);
                        }
                        l++;
                        r--;
                    }
                }
            }
        }
        return res;
    }
}

//two pointers
