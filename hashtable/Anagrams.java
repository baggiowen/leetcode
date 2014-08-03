=============
first attempt
=============
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> results = new ArrayList<String>();
        if (strs.length == 0) {
            return results;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //ArrayList<String> buffer = new ArrayList<String>();
        String s;
        char[] sorted;
        for (int i = 0; i < strs.length; i++) {
            sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            s = new String(sorted);
            if (map.containsKey(s)) {
                map.put(s, map.get(s)+1);
            }
            else {
                map.put(s,1);
            }
        }
        for (int i = 0; i <strs.length; i++) {
            sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            s = new String(sorted);
            if (map.get(s) > 1) {
                results.add(strs[i]);
            }
        }
        
        return results;
        
    }
}

//create a map, key is sorted string, first iteration count the occurrence
//second occurrence if the occurrence larger than 2, add to result

===============
second attempt
===============
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String str = new String(array);
            if (map.containsKey(str)) {
                res.add(strs[i]);
                if (map.get(str) != " ") {
                    res.add(map.get(str));
                    map.put(str, " ");
                }
            }
            else {
                map.put(str, strs[i]);
            }
        }
        return res;
    }
}

//create map<String, String>, the value is the first occurrence
//only one iteration

=============
third attempt
=============
public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if (strs.length == 0) {
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            }
            else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(key, list);
            }
        }
        
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            List<String> list = (ArrayList<String>)it.next();
            if (list.size() > 1) {
                res.addAll(list);
            }
        }
        return res;
    }
}
