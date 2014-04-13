=====================================
first attempt - use hashmap - timeout
=====================================

========================
second attempt
========================

import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (num.length < 3) {
            return result;
        }
        
        Arrays.sort(num);
        
        for (int i = 0; i < num.length - 2; i++) {
            if (i == 0 || num[i] > num[i - 1]) { //remove duplicates
                int start = i + 1;
                int end = num.length - 1;
                int target = -num[i];
                while (start < end) {
                    if (num[start] + num[end] == target) {
                        ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(num[i], num[start], num[end]));
                        result.add(temp);
                        start++;
                        end--;
                        while (start < end && num[start] == num[start-1]) { //remove duplicates
                            start++;
                        }
                        while (start < end && num[end] == num[end+1]) { //remove duplicates
                            end--;
                        }
                    }
                    else if (num[start] + num[end] > target) {
                        end--;
                    }
                    else {
                        start++;
                    }
                }
            }
        }
        return result;
    }

}

//solution: sort array; 
//some key points to remove duplicates
