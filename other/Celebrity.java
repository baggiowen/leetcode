//http://www.geeksforgeeks.org/the-celebrity-problem/


//first method: use the idea of graph, record inbound and outbound
public static Person find(List<Person> ppl) {
  HashMap<Person, Integer> graph = new HashMap<Person, Integer>();
  for (Person p : ppl) {
    graph.put(p, 0);
  }
  
  for (int i = 0; i < ppl.size(); i++) {
    Person p1 = ppl.get(i);
    for (int j = 0; j < ppl.size(); j++) {
      Person p2 = ppl.get(j);
      if (p1 != p2) {
        if (know(p1, p2)) {
          graph.put(p1, graph.get(p1) - 1);
          graph.put(p2, graph.get(p2) + 1);
        }
      }
    }
  }
  
  int n = ppl.size();
  for (Map.Entry<Person, Integer> entry : map.entrySet()) {
    if (entry.getValue() == n - 1) {
      return entry.getKey();
    }
  }
  return null;
}


//second method: use a stack
public static Person find(List<Person> ppl) {
    Stack<Person> stack = new Stack<Person>();
    for (Person p : ppl) {
      stack.push(p);
    }
    Person p1 = stack.pop();
    Person p2 = null;
    while (!stack.empty()) {
      p2 = stack.pop();
      if (know(p1, p2)) {
        p1 = p2;
      }
    }
    for (Person p : ppl) {
      if (p != p1) {
        if (!know(p, p1) || know(p1, p)) {
          return null;
        }
      }
    }
    return p1;
}
