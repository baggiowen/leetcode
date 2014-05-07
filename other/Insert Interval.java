http://www.programcreek.com/2012/12/leetcode-insert-interval/

public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                res.add(interval);
            }
            else if (interval.start > newInterval.end) {
                res.add(newInterval);
                newInterval = interval;
            }
            else if (interval.end >= newInterval.start || newInterval.end >= interval.start) {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
        }
        res.add(newInterval);
        return res;
    }
}

//3 cases; order matters
//don't forget to add the last interval out of for loop
