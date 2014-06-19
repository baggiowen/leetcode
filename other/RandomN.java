import java.util.HashMap;
import java.util.Random;


public class RandomN {
	
	public static int rand2() {
		Random random = new Random();
		while (true) {
			int res = 2 * random.nextInt(2) + random.nextInt(2);
			if (res <= 2) {
				return res;
			}
		}
	}
	
	public static int randN(int n) {
		Random random = new Random();
		if (n < 0) {
			return -1;
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return random.nextInt(2);
		}

		int pow = 0;
		while (Math.pow(2, pow) - 1 < n) {
			pow++;
		}
		while (true) {
			int res = 0;
			for (int i = 0; i < pow; i++) {
				res += Math.pow(2, i) * random.nextInt(2);
			}
			if (res <= n) {
				return res;
			}
		}
	}
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 300000; i++) {
			int num = randN(3);
			//System.out.println(num);
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			}
			else {
				map.put(num, 1);
			}
		}
		System.out.print(map.toString());
	}
	
}
