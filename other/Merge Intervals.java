/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            return res;
        }
        if (intervals.size() == 1) {
            return intervals;
        }
        
        Comparator<Interval> comparator = new Comparator<Interval>() {
          public int compare (Interval i1, Interval i2) {
              if (i1.start < i2.start) {
                  return -1;
              }
              else if (i1.start > i2.start) {
                  return 1;
              }
              else {
                  return i1.end - i2.end;
              }
          }
        };
        
        Collections.sort(intervals, comparator);
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= end) {
                end = Math.max(end, intervals.get(i).end);
            }
            else {
                res.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}

//create a comparator to sort intervals - Collections.sort(intervals, comparator)
//don't forget to add the last interval
//update end value if necessary - end = Math.max(end, intervals.get(i).end);
//for each interval, compare its start to current end value to decide what to do
