public class HelloNumbers {
	public static void main(String[] args) {
		int x = 0;
		int cummSum = 0;
		while (x < 10) {
			cummSum = cummSum + x;
			System.out.print(cummSum + " " );

			x = x + 1;
		}
		System.out.println("");
	}
}