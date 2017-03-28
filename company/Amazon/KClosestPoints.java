/**
Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.

Example
Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
return [[1,1],[2,5],[4,4]]
*/

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
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point globalOrigin = null;
    public Point[] kClosest(Point[] points, Point origin, int k) {
        globalOrigin = origin;
        Comparator<Point> comp = new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                int diff = distance(b, globalOrigin) - distance(a, globalOrigin);
                if(diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {
                    diff = b.y - a.y;
                }
                return diff;
            }
        };
        PriorityQueue<Point> pq = new PriorityQueue<>(k, comp);
        for (Point p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        Point[] result = new Point[k];
        while (k - 1 >= 0) {
            result[--k] = pq.poll();
        }
        return result;
    }
    
    private int distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}
