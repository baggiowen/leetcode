http://fisherlei.blogspot.com/2013/11/leetcode-gas-station-solution.html

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        for (int i = 0; i < diff.length; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int start = 0;
        int sum = 0;
        int leftGas = 0
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            leftGas += diff[i];
            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }
        if (leftGas < 0) {
            return -1;
        }
        return start;
    }
}
