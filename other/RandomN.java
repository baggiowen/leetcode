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
	
	public static int rand4() {
		while (true) {
			int res = 3 * rand2() + rand2();
			if (res <= 4) {
				return res;
			}
		}
	}
	
	public static int randN(int n) {
		if (n == 1) {
			return new Random().nextInt(2);
		}
		int square = (int)Math.sqrt(n);
		while (true) {
			int res = (square + 1) * randN(square) + randN(square);
			if (res <= n) {
				return res;
			}
		}
	}
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 10000; i++) {
			int num = randN(17);
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
