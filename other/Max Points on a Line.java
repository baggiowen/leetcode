/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points.length <= 1) {
            return points.length;
        }
        int res = 1;
        ArrayList<Float> slope = null;
        for (Point p : points) {
            int dup = -1; //duplicated points
            int max = 0;
            int count = 1;
            slope = new ArrayList<Float>();
            for (Point q : points) {
                if (p.x - q.x == 0) {
                    if (p.y - q.y == 0) {
                        dup++;
                    }
                    else {
                        slope.add(Float.MAX_VALUE);
                    }
                }
                else {
                    slope.add((float)(q.y - p.y) / (float)(q.x - p.x));
                }
            }
            Collections.sort(slope);
            for(int i = 1; i < slope.size(); i++) {
                if (Float.compare(slope.get(i), slope.get(i - 1)) == 0) { //compare float
                    count++;
                }
                else {
                    max = Math.max(count, max);
                    count = 1;
                }
            }
            if (slope.size() > 0) {
                max = Math.max(count, max);
            }
            res = Math.max(max + dup + 1, res);
        }
        return res;
    }
}

//for each point, compute the slope with other points
