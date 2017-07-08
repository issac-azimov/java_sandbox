public class findMax {
	public static int max(int[] m) {
		int initialMax = 0;
		for (int item : m) {
			if (item >= initialMax) {
				initialMax = item;
			}
		}
		return initialMax;
	}
	public static void main(String[] args) {
		int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(numbers));
	}
}