/**
There are two properties in the node student id and scores, to ensure that each student will have at least 5 points, find the average of 5 highest scores for each person.
*/

/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> ret = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (Record r : results) {
            if (!map.containsKey(r.id)) {
                map.put(r.id, new PriorityQueue<Integer>());
            }
            PriorityQueue<Integer> pq = map.get(r.id);
            pq.offer(r.score);
            if (pq.size() > 5) {
                pq.poll();
            }
        }
        
        for (int id : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(id);
            double sum = 0;
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }
            ret.put(id, sum / 5);
        }
        return ret;
    }
}
