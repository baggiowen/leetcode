http://www.programcreek.com/2012/12/leetcode-word-ladder/

public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (dict.size() == 0) {
            return 0;
        }
        LinkedList<String> words = new LinkedList<String>();
        LinkedList<Integer> sum = new LinkedList<Integer>();
        
        words.add(start);
        sum.add(1);
        while (words.size() != 0) {
            String word = words.remove();
            int count = sum.remove();
            if (word.equals(end)) {
                return count;
            }
            for (int i = 0; i < word.length(); i++) {
                char[] array = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {
                    array[i] = j;
                    String newWord = new String(array);
                    if (dict.contains(newWord)) {
                        words.add(newWord);
                        sum.add(count + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}

//bfs
