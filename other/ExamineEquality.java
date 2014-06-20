import java.util.HashSet;
import java.util.Set;


public class ExamineEquality
{
  public static boolean examine(String[] arr1, String[] arr2) {
    Set<Set<String>> set = new HashSet<Set<String>>();
    for (String str : arr1) {
      String a = str.substring(0, 1);
      String b = str.substring(1);
      boolean flag = false;
      for (Set<String> s : set) {
        if (s.contains(a) || s.contains(b)) {
          s.add(a);
          s.add(b);
          flag = true;
          break;
        }
      }
      if (!flag) {
        Set<String> s = new HashSet<String>();
        s.add(a);
        s.add(b);
        set.add(s);
      }
    }
    for (String str : arr2) {
      String a = str.substring(0, 1);
      String b = str.substring(1);
      for (Set<String> s : set) {
        if (s.contains(a) && s.contains(b)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public static void main(String[] args) {
    String[] arr1 = {"ab", "bc"};
    String[] arr2 = {"ac", "fr"};
    if (examine(arr1, arr2)) {
      System.out.println("true");
    }
    else {
      System.out.println("false");
    }
  }
}
