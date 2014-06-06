public class Solution {
    public int sqrt(int x) {
        long start = 0;
        long end = x;
        while (start <= end) {
            long mid = (start + end) / 2;
            long pow = mid * mid;
            if (pow < x) {
                start = mid + 1;
            }
            else if (pow > x) {
                end = mid - 1;
            }
            else {
                return (int)mid;
            }
        }
        return (int)(start - 1);
    }
}

//binary search
//switch int to long to avoid overflow
//it's ok to compare int to long
//don't forget to case back
//while condition start <= end
//last: start - 1
